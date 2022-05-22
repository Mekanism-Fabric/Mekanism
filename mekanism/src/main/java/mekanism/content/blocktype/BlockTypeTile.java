package mekanism.content.blocktype;

import mekanism.api.Upgrade;
import mekanism.api.math.FloatingLongSupplier;
import mekanism.api.text.ILangEntry;
import mekanism.block.attribute.Attribute.TileAttribute;
import mekanism.block.attribute.AttributeEnergy;
import mekanism.block.attribute.AttributeUpgradeSupport;
import mekanism.registration.impl.TileEntityTypeRegistryObject;
import mekanism.tile.base.TileEntityMekanism;

import java.util.Set;
import java.util.function.Supplier;

public class BlockTypeTile<TILE extends TileEntityMekanism> extends BlockType {

    private final Supplier<TileEntityTypeRegistryObject<TILE>> tileEntityRegistrar;

    public BlockTypeTile(Supplier<TileEntityTypeRegistryObject<TILE>> tileEntityRegistrar, ILangEntry description) {
        super(description);
        this.tileEntityRegistrar = tileEntityRegistrar;
    }

    public TileEntityTypeRegistryObject<TILE> getTileType() {
        return tileEntityRegistrar.get();
    }

    public static class BlockTileBuilder<BLOCK extends BlockTypeTile<TILE>, TILE extends TileEntityMekanism, T extends BlockTileBuilder<BLOCK, TILE, T>>
          extends BlockTypeBuilder<BLOCK, T> {

        protected BlockTileBuilder(BLOCK holder) {
            super(holder);
        }

        public static <TILE extends TileEntityMekanism> BlockTileBuilder<BlockTypeTile<TILE>, TILE, ?> createBlock(
              Supplier<TileEntityTypeRegistryObject<TILE>> tileEntityRegistrar, ILangEntry description) {
            return new BlockTileBuilder<>(new BlockTypeTile<>(tileEntityRegistrar, description));
        }

//        public T withSound(SoundEventRegistryObject<SoundEvent> soundRegistrar) {
//            return with(new AttributeSound(soundRegistrar));
//        }
//
//        public T withGui(Supplier<ContainerTypeRegistryObject<? extends MekanismContainer>> containerRegistrar) {
//            return withGui(containerRegistrar, null);
//        }
//
//        public T withGui(Supplier<ContainerTypeRegistryObject<? extends MekanismContainer>> containerRegistrar, @Nullable ILangEntry customName) {
//            return with(new AttributeGui(containerRegistrar, customName));
//        }

        public T withEnergyConfig(FloatingLongSupplier energyUsage, FloatingLongSupplier energyStorage) {
            return with(new AttributeEnergy(energyUsage, energyStorage));
        }

        public T withEnergyConfig(FloatingLongSupplier energyStorage) {
            return with(new AttributeEnergy(null, energyStorage));
        }

        @SafeVarargs
        public final T with(TileAttribute<TILE>... attrs) {
            holder.add(attrs);
            return getThis();
        }

        public T withSupportedUpgrades(Set<Upgrade> upgrades) {
            holder.add(new AttributeUpgradeSupport(upgrades));
            return getThis();
        }
    }
}
