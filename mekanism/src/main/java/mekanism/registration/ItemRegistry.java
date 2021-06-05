package mekanism.registration;

import mekanism.Mekanism;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

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
    public <ITEM extends Item> ITEM register(String name, Function<Item.Settings, ITEM> sup) {
        return register(name, () -> sup.apply(getMekBaseProperties()));
    }
    public <ITEM extends Item> ITEM register(String name, Supplier<? extends ITEM> sup) {
        ITEM registeredItem = Registry.register(Registry.ITEM, new Identifier(modid, name), sup.get());
        allItems.add(registeredItem);
        return registeredItem;
    }

    public List<Item> getAllItems() {
        return allItems;
    }
}
