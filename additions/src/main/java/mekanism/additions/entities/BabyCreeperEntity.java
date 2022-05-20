package mekanism.additions.entities;

import mekanism.additions.accessors.CreeperEntityAccessor;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;

public class BabyCreeperEntity extends Creeper implements IBabyEntity {

    private static final EntityDataAccessor<Boolean> IS_CHILD = SynchedEntityData.defineId(BabyCreeperEntity.class, EntityDataSerializers.BOOLEAN);

    public BabyCreeperEntity(EntityType<BabyCreeperEntity> entityType, Level world) {
        super(entityType, world);
        setBaby(true);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        getEntityData().define(IS_CHILD, false);
    }

    @Override
    public boolean isBaby() {
        return getEntityData().get(IS_CHILD);
    }

    @Override
    public void setBaby(boolean baby) {
        setChild(IS_CHILD, baby);
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> data) {
        if (IS_CHILD.equals(data)) refreshDimensions();
        super.onSyncedDataUpdated(data);
    }

    @Override
    protected int getExperienceReward(Player player) {
        if (isBaby()) xpReward = (int) (xpReward * 2.5F);
        return super.getExperienceReward(player);
    }

    @Override
    public double getMyRidingOffset() {
        return isBaby() ? 0 : super.getMyRidingOffset();
    }

    @Override
    protected float getStandingEyeHeight(Pose pose, EntityDimensions dimensions) {
        return isBaby() ? 0.88F : super.getStandingEyeHeight(pose, dimensions);
    }

    public void doExplosion() {
        if (!this.level.isClientSide) {
            Explosion.BlockInteraction destructionType = this.level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE;
            float f = this.isPowered() ? 1 : 0.5F;
            this.dead = true;
            this.level.explode(this, this.getX(), this.getY(), this.getZ(), (float)((CreeperEntityAccessor) this).getExplosionRadius() * f, destructionType);
            this.discard();
            ((CreeperEntityAccessor) this).spawnLingeringCloud();
        }
    }
}
