//package mekanism.tags;
//
//import java.util.Set;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.tags.TagKey;
//
//public class TagUtils {
//
//    public static <TYPE> ITagManager<TYPE> manager(TYPE registry) {
//        ITagManager<TYPE> tags = registry.tags();
//        if (tags == null) {
//            throw new IllegalStateException("Expected " + registry.getRegistryName() + " to have tags.");
//        }
//        return tags;
//    }
//
//    public static <TYPE> ITag<TYPE> tag(IForgeRegistry<TYPE> registry, TagKey<TYPE> key) {
//        return manager(registry).getTag(key);
//    }
//
//    public static <TYPE> TagKey<TYPE> createKey(IForgeRegistry<TYPE> registry, ResourceLocation tag) {
//        return manager(registry).createTagKey(tag);
//    }
//
//    public static <TYPE> Set<TagKey<TYPE>> tags(IForgeRegistry<TYPE> registry, TYPE element) {
//        return tags(manager(registry), element);
//    }
//
//    public static <TYPE> Set<TagKey<TYPE>> tags(ITagManager<TYPE> tagManager, TYPE element) {
//        return tagsStream(tagManager, element).collect(Collectors.toSet());
//    }
//
//    public static <TYPE> Stream<TagKey<TYPE>> tagsStream(IForgeRegistry<TYPE> registry, TYPE element) {
//        return tagsStream(manager(registry), element);
//    }
//
//    public static <TYPE> Stream<TagKey<TYPE>> tagsStream(ITagManager<TYPE> tagManager, TYPE element) {
//        return tagManager.getReverseTag(element)
//                .map(IReverseTag::getTagKeys)
//                .orElse(Stream.empty());
//    }
//
//    public static <TYPE> Set<ResourceLocation> tagNames(IForgeRegistry<TYPE> registry, TYPE element) {
//        return tagNames(manager(registry), element);
//    }
//
//    public static <TYPE> Set<ResourceLocation> tagNames(ITagManager<TYPE> tagManager, TYPE element) {
//        return tagNames(tagsStream(tagManager, element));
//    }
//
//    public static Set<ResourceLocation> tagNames(Stream<? extends TagKey<?>> stream) {
//        return stream.map(TagKey::location)
//                .collect(Collectors.toUnmodifiableSet());
//    }
//}