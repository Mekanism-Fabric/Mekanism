//package mekanism.content.qio;
//
//import it.unimi.dsi.fastutil.objects.Object2LongMap.Entry;
//import mekanism.api.NBTConstants;
//import mekanism.lib.inventory.HashedItem;
//import mekanism.util.ItemDataUtils;
//import net.minecraft.item.ItemStack;
//import net.minecraft.nbt.NbtCompound;
//import net.minecraft.nbt.NbtElement;
//import net.minecraft.nbt.NbtList;
//
//public interface IQIODriveItem {
//
//    default boolean hasStoredItemMap(ItemStack stack) {
//        return ItemDataUtils.hasData(stack, NBTConstants.QIO_ITEM_MAP, NbtElement.LIST_TYPE);
//    }
//
//    default void loadItemMap(ItemStack stack, QIODriveData data) {
//        if (hasStoredItemMap(stack)) {
//            NbtList list = ItemDataUtils.getList(stack, NBTConstants.QIO_ITEM_MAP);
//            for (int i = 0; i < list.size(); i++) {
//                NbtCompound tag = list.getCompound(i);
//                ItemStack itemType = ItemStack.fromNbt(tag.getCompound(NBTConstants.ITEM));
//                if (!itemType.isEmpty()) {
//                    //Only add the item if the item could be read. If it can't that means the mod adding the item was probably removed
//                    //TODO: Eventually we may want to keep the NBT so that if the mod gets added back it exists again
//                    long count = tag.getLong(NBTConstants.AMOUNT);
//                    data.getItemMap().put(HashedItem.create(itemType), count);
//                }
//            }
//        }
//    }
//
//    default void writeItemMap(ItemStack stack, QIODriveData map) {
//        NbtList list = new NbtList();
//        for (Entry<HashedItem> entry : map.getItemMap().object2LongEntrySet()) {
//            NbtCompound tag = new NbtCompound();
//            tag.put(NBTConstants.ITEM, entry.getKey().getStack().writeNbt(new NbtCompound()));
//            tag.putLong(NBTConstants.AMOUNT, entry.getLongValue());
//            list.add(tag);
//        }
//        ItemDataUtils.setList(stack, NBTConstants.QIO_ITEM_MAP, list);
//    }
//
//    long getCountCapacity(ItemStack stack);
//
//    int getTypeCapacity(ItemStack stack);
//
//    class DriveMetadata {
//
//        private final long count;
//        private final int types;
//
//        public DriveMetadata(long count, int types) {
//            this.count = count;
//            this.types = types;
//        }
//
//        public void write(ItemStack stack) {
//            ItemDataUtils.setLong(stack, NBTConstants.QIO_META_COUNT, count);
//            ItemDataUtils.setInt(stack, NBTConstants.QIO_META_TYPES, types);
//        }
//
//        public static DriveMetadata load(ItemStack stack) {
//            return new DriveMetadata(ItemDataUtils.getLong(stack, NBTConstants.QIO_META_COUNT), ItemDataUtils.getInt(stack, NBTConstants.QIO_META_TYPES));
//        }
//
//        public long getCount() {
//            return count;
//        }
//
//        public int getTypes() {
//            return types;
//        }
//    }
//}
