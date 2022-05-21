package mekanism.additions.registries;

import mekanism.additions.MekanismAdditions;
import mekanism.additions.entities.*;
import mekanism.registration.impl.EntityTypeDeferredRegister;
import mekanism.registration.impl.EntityTypeRegistryObject;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public final class AdditionsEntityTypes {

    public static final EntityTypeDeferredRegister ENTITY_TYPES = new EntityTypeDeferredRegister(MekanismAdditions.MODID);

    public static final EntityTypeRegistryObject<BabyCreeperEntity> BABY_CREEPER = ENTITY_TYPES.register("baby_creeper", EntityType.Builder.of(BabyCreeperEntity::new, MobCategory.MONSTER).sized(0.6F, 1.7F), BabyCreeperEntity::createAttributes);
    public static final EntityTypeRegistryObject<BabyEndermanEntity> BABY_ENDERMAN = ENTITY_TYPES.register("baby_enderman", EntityType.Builder.of(BabyEndermanEntity::new, MobCategory.MONSTER).sized(0.6F, 2.9F), BabyEndermanEntity::createAttributes);
    public static final EntityTypeRegistryObject<BabySkeletonEntity> BABY_SKELETON = ENTITY_TYPES.register("baby_skeleton", EntityType.Builder.of(BabySkeletonEntity::new, MobCategory.MONSTER).sized(0.6F, 1.99F), BabySkeletonEntity::createAttributes);
    public static final EntityTypeRegistryObject<BabyStrayEntity> BABY_STRAY = ENTITY_TYPES.register("baby_stray", EntityType.Builder.of(BabyStrayEntity::new, MobCategory.MONSTER).sized(0.6F, 1.99F), BabyStrayEntity::createAttributes);
    public static final EntityTypeRegistryObject<BabyWitherSkeletonEntity> BABY_WITHER_SKELETON = ENTITY_TYPES.register("baby_wither_skeleton", EntityType.Builder.of(BabyWitherSkeletonEntity::new, MobCategory.MONSTER).fireImmune().sized(0.7F, 2.4F), BabyWitherSkeletonEntity::createAttributes);
//    public static final EntityTypeRegistryObject<EntityBalloon> BALLOON = ENTITY_TYPES.register("balloon", EntityType.Builder.of(EntityBalloon::new, MobCategory.MISC).sized(0.4F, 0.45F));
//    public static final EntityTypeRegistryObject<EntityObsidianTNT> OBSIDIAN_TNT = ENTITY_TYPES.register("obsidian_tnt", EntityType.Builder.of(EntityObsidianTNT::new, MobCategory.MISC).fireImmune().sized(0.98F, 0.98F));


    public static void init() {

    }

}
