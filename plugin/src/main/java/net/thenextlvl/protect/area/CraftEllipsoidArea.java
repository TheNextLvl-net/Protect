package net.thenextlvl.protect.area;

import com.sk89q.worldedit.regions.EllipsoidRegion;
import com.sk89q.worldedit.regions.selector.EllipsoidRegionSelector;
import core.annotation.TypesAreNotNullByDefault;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import net.thenextlvl.protect.ProtectPlugin;
import net.thenextlvl.protect.flag.Flag;
import org.bukkit.World;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

@TypesAreNotNullByDefault
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CraftEllipsoidArea extends CraftRegionizedArea<EllipsoidRegion> implements EllipsoidArea {
    public CraftEllipsoidArea(ProtectPlugin plugin,
                           @NamePattern.Regionized String name,
                           World world,
                           EllipsoidRegion region,
                           int priority,
                           @Nullable @NamePattern.Regionized String parent,
                           @Nullable UUID owner,
                           Set<UUID> members,
                           Map<Flag<?>, @Nullable Object> flags) {
        super(plugin, name, world, region, priority, parent, owner, members, flags);
    }

    public CraftEllipsoidArea(CraftAreaCreator<EllipsoidRegion> creator) {
        super(creator);
    }

    @Override
    public EllipsoidRegionSelector getRegionSelector() {
        return new EllipsoidRegionSelector(
                getRegion().getWorld(),
                getRegion().getCenter().toBlockPoint(),
                getRegion().getRadius()
        );
    }
}
