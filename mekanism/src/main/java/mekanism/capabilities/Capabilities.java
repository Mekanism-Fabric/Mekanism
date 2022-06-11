package mekanism.capabilities;

import mekanism.Mekanism;
import mekanism.api.IAlloyInteraction;
import mekanism.api.IConfigCardAccess;
import mekanism.api.IConfigurable;
import mekanism.api.IEvaporationSolar;
import mekanism.api.energy.IStrictEnergyHandler;
import mekanism.api.heat.IHeatHandler;
import mekanism.api.lasers.ILaserDissipation;
import mekanism.api.lasers.ILaserReceptor;
import mekanism.api.radiation.capability.IRadiationEntity;
import mekanism.api.radiation.capability.IRadiationShielding;
import mekanism.api.security.IOwnerObject;
import mekanism.api.security.ISecurityObject;
import net.fabricmc.fabric.api.lookup.v1.block.BlockApiLookup;
import net.fabricmc.fabric.api.lookup.v1.item.ItemApiLookup;
import net.fabricmc.fabric.api.transfer.v1.context.ContainerItemContext;
import net.minecraft.core.Direction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Capabilities {

    private Capabilities() {
    }
    //Blocks
//    public static final BlockApiLookup<IGasHandler, @NotNull Direction> GAS_HANDLER_CAPABILITY_SIDED =
//            BlockApiLookup.get(Mekanism.rl("gas_handler_sided"), IGasHandler.class, Direction.class);
//
//    public static final BlockApiLookup<IInfusionHandler, @NotNull Direction> INFUSION_HANDLER_CAPABILITY_SIDED =
//            BlockApiLookup.get(Mekanism.rl("infusion_handler_sided"), IInfusionHandler.class, Direction.class);
//
//    public static final BlockApiLookup<IPigmentHandler, @NotNull Direction> PIGMENT_HANDLER_CAPABILITY_SIDED =
//            BlockApiLookup.get(Mekanism.rl("pigment_handler_sided"), IPigmentHandler.class, Direction.class);
//
//    public static final BlockApiLookup<ISlurryHandler, @NotNull Direction> SLURRY_HANDLER_CAPABILITY_SIDED =
//            BlockApiLookup.get(Mekanism.rl("slurry_handler_sided"), ISlurryHandler.class, Direction.class);

    public static final BlockApiLookup<IHeatHandler, @NotNull Direction> HEAT_HANDLER_CAPABILITY_SIDED =
            BlockApiLookup.get(Mekanism.rl("heat_handler_sided"), IHeatHandler.class, Direction.class);

    public static final BlockApiLookup<IStrictEnergyHandler, @NotNull Direction> STRICT_ENERGY_CAPABILITY_SIDED =
            BlockApiLookup.get(Mekanism.rl("strict_energy_handler_sided"), IStrictEnergyHandler.class, Direction.class);

    public static final BlockApiLookup<IConfigurable, @NotNull Direction> CONFIGURABLE_CAPABILITY_SIDED =
            BlockApiLookup.get(Mekanism.rl("configurable_sided"), IConfigurable.class, Direction.class);

    public static final BlockApiLookup<IAlloyInteraction, @NotNull Direction> ALLOY_INTERACTION_CAPABILITY_SIDED =
            BlockApiLookup.get(Mekanism.rl("alloy_interaction_sided"), IAlloyInteraction.class, Direction.class);

    public static final BlockApiLookup<IConfigCardAccess, @NotNull Direction> CONFIG_CARD_CAPABILITY_SIDED =
            BlockApiLookup.get(Mekanism.rl("config_card_access_sided"), IConfigCardAccess.class, Direction.class);

    public static final BlockApiLookup<IEvaporationSolar, @NotNull Direction> EVAPORATION_SOLAR_CAPABILITY_SIDED =
            BlockApiLookup.get(Mekanism.rl("evaporation_solar_sided"), IEvaporationSolar.class, Direction.class);

    public static final BlockApiLookup<ILaserReceptor, @NotNull Direction> LASER_RECEPTOR_CAPABILITY_SIDED =
            BlockApiLookup.get(Mekanism.rl("laser_receptor_sided"), ILaserReceptor.class, Direction.class);

    public static final BlockApiLookup<ILaserDissipation, @NotNull Direction> LASER_DISSIPATION_CAPABILITY_SIDED =
            BlockApiLookup.get(Mekanism.rl("laser_dissipation_sided"), ILaserDissipation.class, Direction.class);

    public static final BlockApiLookup<IRadiationShielding, @NotNull Direction> RADIATION_SHIELDING_CAPABILITY_SIDED =
            BlockApiLookup.get(Mekanism.rl("radiation_shielding_sided"), IRadiationShielding.class, Direction.class);

    public static final BlockApiLookup<IRadiationEntity, @NotNull Direction> RADIATION_ENTITY_CAPABILITY_SIDED =
            BlockApiLookup.get(Mekanism.rl("radiation_entity_sided"), IRadiationEntity.class, Direction.class);

    public static final BlockApiLookup<IOwnerObject, @NotNull Direction> OWNER_OBJECT_SIDED =
            BlockApiLookup.get(Mekanism.rl("owner_object_sided"), IOwnerObject.class, Direction.class);

    public static final BlockApiLookup<ISecurityObject, @NotNull Direction> SECURITY_OBJECT_SIDED =
            BlockApiLookup.get(Mekanism.rl("security_object_sided"), ISecurityObject.class, Direction.class);

    //Items
//    public static final ItemApiLookup<IGasHandler, @Nullable ContainerItemContext> GAS_HANDLER_CAPABILITY =
//        ItemApiLookup.get(Mekanism.rl("gas_handler"), IGasHandler.class, ContainerItemContext.class);
//
//    public static final ItemApiLookup<IInfusionHandler, @Nullable ContainerItemContext> INFUSION_HANDLER_CAPABILITY =
//            ItemApiLookup.get(Mekanism.rl("infusion_handler"), IInfusionHandler.class, ContainerItemContext.class);
//
//    public static final ItemApiLookup<IPigmentHandler, @Nullable ContainerItemContext> PIGMENT_HANDLER_CAPABILITY =
//            ItemApiLookup.get(Mekanism.rl("pigment_handler"), IPigmentHandler.class, ContainerItemContext.class);
//
//    public static final ItemApiLookup<ISlurryHandler, @Nullable ContainerItemContext> SLURRY_HANDLER_CAPABILITY =
//            ItemApiLookup.get(Mekanism.rl("slurry_handler"), ISlurryHandler.class, ContainerItemContext.class);

    public static final ItemApiLookup<IHeatHandler, @Nullable ContainerItemContext> HEAT_HANDLER_CAPABILITY =
            ItemApiLookup.get(Mekanism.rl("heat_handler"), IHeatHandler.class, ContainerItemContext.class);

    public static final ItemApiLookup<IStrictEnergyHandler, @Nullable ContainerItemContext> STRICT_ENERGY_CAPABILITY =
            ItemApiLookup.get(Mekanism.rl("strict_energy_handler"), IStrictEnergyHandler.class, ContainerItemContext.class);

    public static final ItemApiLookup<IConfigurable, @Nullable ContainerItemContext> CONFIGURABLE_CAPABILITY =
            ItemApiLookup.get(Mekanism.rl("configurable"), IConfigurable.class, ContainerItemContext.class);

    public static final ItemApiLookup<IAlloyInteraction, @Nullable ContainerItemContext> ALLOY_INTERACTION_CAPABILITY =
            ItemApiLookup.get(Mekanism.rl("alloy_interaction"), IAlloyInteraction.class, ContainerItemContext.class);

    public static final ItemApiLookup<IConfigCardAccess, @Nullable ContainerItemContext> CONFIG_CARD_CAPABILITY =
            ItemApiLookup.get(Mekanism.rl("config_card_access"), IConfigCardAccess.class, ContainerItemContext.class);

    public static final ItemApiLookup<IEvaporationSolar, @Nullable ContainerItemContext> EVAPORATION_SOLAR_CAPABILITY =
            ItemApiLookup.get(Mekanism.rl("evaporation_solar"), IEvaporationSolar.class, ContainerItemContext.class);

    public static final ItemApiLookup<ILaserReceptor, @Nullable ContainerItemContext> LASER_RECEPTOR_CAPABILITY =
            ItemApiLookup.get(Mekanism.rl("laser_receptor"), ILaserReceptor.class, ContainerItemContext.class);

    public static final ItemApiLookup<ILaserDissipation, @Nullable ContainerItemContext> LASER_DISSIPATION_CAPABILITY =
            ItemApiLookup.get(Mekanism.rl("laser_dissipation"), ILaserDissipation.class, ContainerItemContext.class);

    public static final ItemApiLookup<IRadiationShielding, @Nullable ContainerItemContext> RADIATION_SHIELDING_CAPABILITY =
            ItemApiLookup.get(Mekanism.rl("radiation_shielding"), IRadiationShielding.class, ContainerItemContext.class);

    public static final ItemApiLookup<IRadiationEntity, @Nullable ContainerItemContext> RADIATION_ENTITY_CAPABILITY =
            ItemApiLookup.get(Mekanism.rl("radiation_entity"), IRadiationEntity.class, ContainerItemContext.class);

    public static final ItemApiLookup<IOwnerObject, @Nullable ContainerItemContext> OWNER_OBJECT =
            ItemApiLookup.get(Mekanism.rl("owner_object"), IOwnerObject.class, ContainerItemContext.class);

    public static final ItemApiLookup<ISecurityObject, @Nullable ContainerItemContext> SECURITY_OBJECT =
            ItemApiLookup.get(Mekanism.rl("security_object"), ISecurityObject.class, ContainerItemContext.class);

    public static void init() {
    }
}
