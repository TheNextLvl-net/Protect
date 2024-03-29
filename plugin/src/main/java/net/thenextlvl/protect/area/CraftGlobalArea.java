package net.thenextlvl.protect.area;

import core.annotation.FieldsAreNotNullByDefault;
import core.annotation.MethodsReturnNotNullByDefault;
import core.annotation.ParametersAreNotNullByDefault;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@FieldsAreNotNullByDefault
@MethodsReturnNotNullByDefault
@ParametersAreNotNullByDefault
public class CraftGlobalArea extends CraftArea implements GlobalArea {
    private static final Map<World, CraftGlobalArea> globalAreas = new HashMap<>();

    @SuppressWarnings("PatternValidation")
    private CraftGlobalArea(World world, int priority) {
        super("@" + world.getName(), world, priority);
    }

    private CraftGlobalArea(World world) {
        this(world, -1);
    }

    @Override
    public boolean contains(Location location) {
        return getWorld().equals(location.getWorld());
    }

    @Override
    public boolean contains(Block block) {
        return getWorld().equals(block.getWorld());
    }

    @Override
    public boolean contains(Entity entity) {
        return getWorld().equals(entity.getWorld());
    }

    @Override
    public List<Entity> getEntities() {
        return getWorld().getEntities();
    }

    @Override
    public List<Player> getPlayers() {
        return getWorld().getPlayers();
    }

    public static CraftGlobalArea of(World world, int priority) {
        return globalAreas.computeIfAbsent(world, w -> new CraftGlobalArea(w, priority));
    }

    public static CraftGlobalArea of(World world) {
        return globalAreas.computeIfAbsent(world, CraftGlobalArea::new);
    }
}
