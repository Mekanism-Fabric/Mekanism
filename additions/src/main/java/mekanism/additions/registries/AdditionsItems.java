package mekanism.additions.registries;

import mekanism.additions.MekanismAdditions;
import mekanism.registration.ItemRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.registry.Registry;

public final class AdditionsItems {
    public static final ItemRegistry ITEMS = new ItemRegistry(MekanismAdditions.MODID);

    public static final SpawnEggItem BABY_CREEPER_SPAWN_EGG = registerSpawnEgg(AdditionsEntityTypes.BABY_CREEPER, 0x31E02F, 0x1E1E1E);
    public static final SpawnEggItem BABY_ENDERMAN_SPAWN_EGG = registerSpawnEgg(AdditionsEntityTypes.BABY_ENDERMAN, 0x242424, 0x1E1E1E);
    public static final SpawnEggItem BABY_SKELETON_SPAWN_EGG = registerSpawnEgg(AdditionsEntityTypes.BABY_SKELETON, 0xFFFFFF, 0x800080);

    public static void init() {

    }

    private static <ENTITY extends MobEntity> SpawnEggItem registerSpawnEgg(EntityType<ENTITY> entityTypeProvider, int primaryColor, int secondaryColor) {
        return ITEMS.register(Registry.ENTITY_TYPE.getId(entityTypeProvider).getPath() + "_spawn_egg", () -> new SpawnEggItem(entityTypeProvider, primaryColor, secondaryColor, ItemRegistry.getMekBaseProperties()));
    }
}
