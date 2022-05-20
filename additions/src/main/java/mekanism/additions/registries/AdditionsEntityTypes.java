package mekanism.additions.registries;

import mekanism.additions.MekanismAdditions;
import mekanism.additions.entities.*;
import mekanism.registration.EntityTypeRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public final class AdditionsEntityTypes {

    public static final EntityTypeRegistry ENTITY_TYPES = new EntityTypeRegistry(MekanismAdditions.MODID);

    public static final EntityType<BabyCreeperEntity> BABY_CREEPER = ENTITY_TYPES.register("baby_creeper", EntityType.Builder.of(BabyCreeperEntity::new, MobCategory.MONSTER).sized(0.6F, 1.7F), BabyCreeperEntity::createAttributes);
    public static final EntityType<BabyEndermanEntity> BABY_ENDERMAN = ENTITY_TYPES.register("baby_enderman", EntityType.Builder.of(BabyEndermanEntity::new, MobCategory.MONSTER).sized(0.6F, 2.9F), BabyEndermanEntity::createAttributes);
    public static final EntityType<BabySkeletonEntity> BABY_SKELETON = ENTITY_TYPES.register("baby_skeleton", EntityType.Builder.of(BabySkeletonEntity::new, MobCategory.MONSTER).sized(0.6F, 1.99F), BabySkeletonEntity::createAttributes);
    public static final EntityType<BabyStrayEntity> BABY_STRAY = ENTITY_TYPES.register("baby_stray", EntityType.Builder.of(BabyStrayEntity::new, MobCategory.MONSTER).sized(0.6F, 1.99F), BabyStrayEntity::createAttributes);
    public static final EntityType<BabyWitherSkeletonEntity> BABY_WITHER_SKELETON = ENTITY_TYPES.register("baby_wither_skeleton", EntityType.Builder.of(BabyWitherSkeletonEntity::new, MobCategory.MONSTER).fireImmune().sized(0.7F, 2.4F), BabyWitherSkeletonEntity::createAttributes);
    //public static final EntityBalloon BALLOON = ENTITY_TYPES.register("balloon", EntityType.Builder.<EntityBalloon>of(EntityBalloon::new, SpawnGroup.MISC).sized(0.4F, 0.45F));
    //public static final EntityObsidianTNT OBSIDIAN_TNT = ENTITY_TYPES.register("obsidian_tnt", EntityType.Builder.<EntityObsidianTNT>of(EntityObsidianTNT::new, SpawnGroup.MISC).fireImmune().sized(0.98F, 0.98F));


    public static void init() {

    }

}
