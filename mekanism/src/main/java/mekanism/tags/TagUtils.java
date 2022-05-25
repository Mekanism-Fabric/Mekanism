//package mekanism.tags;
//
//import java.util.Set;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import net.minecraft.core.Registry;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.tags.TagKey;
//import net.minecraft.tags.TagManager;
//
//public class TagUtils {
//
//    public static <TYPE> Iterable<TYPE> manager(TYPE registry) {
//        Iterable<TYPE> tags = registry();
//        if (tags == null) {
//            throw new IllegalStateException("Expected " + registry.getRegistryName() + " to have tags.");
//        }
//        return tags;
//    }
//
//    public static <TYPE> TagKey<TYPE> tag(Registry<TYPE> registry, TagKey<TYPE> key) {
//        return manager(registry).getTag(key);
//    }
//
//    public static <TYPE> TagKey<TYPE> createKey(Registry<TYPE> registry, ResourceLocation tag) {
//        return manager(registry).createTagKey(tag);
//    }
//
//    public static <TYPE> Set<TagKey<TYPE>> tags(Registry<TYPE> registry, TYPE element) {
//        return tags(manager(registry), element);
//    }
//
//    public static <TYPE> Set<TagKey<TYPE>> tags(Iterable<TYPE> tagManager, TYPE element) {
//        return tagsStream(tagManager, element).collect(Collectors.toSet());
//    }
//
//    public static <TYPE> Stream<TagKey<TYPE>> tagsStream(Registry<TYPE> registry, TYPE element) {
//        return tagsStream(manager(registry), element);
//    }
//
//    public static <TYPE> Stream<TagKey<TYPE>> tagsStream(Iterable<TYPE> tagManager, TYPE element) {
//        return tagManager.getReverseTag(element)
//                .map(IReverseTag::getTagKeys)
//                .orElse(Stream.empty());
//    }
//
//    public static <TYPE> Set<ResourceLocation> tagNames(Registry<TYPE> registry, TYPE element) {
//        return tagNames(manager(registry), element);
//    }
//
//    public static <TYPE> Set<ResourceLocation> tagNames(TagManager<TYPE> tagManager, TYPE element) {
//        return tagNames(tagsStream(tagManager, element));
//    }
//
//    public static Set<ResourceLocation> tagNames(Stream<? extends TagKey<?>> stream) {
//        return stream.map(TagKey::location)
//                .collect(Collectors.toUnmodifiableSet());
//    }
//}