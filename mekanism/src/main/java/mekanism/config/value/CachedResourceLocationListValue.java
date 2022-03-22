package mekanism.config.value;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import mekanism.api.annotations.NonNull;
import mekanism.config.IMekanismConfig;
import net.minecraft.util.Identifier;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class CachedResourceLocationListValue extends CachedResolvableConfigValue<List<Identifier>, List<? extends String>> {

    private static final Supplier<List<? extends String>> EMPTY = ArrayList::new;

    private CachedResourceLocationListValue(IMekanismConfig config, ConfigValue<List<? extends String>> internal) {
        super(config, internal);
    }

    public static CachedResourceLocationListValue define(IMekanismConfig config, ForgeConfigSpec.Builder builder, String path,
          Predicate<@NonNull Identifier> rlValidator) {
        return new CachedResourceLocationListValue(config, builder.defineListAllowEmpty(Collections.singletonList(path), EMPTY, o -> {
            if (o instanceof String) {
                Identifier rl = Identifier.tryParse(((String) o).toLowerCase(Locale.ROOT));
                if (rl != null) {
                    return rlValidator.test(rl);
                }
            }
            return false;
        }));
    }

    @Override
    protected List<Identifier> resolve(List<? extends String> encoded) {
        //We ignore any strings that are invalid resource locations
        // validation should have happened before we got here, but in case something went wrong we don't want to crash and burn
        return encoded.stream().map(s -> Identifier.tryParse(s.toLowerCase(Locale.ROOT))).filter(Objects::nonNull).collect(Collectors.toCollection(() -> new ArrayList<>(encoded.size())));
    }

    @Override
    protected List<? extends String> encode(List<Identifier> values) {
        return values.stream().map(Identifier::toString).collect(Collectors.toCollection(() -> new ArrayList<>(values.size())));
    }
}