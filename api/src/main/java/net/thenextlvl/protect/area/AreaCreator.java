package net.thenextlvl.protect.area;

import com.sk89q.worldedit.regions.Region;
import net.thenextlvl.protect.exception.CircularInheritanceException;
import net.thenextlvl.protect.exception.UnsupportedRegionException;
import net.thenextlvl.protect.flag.Flag;
import net.thenextlvl.protect.flag.FlagProvider;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * The AreaCreator interface provides methods for creating  {@link RegionizedArea regionized areas}.
 * It allows setting various properties of the area such as name, owner, parent, priority, region, and world.
 *
 * @param <T> The type of the region associated with the area.
 */
public interface AreaCreator<T extends Region> {
    /**
     * Retrieves the name of the area.
     *
     * @return the name of the area as a string
     * @see RegionizedArea#getName()
     */
    @NotNull String name();

    /**
     * Retrieves the owner of the area.
     *
     * @return the UUID of the owner, or null
     * @see RegionizedArea#getOwner()
     */
    @Nullable UUID owner();

    /**
     * Creates a copy of the current AreaCreator instance.
     *
     * @return a new AreaCreator instance that is a copy of the current instance
     */
    @NotNull AreaCreator<T> copy();

    /**
     * Sets the flags for the area being created.
     *
     * @param flags a Map where keys are Flag instances and values are associated values for those flags.
     *              The value can be null.
     * @return the AreaCreator instance with the specified flags set
     * @see FlagProvider#setFlags(Map)
     */
    @NotNull AreaCreator<T> flags(@NotNull Map<@NotNull Flag<?>, @Nullable Object> flags);

    /**
     * Sets the name for the area being created.
     *
     * @param name the name of the area.
     * @return the AreaCreator instance with the specified name set
     * @see RegionizedArea#getName()
     */
    @NotNull AreaCreator<T> name(@NotNull String name);

    /**
     * Sets the owner for the area being created.
     *
     * @param owner the UUID of the area's owner, or null if there is no owner
     * @return the AreaCreator instance with the specified owner set
     * @see RegionizedArea#setOwner(UUID)
     */
    @NotNull AreaCreator<T> owner(@Nullable UUID owner);

    /**
     * Sets the parent identifier for the area being created.
     *
     * @param parent the identifier of the parent area, or null if there is no parent
     * @return the AreaCreator instance with the specified parent identifier set
     * @see #parent(RegionizedArea)
     * @see RegionizedArea#setParent(Area)
     */
    @NotNull AreaCreator<T> parent(@Nullable String parent);

    /**
     * Sets the parent area for the area being created.
     *
     * @param area the parent Area to be set, or null if there is no parent
     * @return the AreaCreator instance with the specified parent area set
     * @see #parent(String)
     * @see RegionizedArea#setParent(Area)
     */
    @NotNull AreaCreator<T> parent(@Nullable RegionizedArea<?> area);

    /**
     * Sets the priority for the area being created.
     *
     * @param priority the priority value to be set, where higher values indicate higher priority
     * @return the AreaCreator instance with the specified priority set
     * @see Area#setPriority(int)
     */
    @NotNull AreaCreator<T> priority(int priority);

    /**
     * Sets the region for the AreaCreator instance being created.
     *
     * @param region the region to be associated with the area
     * @return the AreaCreator instance with the specified region set
     * @see RegionizedArea#setRegion(Region)
     */
    @NotNull AreaCreator<T> region(@NotNull T region);

    /**
     * Sets the world for the AreaCreator instance being created.
     *
     * @param world the world to be associated with the area
     * @return the AreaCreator instance with the specified world set
     * @see Area#getWorld()
     */
    @NotNull AreaCreator<T> world(@NotNull World world);

    /**
     * Retrieves a map of flags set for the area being created.
     * The map contains keys which are instances of Flag and their associated values.
     * The value can be null.
     *
     * @return a map of flags and their associated values, or an empty map if no flags are set
     * @see FlagProvider#getFlags()
     */
    @NotNull Map<@NotNull Flag<?>, @Nullable Object> flags();

    /**
     * Creates a new instance of {@link RegionizedArea} that is bound to a region.
     *
     * @return a new instance of {@code RegionizedArea<? super Region>}
     * @throws UnsupportedRegionException   if the specified region is not supported
     * @throws CircularInheritanceException if there is a circular inheritance detected in the area hierarchy.
     */
    @NotNull RegionizedArea<@NotNull T> create() throws UnsupportedRegionException, CircularInheritanceException;

    /**
     * Retrieves the set of members associated with the area.
     *
     * @return a set of UUIDs representing the members of the area
     * @see RegionizedArea#getMembers()
     */
    @NotNull Set<@NotNull UUID> members();

    /**
     * Retrieves the identifier of the parent area, if any.
     *
     * @return the identifier of the parent area as a string, or null if there is no parent
     * @see Area#getParent()
     */
    @Nullable
    String parent();

    /**
     * Retrieves the region associated with the AreaCreator instance.
     *
     * @return the region as an instance of type T
     * @see RegionizedArea#getRegion()
     */
    @NotNull T region();

    /**
     * Retrieves the world associated with the AreaCreator instance.
     *
     * @return the world associated with the AreaCreator instance
     * @see Area#getWorld()
     */
    @NotNull World world();

    /**
     * Retrieves the priority of the area.
     *
     * @return the priority of the area
     * @see Area#getPriority()
     */
    int priority();
}
