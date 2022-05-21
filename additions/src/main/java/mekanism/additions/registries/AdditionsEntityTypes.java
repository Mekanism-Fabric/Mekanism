package mekanism.additions.registries;

import mekanism.additions.MekanismAdditions;
import mekanism.additions.entities.*;
import mekanism.registration.impl.EntityTypeDeferredRegister;
import mekanism.registration.impl.EntityTypeRegistryObject;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;

public final class AdditionsEntityTypes {

    public static final EntityTypeDeferredRegister ENTITY_TYPES = new EntityTypeDeferredRegister(MekanismAdditions.MODID);

    public static final EntityTypeRegistryObject<BabyCreeperEntity> BABY_CREEPER = ENTITY_TYPES.register("baby_creeper", EntityType.Builder.create(BabyCreeperEntity::new, SpawnGroup.MONSTER).setDimensions(0.6F, 1.7F), BabyCreeperEntity::createCreeperAttributes);
    public static final EntityTypeRegistryObject<BabyEndermanEntity> BABY_ENDERMAN = ENTITY_TYPES.register("baby_enderman", EntityType.Builder.create(BabyEndermanEntity::new, SpawnGroup.MONSTER).setDimensions(0.6F, 2.9F), BabyEndermanEntity::createEndermanAttributes);
    public static final EntityTypeRegistryObject<BabySkeletonEntity> BABY_SKELETON = ENTITY_TYPES.register("baby_skeleton", EntityType.Builder.create(BabySkeletonEntity::new, SpawnGroup.MONSTER).setDimensions(0.6F, 1.99F), BabySkeletonEntity::createAbstractSkeletonAttributes);
    public static final EntityTypeRegistryObject<BabyStrayEntity> BABY_STRAY = ENTITY_TYPES.register("baby_stray", EntityType.Builder.create(BabyStrayEntity::new, SpawnGroup.MONSTER).setDimensions(0.6F, 1.99F), BabyStrayEntity::createAbstractSkeletonAttributes);
    public static final EntityTypeRegistryObject<BabyWitherSkeletonEntity> BABY_WITHER_SKELETON = ENTITY_TYPES.register("baby_wither_skeleton", EntityType.Builder.create(BabyWitherSkeletonEntity::new, SpawnGroup.MONSTER).makeFireImmune().setDimensions(0.7F, 2.4F), BabyWitherSkeletonEntity::createAbstractSkeletonAttributes);
    //public static final EntityBalloon BALLOON = ENTITY_TYPES.register("balloon", EntityType.Builder.<EntityBalloon>of(EntityBalloon::new, SpawnGroup.MISC).sized(0.4F, 0.45F));
    //public static final EntityObsidianTNT OBSIDIAN_TNT = ENTITY_TYPES.register("obsidian_tnt", EntityType.Builder.<EntityObsidianTNT>of(EntityObsidianTNT::new, SpawnGroup.MISC).fireImmune().sized(0.98F, 0.98F));


    public static void init() {

    }

}
