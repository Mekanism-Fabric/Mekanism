package mekanism.capabilities;

import mekanism.Mekanism;
import mekanism.api.IAlloyInteraction;
import mekanism.api.IConfigCardAccess;
import mekanism.api.IConfigurable;
import mekanism.api.energy.IStrictEnergyHandler;
import net.fabricmc.fabric.api.lookup.v1.block.BlockApiLookup;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.NotNull;

public class Capabilities {

//    @CapabilityInject(IGasHandler.class)
//    public static Capability<IGasHandler> GAS_HANDLER_CAPABILITY;
//
//    @CapabilityInject(IInfusionHandler.class)
//    public static Capability<IInfusionHandler> INFUSION_HANDLER_CAPABILITY;
//
//    @CapabilityInject(IPigmentHandler.class)
//    public static Capability<IPigmentHandler> PIGMENT_HANDLER_CAPABILITY;
//
//    @CapabilityInject(ISlurryHandler.class)
//    public static Capability<ISlurryHandler> SLURRY_HANDLER_CAPABILITY;
//
//    @CapabilityInject(IHeatHandler.class)
//    public static Capability<IHeatHandler> HEAT_HANDLER_CAPABILITY;
//

    public static final BlockApiLookup<IStrictEnergyHandler, @NotNull Direction> STRICT_ENERGY_CAPABILITY =
            BlockApiLookup.get(Mekanism.id("strict_energy_handler"), IStrictEnergyHandler.class, Direction.class);

    public static final BlockApiLookup<IConfigurable, @NotNull Direction> CONFIGURABLE_CAPABILITY =
            BlockApiLookup.get(Mekanism.id("configurable"), IConfigurable.class, Direction.class);

    public static final BlockApiLookup<IAlloyInteraction, @NotNull Direction> ALLOY_INTERACTION_CAPABILITY =
            BlockApiLookup.get(Mekanism.id("alloy_interaction"), IAlloyInteraction.class, Direction.class);

    public static final BlockApiLookup<IConfigCardAccess, @NotNull Direction> CONFIG_CARD_CAPABILITY =
            BlockApiLookup.get(Mekanism.id("config_card_access"), IConfigCardAccess.class, Direction.class);

//    @CapabilityInject(IEvaporationSolar.class)
//    public static Capability<IEvaporationSolar> EVAPORATION_SOLAR_CAPABILITY;
//
//    @CapabilityInject(ILaserReceptor.class)
//    public static Capability<ILaserReceptor> LASER_RECEPTOR_CAPABILITY;
//
//    @CapabilityInject(ILaserDissipation.class)
//    public static Capability<ILaserDissipation> LASER_DISSIPATION_CAPABILITY;
//
//    @CapabilityInject(IRadiationShielding.class)
//    public static Capability<IRadiationShielding> RADIATION_SHIELDING_CAPABILITY;
//
//    @CapabilityInject(IRadiationEntity.class)
//    public static Capability<IRadiationEntity> RADIATION_ENTITY_CAPABILITY;

    private Capabilities() {

    }
}
