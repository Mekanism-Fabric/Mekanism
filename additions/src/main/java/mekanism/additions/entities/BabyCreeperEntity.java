package mekanism.additions.entities;

import mekanism.additions.accessors.CreeperEntityAccessor;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class BabyCreeperEntity extends CreeperEntity implements IBabyEntity {

    private static final TrackedData<Boolean> IS_CHILD = DataTracker.registerData(BabyCreeperEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public BabyCreeperEntity(EntityType<BabyCreeperEntity> entityType, World world) {
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
        return isBaby() ? 0.88F : super.getActiveEyeHeight(pose, dimensions);
    }

    public void doExplosion() {
        if (!this.world.isClient) {
            Explosion.DestructionType destructionType = this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING) ? Explosion.DestructionType.DESTROY : Explosion.DestructionType.NONE;
            float f = this.shouldRenderOverlay() ? 1 : 0.5F;
            this.dead = true;
            this.world.createExplosion(this, this.getX(), this.getY(), this.getZ(), (float)((CreeperEntityAccessor) this).getExplosionRadius() * f, destructionType);
            this.discard();
            ((CreeperEntityAccessor) this).invokeSpawnEffectsCloud();
        }
    }
}
