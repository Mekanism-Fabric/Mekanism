package mekanism.tools;

import mekanism.tools.items.MekanismShieldItem;
import mekanism.tools.rendering.RenderMekanismShieldItem;
import mekanism.tools.rendering.ShieldTextures;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.fabricmc.fabric.impl.client.rendering.BuiltinItemRendererRegistryImpl;
import net.minecraft.client.renderer.texture.TextureAtlas;

public class MekanismToolsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        registerShieldHandlers();
    }

    public static void registerShieldHandlers() {
        ClientSpriteRegistryCallback.event(TextureAtlas.LOCATION_BLOCKS).register((atlasTexture, registry) -> {
            for (ShieldTextures value : ShieldTextures.values()) {
                registry.register(value.getBase().texture());
            }
        });

        for (MekanismShieldItem shieldItem : RenderMekanismShieldItem.initShieldTextureMap()) {
            BuiltinItemRendererRegistryImpl.INSTANCE.register(shieldItem, RenderMekanismShieldItem::render);
            FabricModelPredicateProviderRegistry.register(shieldItem, MekanismTools.rl("blocking"), (stack, world, entity, seed) ->
                entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F
            );
        }
    }
}
