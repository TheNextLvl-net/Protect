package net.thenextlvl.protect.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.sk89q.worldedit.IncompleteRegionException;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import lombok.RequiredArgsConstructor;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import net.thenextlvl.protect.ProtectPlugin;
import net.thenextlvl.protect.area.NamePattern;
import net.thenextlvl.protect.exception.UnsupportedRegionException;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
@SuppressWarnings("UnstableApiUsage")
class AreaCreateCommand {
    private final ProtectPlugin plugin;

    LiteralArgumentBuilder<CommandSourceStack> create() {
        return Commands.literal("create")
                .requires(stack -> stack.getSender() instanceof Player player
                                   && player.hasPermission("protect.command.area.create"))
                .then(Commands.argument("name", StringArgumentType.string())
                        .then(Commands.argument("priority", IntegerArgumentType.integer())
                                .executes(context -> {
                                    var priority = context.getArgument("priority", int.class);
                                    return execute(context, priority);
                                }))
                        .executes(context -> execute(context, 0)));
    }

    @SuppressWarnings("PatternValidation")
    private int execute(CommandContext<CommandSourceStack> context, int priority) {
        var player = (Player) context.getSource().getSender();
        var name = context.getArgument("name", String.class);

        if (!name.matches(NamePattern.Regionized.PATTERN)) {
            plugin.bundle().sendMessage(player, "area.name.pattern",
                    Placeholder.parsed("pattern", NamePattern.Regionized.PATTERN));
            return 0;
        }

        if (plugin.areaProvider().getArea(name).isPresent()) {
            plugin.bundle().sendMessage(player, "area.exists", Placeholder.parsed("area", name));
            return 0;
        }

        try {
            var session = WorldEditPlugin.getInstance().getSession(player);
            var creator = plugin.areaService().creator(
                    name, player.getWorld(), session.getSelection()
            ).priority(priority).create();
            plugin.bundle().sendMessage(player, "area.created",
                    Placeholder.parsed("area", creator.getName()));
            return Command.SINGLE_SUCCESS;
        } catch (UnsupportedRegionException e) {
            plugin.bundle().sendMessage(player, "region.unsupported",
                    Placeholder.parsed("type", e.getType().getSimpleName()));
            return 0;
        } catch (IncompleteRegionException ignored) {
            plugin.bundle().sendMessage(player, "region.select");
            return 0;
        }
    }
}
