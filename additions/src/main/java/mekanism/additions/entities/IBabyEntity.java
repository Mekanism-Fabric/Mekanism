package mekanism.additions.entities;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.TrackedData;

import java.util.UUID;

public interface IBabyEntity {
    //COPY of ZombieEntity BABY_SPEED_ID and BABY_SPEED_BONUS
    UUID BABY_SPEED_ID = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
    EntityAttributeModifier BABY_SPEED_BONUS = new EntityAttributeModifier(BABY_SPEED_ID, "Baby speed boost", 0.5D, EntityAttributeModifier.Operation.MULTIPLY_BASE);

    default void setChild(TrackedData<Boolean> childParameter, boolean child) {
        LivingEntity entity = (LivingEntity) this;
        entity.getDataTracker().set(childParameter, child);
        if (entity.world != null && !entity.world.isClient) {
            EntityAttributeInstance attributeInstance = entity.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
            if (attributeInstance != null) {
                attributeInstance.removeModifier(BABY_SPEED_BONUS);
                if (child) {
                    attributeInstance.addPersistentModifier(BABY_SPEED_BONUS);
                }
            }
        }
    }
}
