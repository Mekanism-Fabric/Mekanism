//package mekanism.registration.impl;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.function.Supplier;
//import java.util.function.UnaryOperator;
//
//import io.github.fabricators_of_create.porting_lib.util.FluidAttributes;
//import mekanism.Mekanism;
//import mekanism.base.IChemicalConstant;
//import mekanism.registration.DeferredRegister;
//import net.minecraft.core.BlockPos;
//import net.minecraft.core.BlockSource;
//import net.minecraft.core.Registry;
//import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
//import net.minecraft.core.dispenser.DispenseItemBehavior;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.sounds.SoundEvents;
//import net.minecraft.world.item.BucketItem;
//import net.minecraft.world.item.DispensibleContainerItem;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.Item.Properties;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.Items;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.DispenserBlock;
//import net.minecraft.world.level.block.LiquidBlock;
//import net.minecraft.world.level.block.state.BlockBehaviour;
//import net.minecraft.world.level.material.Fluid;
//import net.minecraft.world.level.material.LavaFluid.Source;
//import net.minecraft.world.level.material.LavaFluid.Flowing;
//
//import net.minecraft.world.level.material.Material;
//import org.jetbrains.annotations.NotNull;
//
//public class FluidDeferredRegister {
//
//    private static final ResourceLocation OVERLAY = new ResourceLocation("minecraft", "block/water_overlay");
//    private static final ResourceLocation LIQUID = Mekanism.rl("liquid/liquid");
//    private static final ResourceLocation LIQUID_FLOW = Mekanism.rl("liquid/liquid_flow");
//    //Copy of/based off of vanilla's lava/water bucket dispense behavior
//    private static final DispenseItemBehavior BUCKET_DISPENSE_BEHAVIOR = new DefaultDispenseItemBehavior() {
//        @NotNull
//        @Override
//        public ItemStack execute(@NotNull BlockSource source, @NotNull ItemStack stack) {
//            Level world = source.getLevel();
//            DispensibleContainerItem bucket = (DispensibleContainerItem) stack.getItem();
//            BlockPos pos = source.getPos().relative(source.getBlockState().getValue(DispenserBlock.FACING));
//            if (bucket.emptyContents(null, world, pos, null)) {
//                bucket.checkExtraContent(null, world, stack, pos);
//                return new ItemStack(Items.BUCKET);
//            }
//            return super.execute(source, stack);
//        }
//    };
//
//    public static FluidAttributes.Builder getMekBaseBuilder() {
//        return getMekBaseBuilder(LIQUID, LIQUID_FLOW);
//    }
//
//    public static FluidAttributes.Builder getMekBaseBuilder(ResourceLocation still, ResourceLocation flowing) {
//        //For now all our fluids use the same "overlay" for being against glass as vanilla water.
//        return FluidAttributes.builder(still, flowing)
//                .sound(SoundEvents.BUCKET_FILL, SoundEvents.BUCKET_EMPTY)
//                .overlay(OVERLAY);
//    }
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
//        itemRegister = DeferredRegister.create(Registry.ITEM, modid);
//    }
//
//    public FluidRegistryObject<Source, Flowing, LiquidBlock, BucketItem> registerLiquidChemical(IChemicalConstant constants) {
//        int density = Math.round(constants.getDensity());
//        return register(constants.getName(), fluidAttributes -> fluidAttributes
//                .color(constants.getColor())
//                .temperature(Math.round(constants.getTemperature()))
//                .density(density)
//                .viscosity(density)
//                .luminosity(constants.getLuminosity()));
//    }
//
//    public FluidRegistryObject<Source, Flowing, LiquidBlock, BucketItem> register(String name, UnaryOperator<FluidAttributes.Builder> fluidAttributes) {
//        return register(name, BucketItem::new, fluidAttributes);
//    }
//
//    public <BUCKET extends BucketItem> FluidRegistryObject<Source, Flowing, LiquidBlock, BUCKET> register(String name, BucketCreator<BUCKET> bucketCreator,
//                                                                                                          UnaryOperator<FluidAttributes.Builder> fluidAttributes) {
//        return register(name, fluidAttributes.apply(getMekBaseBuilder()), bucketCreator);
//    }
//
//    public FluidRegistryObject<Source, Flowing, LiquidBlock, BucketItem> register(String name, FluidAttributes.Builder builder) {
//        return register(name, builder, BucketItem::new);
//    }
//
//    public <BUCKET extends BucketItem> FluidRegistryObject<Source, Flowing, LiquidBlock, BUCKET> register(String name, FluidAttributes.Builder builder,
//                                                                                                          BucketCreator<BUCKET> bucketCreator) {
//        String flowingName = "flowing_" + name;
//        String bucketName = name + "_bucket";
//        //Create the registry object and let the values init to null as before we actually call get on them, we will update the backing values
//        FluidRegistryObject<Source, Flowing, LiquidBlock, BUCKET> fluidRegistryObject = new FluidRegistryObject<>();
//        //Pass in suppliers that are wrapped instead of direct references to the registry objects, so that when we update the registry object to
//        // point to a new object it gets updated properly.
////        Properties properties = builder
////                .overlay(OVERLAY) //For now all our fluids use the same "overlay" for being against glass as vanilla water.
////                .stillFluid(fluidRegistryObject::getStillFluid)
////                .flowingFluid(fluidRegistryObject::getFlowingFluid)
////                .bucketItem(fluidRegistryObject::getBucket)
////                .fluidBlock(fluidRegistryObject::getBlock)
////                .build();
//
//        //Update the references to objects that are retrieved from the deferred registers
//        fluidRegistryObject.updateStill(fluidRegister.register(name, );
//        fluidRegistryObject.updateFlowing(fluidRegister.register(flowingName, () -> new Flowing(properties)));
//        fluidRegistryObject.updateBucket(itemRegister.register(bucketName, () -> bucketCreator.create(fluidRegistryObject::getStillFluid,
//                ItemDeferredRegister.getMekBaseProperties().stacksTo(1).craftRemainder(Items.BUCKET))));
//        //Note: The block properties used here is a copy of the ones for water
//        fluidRegistryObject.updateBlock(blockRegister.register(name, () -> new LiquidBlock(fluidRegistryObject::getStillFluid,
//                BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noDrops())));
//        allFluids.add(fluidRegistryObject);
//        return fluidRegistryObject;
//    }
//
//
//    public List<FluidRegistryObject<?, ?, ?, ?>> getAllFluids() {
//        return Collections.unmodifiableList(allFluids);
//    }
//
//    public void registerBucketDispenserBehavior() {
//        for (FluidRegistryObject<?, ?, ?, ?> fluidRO : getAllFluids()) {
//            DispenserBlock.registerBehavior(fluidRO.getBucket(), BUCKET_DISPENSE_BEHAVIOR);
//        }
//    }
//
//    @FunctionalInterface
//    public interface BucketCreator<BUCKET extends BucketItem> {
//
//        BUCKET create(Supplier<? extends Fluid> supplier, Properties builder);
//    }
//}