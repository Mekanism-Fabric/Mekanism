package mekanism.inventory.container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import mekanism.config.MekanismConfig;
import mekanism.config.value.CachedIntValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SelectedWindowData {

    public static final SelectedWindowData UNSPECIFIED = new SelectedWindowData(WindowType.UNSPECIFIED);

    @NotNull
    public final WindowType type;
    public final byte extraData;

    public SelectedWindowData(@NotNull WindowType type) {
        this(type, (byte) 0);
    }

    /**
     * It is expected to only call this with a piece of extra data that is valid. If it is not valid this end up treating it as zero instead.
     */
    public SelectedWindowData(@NotNull WindowType type, byte extraData) {
        this.type = Objects.requireNonNull(type);
        this.extraData = this.type.isValid(extraData) ? extraData : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SelectedWindowData other = (SelectedWindowData) o;
        return extraData == other.extraData && type == other.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, extraData);
    }

    /**
     * @apiNote Only call this on the client.
     */
    public void updateLastPosition(int x, int y) {
        String saveName = type.getSaveName(extraData);
        if (saveName != null) {
            CachedWindowPosition cachedPosition = MekanismConfig.client.lastWindowPositions.get(saveName);
            if (cachedPosition != null) {
                boolean changed = false;
                CachedIntValue cachedX = cachedPosition.x();
                if (cachedX.get() != x) {
                    cachedX.set(x);
                    changed = true;
                }
                CachedIntValue cachedY = cachedPosition.y();
                if (cachedY.get() != y) {
                    cachedY.set(y);
                    changed = true;
                }
//                if (changed) {
//                    MekanismConfig.client.save();
//                }
            }
        }
    }

    /**
     * @apiNote Only call this on the client.
     */
    public WindowPosition getLastPosition() {
        String saveName = type.getSaveName(extraData);
        if (saveName != null) {
            CachedWindowPosition cachedPosition = MekanismConfig.client.lastWindowPositions.get(saveName);
            if (cachedPosition != null) {
                return new WindowPosition(cachedPosition.x().get(), cachedPosition.y().get());
            }
        }
        return new WindowPosition(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public record CachedWindowPosition(CachedIntValue x, CachedIntValue y) {
    }

    public record WindowPosition(int x, int y) {
    }

    public enum WindowType {
        COLOR("color"),
        CONFIRMATION("confirmation"),
//        CRAFTING("crafting", IQIOCraftingWindowHolder.MAX_CRAFTING_WINDOWS),
        MEKA_SUIT_HELMET("mekaSuitHelmet"),
        RENAME("rename"),
        SKIN_SELECT("skinSelect"),
        SIDE_CONFIG("sideConfig"),
        TRANSPORTER_CONFIG("transporterConfig"),
        UPGRADE("upgrade"),
        /**
         * For use by windows that don't actually have any server side specific logic required, or don't persist their position.
         */
        UNSPECIFIED(null);

        @Nullable
        private final String saveName;
        private final byte maxData;

        WindowType(@Nullable String saveName) {
            this(saveName, (byte) 1);
        }

        WindowType(@Nullable String saveName, byte maxData) {
            this.saveName = saveName;
            this.maxData = maxData;
        }

        @Nullable
        String getSaveName(byte extraData) {
            return maxData == 1 ? saveName : saveName + extraData;
        }

        public List<String> getSavePaths() {
            if (saveName == null) {
                return Collections.emptyList();
            } else if (maxData == 1) {
                return Collections.singletonList(saveName);
            }
            List<String> savePaths = new ArrayList<>();
            for (int i = 0; i < maxData; i++) {
                savePaths.add(saveName + i);
            }
            return savePaths;
        }

        public boolean isValid(byte extraData) {
            return extraData >= 0 && extraData < maxData;
        }
    }
}