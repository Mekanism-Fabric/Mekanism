package mekanism.additions.entities;

import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.monster.Stray;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class BabyStrayEntity extends Stray implements IBabyEntity {

    private static final EntityDataAccessor<Boolean> IS_CHILD = SynchedEntityData.defineId(BabyStrayEntity.class, EntityDataSerializers.BOOLEAN);

    public static boolean spawnRestrictions(EntityType<BabyStrayEntity> type, ServerLevel world, MobSpawnType reason, BlockPos pos, Random random) {
        return checkMobSpawnRules(type, world, reason, pos, random) && (reason == MobSpawnType.SPAWNER || world.canSeeSky(pos));
    }

    public BabyStrayEntity(EntityType<? extends Stray> entityType, Level world) {
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
        return isBaby() ? 0.93F : super.getStandingEyeHeight(pose, dimensions);
    }

}
