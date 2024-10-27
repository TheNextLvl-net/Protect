package net.thenextlvl.protect.adapter.area;

import com.google.common.reflect.TypeToken;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import lombok.Getter;
import lombok.experimental.Accessors;
import net.thenextlvl.protect.ProtectPlugin;
import net.thenextlvl.protect.area.CraftGlobalArea;
import net.thenextlvl.protect.flag.Flag;
import net.thenextlvl.protect.io.AreaAdapter;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;


@Accessors(fluent = true)
public class GlobalAreaAdapter implements AreaAdapter<CraftGlobalArea> {
    private final @Getter NamespacedKey key;
    private final ProtectPlugin plugin;

    public GlobalAreaAdapter(ProtectPlugin plugin) {
        this.key = new NamespacedKey(plugin, "global");
        this.plugin = plugin;
    }

    @Override
    public @NotNull CraftGlobalArea deserialize(@NotNull JsonObject object, @NotNull World world, @NotNull JsonDeserializationContext context) {
        var priority = object.get("priority").getAsInt();
        var flags = context.<Map<Flag<?>, @Nullable Object>>deserialize(object.get("flags"), LinkedHashMap.class);
        var members = Objects.<Set<UUID>>requireNonNullElseGet(context.deserialize(object.get("members"), new TypeToken<Set<UUID>>() {
        }.getType()), HashSet::new);
        var owner = object.has("owner") ? context.<UUID>deserialize(object.get("owner"), UUID.class) : null;
        return new CraftGlobalArea(plugin, world, members, owner, flags, priority);
    }

    @Override
    public @NotNull JsonObject serialize(@NotNull CraftGlobalArea area, @NotNull JsonSerializationContext context) {
        var object = new JsonObject();
        area.getOwner().ifPresent(owner -> object.add("owner", context.serialize(owner)));
        object.add("flags", context.serialize(area.getFlags()));
        object.add("members", context.serialize(area.getMembers()));
        object.addProperty("priority", area.getPriority());
        return object;
    }
}
