package mekanism.additions.entities;

import java.util.UUID;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public interface IBabyEntity {
    //COPY of ZombieEntity BABY_SPEED_ID and BABY_SPEED_BONUS
    UUID BABY_SPEED_ID = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
    AttributeModifier BABY_SPEED_BONUS = new AttributeModifier(BABY_SPEED_ID, "Baby speed boost", 0.5D, AttributeModifier.Operation.MULTIPLY_BASE);

    default void setChild(EntityDataAccessor<Boolean> childParameter, boolean child) {
        LivingEntity entity = (LivingEntity) this;
        entity.getEntityData().set(childParameter, child);
        if (entity.level != null && !entity.level.isClientSide) {
            AttributeInstance attributeInstance = entity.getAttribute(Attributes.MOVEMENT_SPEED);
            if (attributeInstance != null) {
                attributeInstance.removeModifier(BABY_SPEED_BONUS);
                if (child) {
                    attributeInstance.addPermanentModifier(BABY_SPEED_BONUS);
                }
            }
        }
    }
}
