//package mekanism.registration.impl;
//
//import mekanism.api.annotations.ParametersAreNonnullByDefault;
//import mekanism.api.providers.IFluidProvider;
//import mekanism.Mekanism;
//import mekanism.fluid.MekanismFluid;
//import mekanism.fluid.MekanismFluid.Flowing;
//import mekanism.fluid.MekanismFluid.Still;
//import net.fabricmc.api.EnvType;
//import net.fabricmc.api.Environment;
//import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
//import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
//import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
//import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
//import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
//import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
//import net.minecraft.block.FluidBlock;
//import net.minecraft.client.MinecraftClient;
//import net.minecraft.client.render.RenderLayer;
//import net.minecraft.client.texture.Sprite;
//import net.minecraft.client.texture.SpriteAtlasTexture;
//import net.minecraft.fluid.FluidState;
//import net.minecraft.item.BucketItem;
//import net.minecraft.resource.ResourceManager;
//import net.minecraft.resource.ResourceType;
//import net.minecraft.util.Identifier;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.BlockRenderView;
//import org.jetbrains.annotations.NotNull;
//
//import java.util.Objects;
//import java.util.function.Function;
//
//@ParametersAreNonnullByDefault
//public class FluidRegistryObject<STILL extends Still, FLOWING extends Flowing, BLOCK extends FluidBlock, BUCKET extends BucketItem> implements IFluidProvider {
//
//    private final Identifier listenerId;
//
//    private STILL   stillRO   = null;
//    private FLOWING flowingRO = null;
//    private BLOCK   blockRO   = null;
//    private BUCKET  bucketRO  = null;
//
//    public FluidRegistryObject(String name) {
//        this.listenerId = Mekanism.id(name + "_reload_listener");
//    }
//
//    public STILL getStillFluid() { return stillRO; }
//    public FLOWING getFlowingFluid() { return flowingRO; }
//    public BLOCK getBlock() { return blockRO; }
//    public BUCKET getBucket() { return bucketRO; }
//
//    // Make sure these update methods are package local as only the FluidDeferredRegister should be messing with them
//    void updateStill(STILL stillRO) { this.stillRO = Objects.requireNonNull(stillRO); }
//    void updateFlowing(FLOWING flowingRO) { this.flowingRO = Objects.requireNonNull(flowingRO); }
//    void updateBlock(BLOCK blockRO) { this.blockRO = Objects.requireNonNull(blockRO); }
//    void updateBucket(BUCKET bucketRO) { this.bucketRO = Objects.requireNonNull(bucketRO); }
//
//    @Environment(EnvType.CLIENT)
//    public void setupFluidRendering() {
//        /*
//         This method handles the sprites/rendering for the custom fluids.  Currently, the water overlay
//         texture is ignored, but we return it anyway.  When the pull request for this feature is approved
//         and merged (https://github.com/FabricMC/fabric/pull/1393), this will work as intended with no
//         changes required from us.
//        */
//        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), stillRO, flowingRO);
//
//        // If they're not already present, add the sprites to the block atlas
//        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
//            registry.register(stillRO.getStillTexture());
//            registry.register(flowingRO.getFlowingTexture());
//            registry.register(stillRO.getOverlayTexture());
//        });
//
//        final Sprite[] fluidSprites = { null, null, null };
//
//        ResourceManagerHelper.get(ResourceType.CLIENT_RESOURCES).registerReloadListener(new SimpleSynchronousResourceReloadListener() {
//            @Override public Identifier getFabricId() { return listenerId; }
//
//            @Override
//            public void reload(ResourceManager resourceManager) {
//                final Function<Identifier, Sprite> atlas = MinecraftClient.getInstance().getSpriteAtlas(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE);
//                fluidSprites[0] = atlas.apply(stillRO.getStillTexture());
//                fluidSprites[1] = atlas.apply(flowingRO.getFlowingTexture());
//                fluidSprites[2] = atlas.apply(flowingRO.getOverlayTexture());
//            }
//        });
//
//        // The FluidRenderer gets the sprites and color from a FluidRenderHandler during rendering
//        final FluidRenderHandler renderHandler = new FluidRenderHandler() {
//            @Override
//            public Sprite[] getFluidSprites(BlockRenderView view, BlockPos pos, FluidState state) {
//                return fluidSprites;
//            }
//
//            @Override
//            public int getFluidColor(BlockRenderView view, BlockPos pos, FluidState state) {
//                return ((MekanismFluid) state.getFluid()).getColor();
//            }
//        };
//
//        FluidRenderHandlerRegistry.INSTANCE.register(stillRO, renderHandler);
//        FluidRenderHandlerRegistry.INSTANCE.register(flowingRO, renderHandler);
//    }
//
//    @NotNull @Override
//    public STILL getFluid() {
//        // Default our fluid to being the still variant
//        return getStillFluid();
//    }
//}