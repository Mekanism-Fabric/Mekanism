package mekanism.tools.accessors;

import net.minecraft.client.model.ShieldModel;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BlockEntityWithoutLevelRenderer.class)
public interface BuiltinModelItemRendererAccessor {
    @Accessor("shieldModel")
    ShieldModel getModelShield();
}
