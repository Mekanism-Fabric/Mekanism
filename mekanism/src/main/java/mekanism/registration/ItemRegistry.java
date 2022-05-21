package mekanism.registration;

import mekanism.Mekanism;
import mekanism.api.text.EnumColor;
import mekanism.api.text.TextComponentUtil;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class ItemRegistry {

    private final List<Item> allItems = new ArrayList<>();
    private final String modid;

    public ItemRegistry(String modid) {
        this.modid = modid;
    }

    public static FabricItemSettings getMekBaseProperties() {
        return new FabricItemSettings().group(Mekanism.tabMekanism);
    }

    public Item register(String name) {
        return register(name, Item::new);
    }
    public <ITEM extends Item> ITEM register(String name, Function<Item.Properties, ITEM> sup) {
        return register(name, () -> sup.apply(getMekBaseProperties()));
    }
    public <ITEM extends Item> ITEM register(String name, Supplier<? extends ITEM> sup) {
        ITEM registeredItem = Registry.register(Registry.ITEM, new ResourceLocation(modid, name), sup.get());
        allItems.add(registeredItem);
        return registeredItem;
    }
    public Item register(String name, Rarity rarity) {
        return register(name, properties -> new Item(properties.rarity(rarity)));
    }
    public Item register(String name, EnumColor color) {
        return register(name, properties -> new Item(properties) {
            @NotNull
            @Override
            public Component getName(@NotNull ItemStack stack) {
                return TextComponentUtil.build(color, super.getName(stack));
            }
        });
    }

    public Item registerUnburnable(String name) {
        return registerUnburnable(name, Item::new);
    }
    public <ITEM extends Item> ITEM registerUnburnable(String name, Function<Item.Properties, ITEM> sup) {
        return register(name, () -> sup.apply(getMekBaseProperties().fireResistant()));
    }

//    public ItemModule registerModule(ModuleRegistryObject<?> moduleDataSupplier) {
//        //Note: We use the internal helper just in case we end up needing to know it is an ItemModule instead of just an Item somewhere
//        return register("module_" + moduleDataSupplier.getInternalRegistryName(),
//                () -> ModuleHelper.INSTANCE.createModuleItem(moduleDataSupplier, getMekBaseProperties()));
//    }

    public List<Item> getAllItems() {
        return allItems;
    }
}
