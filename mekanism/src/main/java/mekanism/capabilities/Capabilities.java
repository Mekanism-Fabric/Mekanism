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
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Capabilities {

    private Capabilities() {
    }

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
    public static final BlockApiLookup<IHeatHandler, @NotNull Direction> HEAT_HANDLER_CAPABILITY =
            BlockApiLookup.get(Mekanism.rl("heat_handler"), IHeatHandler.class, Direction.class);

    public static final ItemApiLookup<IStrictEnergyHandler, @Nullable ContainerItemContext> STRICT_ENERGY_CAPABILITY =
            ItemApiLookup.get(Mekanism.rl("strict_energy_handler"), IStrictEnergyHandler.class, ContainerItemContext.class);

    public static final BlockApiLookup<IConfigurable, @NotNull Direction> CONFIGURABLE_CAPABILITY =
            BlockApiLookup.get(Mekanism.rl("configurable"), IConfigurable.class, Direction.class);

    public static final BlockApiLookup<IAlloyInteraction, @NotNull Direction> ALLOY_INTERACTION_CAPABILITY =
            BlockApiLookup.get(Mekanism.rl("alloy_interaction"), IAlloyInteraction.class, Direction.class);

    public static final BlockApiLookup<IConfigCardAccess, @NotNull Direction> CONFIG_CARD_CAPABILITY =
            BlockApiLookup.get(Mekanism.rl("config_card_access"), IConfigCardAccess.class, Direction.class);

    public static final BlockApiLookup<IEvaporationSolar, @NotNull Direction> EVAPORATION_SOLAR_CAPABILITY =
            BlockApiLookup.get(Mekanism.rl("evaporation_solar"), IEvaporationSolar.class, Direction.class);

    public static final BlockApiLookup<ILaserReceptor, @NotNull Direction> LASER_RECEPTOR_CAPABILITY =
            BlockApiLookup.get(Mekanism.rl("laser_receptor"), ILaserReceptor.class, Direction.class);

    public static final BlockApiLookup<ILaserDissipation, @NotNull Direction> LASER_DISSIPATION_CAPABILITY =
            BlockApiLookup.get(Mekanism.rl("laser_dissipation"), ILaserDissipation.class, Direction.class);

    public static final BlockApiLookup<IRadiationShielding, @NotNull Direction> RADIATION_SHIELDING_CAPABILITY =
            BlockApiLookup.get(Mekanism.rl("radiation_shielding"), IRadiationShielding.class, Direction.class);

    public static final BlockApiLookup<IRadiationEntity, @NotNull Direction> RADIATION_ENTITY_CAPABILITY =
            BlockApiLookup.get(Mekanism.rl("radiation_entity"), IRadiationEntity.class, Direction.class);

    public static final BlockApiLookup<IOwnerObject, @NotNull Direction> OWNER_OBJECT =
            BlockApiLookup.get(Mekanism.rl("owner_object"), IOwnerObject.class, Direction.class);

    public static final BlockApiLookup<ISecurityObject, @NotNull Direction> SECURITY_OBJECT =
            BlockApiLookup.get(Mekanism.rl("security_object"), ISecurityObject.class, Direction.class);

    public static void init() {
    }
}
