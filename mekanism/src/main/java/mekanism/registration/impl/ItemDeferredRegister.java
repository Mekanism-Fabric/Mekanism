package mekanism.registration.impl;

import mekanism.Mekanism;
import mekanism.api.providers.IItemProvider;
import mekanism.api.text.EnumColor;
import mekanism.api.text.TextComponentUtil;
import mekanism.registration.WrappedDeferredRegister;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SpawnEggItem;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class ItemDeferredRegister extends WrappedDeferredRegister<Item> {

    private final List<IItemProvider> allItems = new ArrayList<>();

    public ItemDeferredRegister(String modid) {
        super(modid, Registry.ITEM);
    }

    public static Item.Properties getMekBaseProperties() {
        return new Item.Properties().tab(Mekanism.tabMekanism);
    }

    public ItemRegistryObject<Item> register(String name) {
        return register(name, Item::new);
    }

    public ItemRegistryObject<Item> registerUnburnable(String name) {
        return registerUnburnable(name, Item::new);
    }

    public ItemRegistryObject<Item> register(String name, Rarity rarity) {
        return register(name, properties -> new Item(properties.rarity(rarity)));
    }

    public ItemRegistryObject<Item> register(String name, EnumColor color) {
        return register(name, properties -> new Item(properties) {
            @NotNull
            @Override
            public Component getName(@NotNull ItemStack stack) {
                return TextComponentUtil.build(color, super.getName(stack));
            }
        });
    }

//    public ItemRegistryObject<ItemModule> registerModule(ModuleRegistryObject<?> moduleDataSupplier) {
//        //Note: We use the internal helper just in case we end up needing to know it is an ItemModule instead of just an Item somewhere
//        return register("module_" + moduleDataSupplier.getInternalRegistryName(),
//                () -> ModuleHelper.INSTANCE.createModuleItem(moduleDataSupplier, getMekBaseProperties()));
//    }

    public <ITEM extends Item> ItemRegistryObject<ITEM> register(String name, Function<Item.Properties, ITEM> sup) {
        return register(name, () -> sup.apply(getMekBaseProperties()));
    }

    public <ITEM extends Item> ItemRegistryObject<ITEM> registerUnburnable(String name, Function<Item.Properties, ITEM> sup) {
        return register(name, () -> sup.apply(getMekBaseProperties().fireResistant()));
    }

    public <ITEM extends Item> ItemRegistryObject<ITEM> register(String name, Supplier<? extends ITEM> sup) {
        ItemRegistryObject<ITEM> registeredItem = register(name, sup, ItemRegistryObject::new);
        allItems.add(registeredItem);
        return registeredItem;
    }

    public <ENTITY extends Mob> ItemRegistryObject<SpawnEggItem> registerSpawnEgg(EntityTypeRegistryObject<ENTITY> entityTypeProvider,
                                                                                  int primaryColor, int secondaryColor) {
        return register(entityTypeProvider.getInternalRegistryName() + "_spawn_egg", props -> new SpawnEggItem(entityTypeProvider.getEntityType(), primaryColor,
                secondaryColor, props));
    }

    public List<IItemProvider> getAllItems() {
        return allItems;
    }
}