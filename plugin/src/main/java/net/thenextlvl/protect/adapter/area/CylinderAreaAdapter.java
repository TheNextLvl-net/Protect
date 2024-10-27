package net.thenextlvl.protect.adapter.area;

import com.sk89q.worldedit.regions.CylinderRegion;
import net.thenextlvl.protect.ProtectPlugin;
import net.thenextlvl.protect.area.CraftAreaCreator;
import net.thenextlvl.protect.area.CraftCylinderArea;
import org.jetbrains.annotations.NotNull;

public class CylinderAreaAdapter extends RegionizedAreaAdapter<CylinderRegion, CraftCylinderArea> {
    public CylinderAreaAdapter(@NotNull ProtectPlugin plugin) {
        super(plugin, "cylinder");
    }

    @Override
    protected @NotNull CraftCylinderArea construct(@NotNull CraftAreaCreator<CylinderRegion> creator) {
        return new CraftCylinderArea(creator.plugin(), creator);
    }
}
