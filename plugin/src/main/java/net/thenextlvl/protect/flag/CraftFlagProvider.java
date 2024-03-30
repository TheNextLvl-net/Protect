package net.thenextlvl.protect.flag;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
public class CraftFlagProvider implements FlagProvider {
    private Map<Flag<?>, @Nullable Object> flags = new LinkedHashMap<>();

    @Override
    public <T> void setFlag(@NotNull Flag<T> flag, T state) {
        getFlags().put(flag, state);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getFlag(@NotNull Flag<T> flag) {
        return (T) getFlags().getOrDefault(flag, flag.defaultValue());
    }

    @Override
    public <T> boolean hasFlag(@NotNull Flag<T> flag) {
        return getFlags().containsKey(flag);
    }

    @Override
    public <T> boolean removeFlag(@NotNull Flag<T> flag) {
        return getFlags().remove(flag) != null;
    }
}
