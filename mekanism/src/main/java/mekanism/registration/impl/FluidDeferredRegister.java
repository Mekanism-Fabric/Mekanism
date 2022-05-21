//package mekanism.registration.impl;
//
//import mekanism.Mekanism;
//import mekanism.base.IChemicalConstant;
//import mekanism.fluid.MekanismFluid;
//import mekanism.fluid.MekanismFluid.Flowing;
//import mekanism.fluid.MekanismFluid.Properties;
//import mekanism.fluid.MekanismFluid.Properties.Builder;
//import mekanism.fluid.MekanismFluid.Still;
//import mekanism.registration.DeferredRegister;
//import mekanism.util.AccessorUtils;
//import net.minecraft.block.*;
//import net.minecraft.block.dispenser.DispenserBehavior;
//import net.minecraft.block.dispenser.ItemDispenserBehavior;
//import net.minecraft.fluid.Fluid;
//import net.minecraft.item.*;
//import net.minecraft.util.Identifier;
//import net.minecraft.util.math.BlockPointer;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.registry.Registry;
//import net.minecraft.world.World;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.function.UnaryOperator;
//
//public class FluidDeferredRegister {
//    private static final Identifier OVERLAY = new Identifier("minecraft", "block/water_overlay");
//
//    //Copy of/based off of vanilla's lava/water bucket dispense behavior
//    private static final DispenserBehavior BUCKET_DISPENSE_BEHAVIOR = new ItemDispenserBehavior() {
//        public ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
//            World world = pointer.getWorld();
//            FluidModificationItem bucket = (FluidModificationItem)stack.getItem();
//            BlockPos pos = pointer.getBlockPos().offset(pointer.getBlockState().get(DispenserBlock.FACING));
//            if (bucket.placeFluid(null, world, pos, null)) {
//                bucket.onEmptied(null, world, stack, pos);
//                return new ItemStack(Items.BUCKET);
//            }
//            return super.dispenseSilently(pointer, stack);
//        }
//    };
//
//    private final List<FluidRegistryObject<?, ?, ?, ?>> allFluids = new ArrayList<>();
//
//    private final DeferredRegister<Fluid> fluidRegister;
//    private final DeferredRegister<Block> blockRegister;
//    private final DeferredRegister<Item> itemRegister;
//
//    public FluidDeferredRegister(String modid) {
//        blockRegister = DeferredRegister.create(Registry.BLOCK, modid);
//        fluidRegister = DeferredRegister.create(Registry.FLUID, modid);
//        itemRegister  = DeferredRegister.create(Registry.ITEM,  modid);
//    }
//
//    public FluidRegistryObject<Still, Flowing, FluidBlock, BucketItem> registerLiquidChemical(IChemicalConstant constants) {
//        int density = Math.round(constants.getDensity());
//        return register(constants.getName(), fluidAttributes -> fluidAttributes
//            .color(constants.getColor())
//            .temperature(Math.round(constants.getTemperature()))
//            .density(density)
//            .viscosity(density)
//            .luminosity(constants.getLuminosity())
//        );
//    }
//
//    public FluidRegistryObject<Still, Flowing, FluidBlock, BucketItem> register(String name, UnaryOperator<Builder> fluidAttributes) {
//        return register(name, fluidAttributes.apply(Properties.builder(Mekanism.id("liquid/liquid"), Mekanism.id("liquid/liquid_flow"))));
//    }
//
//    public FluidRegistryObject<Still, Flowing, FluidBlock, BucketItem> register(String name, Properties.Builder builder) {
//        String flowingName = "flowing_" + name;
//        String bucketName = name + "_bucket";
//
//        FluidRegistryObject<Still, Flowing, FluidBlock, BucketItem> fluidRegistryObject = new FluidRegistryObject<>(name);
//
//        Properties properties = builder
//            .overlayTexture(OVERLAY) //For now all our fluids use the same "overlay" for being against glass as vanilla water.
//            .stillFluid(fluidRegistryObject::getStillFluid)
//            .flowingFluid(fluidRegistryObject::getFlowingFluid)
//            .bucketItem(fluidRegistryObject::getBucket)
//            .fluidBlock(fluidRegistryObject::getBlock)
//            .build();
//
//        //Update the references to objects that are retrieved from the deferred registers
//        fluidRegistryObject.updateStill(fluidRegister.register(name, () -> new Still(properties)));
//        fluidRegistryObject.updateFlowing(fluidRegister.register(flowingName, () -> new Flowing(properties)));
//        fluidRegistryObject.updateBucket(itemRegister.register(bucketName, () -> new BucketItem(fluidRegistryObject.getStillFluid(), ItemDeferredRegister.getMekBaseProperties().maxCount(1).recipeRemainder(Items.BUCKET))));
//
//        //Note: The block properties used here is a copy of the ones for water
//        fluidRegistryObject.updateBlock(blockRegister.register(name, () -> AccessorUtils.createFluidBlock(
//            fluidRegistryObject.getStillFluid(),
//            AbstractBlock.Settings.of(Material.WATER)
//                .noCollision().strength(100.0F)
//                .dropsNothing().luminance(value -> properties.getLuminosity())
//            ))
//        );
//
//        allFluids.add(fluidRegistryObject);
//
//        return fluidRegistryObject;
//    }
//
//    public List<FluidRegistryObject<?, ?, ?, ?>> getAllFluids() {
//        return allFluids;
//    }
//
//    public void registerBucketDispenserBehavior() {
//        for (FluidRegistryObject<?, ?, ?, ?> fluidRO : getAllFluids()) {
//            DispenserBlock.registerBehavior(fluidRO.getBucket(), BUCKET_DISPENSE_BEHAVIOR);
//        }
//    }
//}