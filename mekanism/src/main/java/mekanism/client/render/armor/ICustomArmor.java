package mekanism.client.render.armor;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public interface ICustomArmor {

    void render(@NotNull MatrixStack matrix, @NotNull VertexConsumerProvider renderer, int light, int overlayLight, float partialTicks, boolean hasEffect,
                LivingEntity entity, ItemStack stack);

}