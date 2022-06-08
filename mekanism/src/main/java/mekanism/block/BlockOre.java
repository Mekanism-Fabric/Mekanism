package mekanism.block;

import mekanism.Mekanism;
import mekanism.api.text.ILangEntry;
import mekanism.block.interfaces.IHasDescription;
import mekanism.block.states.BlockStateHelper;
import mekanism.resource.ore.OreType;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class BlockOre extends Block implements IHasDescription {

    private final OreType ore;
    private String descriptionTranslationKey;

    public BlockOre(OreType ore) {
        this(ore, Properties.of(Material.STONE).strength(3, 3).requiresCorrectToolForDrops());
    }

    public BlockOre(OreType ore, Properties properties) {
        super(BlockStateHelper.applyLightLevelAdjustments(properties));
        this.ore = ore;
    }

    public String getDescriptionTranslationKey() {
        if (descriptionTranslationKey == null) {
            descriptionTranslationKey = Util.makeDescriptionId("description", Mekanism.rl(ore.getResource().getRegistrySuffix() + "_ore"));
        }
        return descriptionTranslationKey;
    }

    @NotNull
    @Override
    public ILangEntry getDescription() {
        return this::getDescriptionTranslationKey;
    }

    @Override
    protected void popExperience(ServerLevel level, BlockPos pos, int amount) {
        if (ore.getMaxExp() > 0 /*&& silkTouch == 0*/) {
            int reward = Mth.nextInt(new Random(), ore.getMinExp(), ore.getMaxExp());
            ExperienceOrb.award(level, Vec3.atCenterOf(pos), reward);
        }
    }
}