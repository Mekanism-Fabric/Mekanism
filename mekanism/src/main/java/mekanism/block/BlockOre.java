package mekanism.block;

import mekanism.api.text.ILangEntry;
import mekanism.Mekanism;
import mekanism.block.interfaces.IHasDescription;
import mekanism.block.states.BlockStateHelper;
import mekanism.resource.ore.OreType;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import org.jetbrains.annotations.NotNull;

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

//    @Override
//    public int getExpDrop(BlockState state, LevelReader reader, BlockPos pos, int fortune, int silkTouch) {
//        if (ore.getMaxExp() > 0 && silkTouch == 0) {
//            return Mth.nextInt(RANDOM, ore.getMinExp(), ore.getMaxExp());
//        }
//        return super.getExpDrop(state, reader, pos, fortune, silkTouch);
//    }
}