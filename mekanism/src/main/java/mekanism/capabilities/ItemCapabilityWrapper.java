package mekanism.capabilities;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;

public class ItemCapabilityWrapper {

    protected final ItemStack itemStack;
    private final List<ItemCapability> capabilities = new ArrayList<>();

    public ItemCapabilityWrapper(ItemStack stack, ItemCapability... caps) {
        itemStack = stack;
        add(caps);
    }

    public void add(ItemCapability... caps) {
        for (ItemCapability c : caps) {
            c.wrapper = this;
            c.init();
            capabilities.add(c);
        }
    }

    public abstract static class ItemCapability {

        private ItemCapabilityWrapper wrapper;

        protected void init() {
        }

        protected void load() {
        }

        public ItemStack getStack() {
            return wrapper.itemStack;
        }
    }
}