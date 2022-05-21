//package mekanism.tags;
//
//import net.minecraft.tags.TagKey;
//
//public record LazyTagLookup<TYPE>(TagKey<TYPE> key, TagKey<TYPE> lazyTag) {
//
//    public static <TYPE> LazyTagLookup<TYPE> create(TYPE registry, TagKey<TYPE> key) {
//        return new LazyTagLookup<>(key, Lazy.of(() -> TagUtils.manager(registry).getTag(key)));
//    }
////
////    public static <CHEMICAL extends Chemical<CHEMICAL>> LazyTagLookup<CHEMICAL> create(ChemicalTags<CHEMICAL> registry, TagKey<CHEMICAL> key) {
////        return new LazyTagLookup<>(key, Lazy.of(() -> registry.getManager().orElseThrow().getTag(key)));
////    }
//
//    public TagKey<TYPE> tag() {
//        return lazyTag.get();
//    }
//
//    public boolean contains(TYPE element) {
//        return tag().contains(element);
//    }
//
//    public boolean isEmpty() {
//        return tag().isEmpty();
//    }
//}