package net.thenextlvl.protect.event;

import lombok.Getter;
import lombok.Setter;
import net.thenextlvl.protect.area.Area;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;

/**
 * This event is triggered whenever a player transitions to a new area.
 */
@Getter
@Setter
public class PlayerAreaTransitionEvent extends PlayerAreaEvent implements Cancellable {
    private final Area previous;
    private boolean cancelled;

    public PlayerAreaTransitionEvent(Player player, Area from, Area to) {
        super(player, to);
        this.previous = from;
    }
}
