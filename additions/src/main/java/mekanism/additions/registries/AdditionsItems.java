package mekanism.additions.registries;

import mekanism.additions.MekanismAdditions;
import mekanism.registration.ItemRegistry;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.SpawnEggItem;

public final class AdditionsItems {
    public static final ItemRegistry ITEMS = new ItemRegistry(MekanismAdditions.MODID);

    public static final SpawnEggItem BABY_CREEPER_SPAWN_EGG = registerSpawnEgg(AdditionsEntityTypes.BABY_CREEPER, 0x31E02F, 0x1E1E1E);
    public static final SpawnEggItem BABY_ENDERMAN_SPAWN_EGG = registerSpawnEgg(AdditionsEntityTypes.BABY_ENDERMAN, 0x242424, 0x1E1E1E);
    public static final SpawnEggItem BABY_SKELETON_SPAWN_EGG = registerSpawnEgg(AdditionsEntityTypes.BABY_SKELETON, 0xFFFFFF, 0x800080);
    public static final SpawnEggItem BABY_STRAY_SPAWN_EGG = registerSpawnEgg(AdditionsEntityTypes.BABY_STRAY, 0x7B9394, 0xF2FAFA);
    public static final SpawnEggItem BABY_WITHER_SKELETON_SPAWN_EGG = registerSpawnEgg(AdditionsEntityTypes.BABY_WITHER_SKELETON, 0x303030, 0x525454);

    public static void init() {

    }

    private static <ENTITY extends Mob> SpawnEggItem registerSpawnEgg(EntityType<ENTITY> entityTypeProvider, int primaryColor, int secondaryColor) {
        return ITEMS.register(Registry.ENTITY_TYPE.getKey(entityTypeProvider).getPath() + "_spawn_egg", () -> new SpawnEggItem(entityTypeProvider, primaryColor, secondaryColor, ItemRegistry.getMekBaseProperties()));
    }
}
