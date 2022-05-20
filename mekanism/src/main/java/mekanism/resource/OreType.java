package mekanism.resource;

import com.mojang.serialization.Codec;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import net.minecraft.util.StringRepresentable;

public enum OreType implements StringRepresentable {
    COPPER(PrimaryResource.COPPER, 16, 8, 0, 0, 60),
    TIN(PrimaryResource.TIN, 14, 8, 0, 0, 60),
    OSMIUM(PrimaryResource.OSMIUM, 12, 8, 0, 0, 60),
    URANIUM(PrimaryResource.URANIUM, 8, 8, 0, 0, 60),
    FLUORITE(MiscResource.FLUORITE, 6, 12, 0, 0, 32, 1, 4),
    LEAD(PrimaryResource.LEAD, 8, 8, 0, 0, 48);

    public static Codec<OreType> CODEC = StringRepresentable.fromEnum(OreType::values, OreType::byName);
    private static final Map<String, OreType> NAME_LOOKUP = Arrays.stream(values()).collect(Collectors.toMap(OreType::getSerializedName, oreType -> oreType));

    private final IResource resource;
    private final int perChunk;
    private final int maxVeinSize;
    private final int bottomOffset;
    private final int topOffset;
    private final int maxHeight;
    private final int minExp;
    private final int maxExp;

    OreType(IResource resource, int perChunk, int maxVeinSize, int bottomOffset, int topOffset, int maxHeight) {
        this(resource, perChunk, maxVeinSize, bottomOffset, topOffset, maxHeight, 0, 0);
    }

    OreType(IResource resource, int perChunk, int maxVeinSize, int bottomOffset, int topOffset, int maxHeight, int minExp, int maxExp) {
        this.resource = resource;
        this.perChunk = perChunk;
        this.maxVeinSize = maxVeinSize;
        this.bottomOffset = bottomOffset;
        this.topOffset = topOffset;
        this.maxHeight = maxHeight;
        this.minExp = minExp;
        this.maxExp = maxExp;
    }

    public IResource getResource() {
        return resource;
    }

    public int getPerChunk() {
        return perChunk;
    }

    public int getMaxVeinSize() {
        return maxVeinSize;
    }

    public int getBottomOffset() {
        return bottomOffset;
    }

    public int getTopOffset() {
        return topOffset;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public int getMinExp() {
        return minExp;
    }

    public int getMaxExp() {
        return maxExp;
    }

    public static OreType get(IResource resource) {
        for (OreType ore : values()) {
            if (resource == ore.resource) {
                return ore;
            }
        }
        return null;
    }

    @NotNull
    @Override
    public String getSerializedName() {
        return resource.getRegistrySuffix();
    }

    @Nullable
    private static OreType byName(String name) {
        return NAME_LOOKUP.get(name);
    }
}
