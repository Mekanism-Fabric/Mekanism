package mekanism.additions.registries;

import mekanism.additions.MekanismAdditions;
import mekanism.api.text.EnumColor;
import mekanism.registration.impl.ItemDeferredRegister;
import mekanism.registration.impl.ItemRegistryObject;
import mekanism.util.EnumUtils;
import net.minecraft.item.SpawnEggItem;

import java.util.EnumMap;

public final class AdditionsItems {



    public static final ItemDeferredRegister ITEMS = new ItemDeferredRegister(MekanismAdditions.MODID);

    public static final ItemRegistryObject<SpawnEggItem> BABY_CREEPER_SPAWN_EGG = ITEMS.registerSpawnEgg(AdditionsEntityTypes.BABY_CREEPER, 0x31E02F, 0x1E1E1E);
    public static final ItemRegistryObject<SpawnEggItem> BABY_ENDERMAN_SPAWN_EGG = ITEMS.registerSpawnEgg(AdditionsEntityTypes.BABY_ENDERMAN, 0x242424, 0x1E1E1E);
    public static final ItemRegistryObject<SpawnEggItem> BABY_SKELETON_SPAWN_EGG = ITEMS.registerSpawnEgg(AdditionsEntityTypes.BABY_SKELETON, 0xFFFFFF, 0x800080);
    public static final ItemRegistryObject<SpawnEggItem> BABY_STRAY_SPAWN_EGG = ITEMS.registerSpawnEgg(AdditionsEntityTypes.BABY_STRAY, 0x7B9394, 0xF2FAFA);
    public static final ItemRegistryObject<SpawnEggItem> BABY_WITHER_SKELETON_SPAWN_EGG = ITEMS.registerSpawnEgg(AdditionsEntityTypes.BABY_WITHER_SKELETON, 0x303030, 0x525454);
//    public static final ItemRegistryObject<ItemWalkieTalkie> WALKIE_TALKIE = ITEMS.register("walkie_talkie", ItemWalkieTalkie::new);
//
//    public static final Map<EnumColor, ItemRegistryObject<ItemBalloon>> BALLOONS = new EnumMap<>(EnumColor.class);
//
//    static {
//        for (EnumColor color : EnumUtils.COLORS) {
//            BALLOONS.put(color, ITEMS.register(color.getRegistryPrefix() + "_balloon", () -> new ItemBalloon(color)));
//        }
//    }

    public static void init() {

    }

}
