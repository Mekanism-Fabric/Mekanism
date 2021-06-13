package mekanism.additions.entities;

import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class BabyEndermanEntity extends EndermanEntity implements IBabyEntity {

    private static final TrackedData<Boolean> IS_CHILD = DataTracker.registerData(BabyEndermanEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public BabyEndermanEntity(EntityType<? extends EndermanEntity> entityType, World world) {
        super(entityType, world);
        setBaby(true);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        getDataTracker().startTracking(IS_CHILD, false);
    }

    @Override
    public boolean isBaby() {
        return getDataTracker().get(IS_CHILD);
    }

    @Override
    public void setBaby(boolean baby) {
        setChild(IS_CHILD, baby);
    }

    @Override
    public void onTrackedDataSet(TrackedData<?> data) {
        if (IS_CHILD.equals(data)) calculateDimensions();
        super.onTrackedDataSet(data);
    }

    @Override
    protected int getXpToDrop(PlayerEntity player) {
        if (isBaby()) experiencePoints = (int) (experiencePoints * 2.5F);
        return super.getXpToDrop(player);
    }

    @Override
    public double getHeightOffset() {
        return isBaby() ? 0 : super.getHeightOffset();
    }

    @Override
    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return isBaby() ? 1.3F : super.getActiveEyeHeight(pose, dimensions);
    }

}
