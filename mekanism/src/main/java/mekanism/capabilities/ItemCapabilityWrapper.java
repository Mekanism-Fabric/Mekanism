package mekanism.capabilities;

import io.github.fabricators_of_create.porting_lib.util.LazyOptional;
import net.fabricmc.fabric.api.lookup.v1.item.ItemApiLookup;
import net.fabricmc.fabric.api.transfer.v1.context.ContainerItemContext;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

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

    @Nonnull
    public <T> LazyOptional<T> getCapability(@Nonnull ItemApiLookup<T, ContainerItemContext> capability, @Nullable Direction side) {
        if (!itemStack.isEmpty()) {
            //Only provide capabilities if we are not empty and the capability is registered
            // as if it isn't registered we can just short circuit and not look up the capability
            for (ItemCapability cap : capabilities) {
                /*if (cap.capabilityCache.isCapabilityDisabled(capability, null)) {
                    //Note: Currently no item capabilities have toggleable capabilities, but check anyway to properly support our API
                    return LazyOptional.empty();
                } else */if (cap.capabilityCache.canResolve(capability)) {
                    //Make sure that we load any data the cap needs from the stack, as it doesn't have any NBT set when it is initially initialized
                    // This also allows us to update to any direct changes on the NBT of the stack that someone may have made
                    //TODO: Potentially move the loading to the capability initializing spot, as NBT shouldn't be randomly changing anyways
                    // and then that may allow us to better cache the capabilities
                    cap.load();
                    return cap.capabilityCache.getCapabilityUnchecked(capability);
                }
            }
        }
        return LazyOptional.empty();
    }

    public abstract static class ItemCapability {

        private final CapabilityCacheItem capabilityCache = new CapabilityCacheItem();
        private ItemCapabilityWrapper wrapper;

        protected abstract void addCapabilityResolvers(CapabilityCacheItem capabilityCache);

        protected void init() {
            addCapabilityResolvers(capabilityCache);
        }

        protected void load() {
        }

        public ItemStack getStack() {
            return wrapper.itemStack;
        }
    }
}