package net.thenextlvl.protect.command;

import cloud.commandframework.Command;
import cloud.commandframework.arguments.standard.StringArgument;
import cloud.commandframework.context.CommandContext;
import lombok.RequiredArgsConstructor;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import net.thenextlvl.protect.ProtectPlugin;
import net.thenextlvl.protect.area.Area;
import net.thenextlvl.protect.area.RegionizedArea;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;

@RequiredArgsConstructor
class AreaInfoCommand {
    private final ProtectPlugin plugin;

    Command.Builder<CommandSender> create(Command.Builder<CommandSender> builder) {
        return builder.literal("info")
                .argument(StringArgument.<CommandSender>builder("area")
                        .withSuggestionsProvider((context, token) -> plugin.areaProvider().getAreas()
                                .map(Area::getName)
                                .filter(s -> s.startsWith(token))
                                .toList())
                        .asOptional().build())
                .handler(this::execute);
    }

    @SuppressWarnings("PatternValidation")
    private void execute(CommandContext<CommandSender> context) {
        var sender = context.getSender();
        var name = context.<String>get("area");
        // todo pattern validation
        var area = context.contains("area") ? plugin.areaProvider().getArea(name).orElse(null) :
                sender instanceof Entity entity ? plugin.areaProvider().getArea(entity) : null;
        if (area != null) sendInfo(sender, area);
        else plugin.bundle().sendMessage(sender, "command.area.info");
    }

    private void sendInfo(CommandSender sender, Area area) {
        plugin.bundle().sendMessage(sender, "area.info.name",
                Placeholder.parsed("area", area.getName()));
        plugin.bundle().sendMessage(sender, "area.info.world",
                Placeholder.parsed("world", area.getWorld().getName()));
        plugin.bundle().sendMessage(sender, "area.info.priority",
                Placeholder.parsed("priority", String.valueOf(area.getPriority())));
        if (!(area instanceof RegionizedArea<?> regionizedArea)) return;
        plugin.bundle().sendMessage(sender, "area.info.bounds",
                Placeholder.parsed("bounds", regionizedArea.getRegion().getMinimumPoint().toParserString()
                        + " - " + regionizedArea.getRegion().getMaximumPoint().toParserString()));
    }
}
