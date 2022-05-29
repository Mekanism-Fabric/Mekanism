package mekanism.registries;

import mekanism.MekanismLang;
import mekanism.api.math.FloatingLong;
import mekanism.block.attribute.AttributeParticleFX;
import mekanism.block.attribute.AttributeTier;
import mekanism.block.attribute.AttributeUpgradeSupport;
import mekanism.block.attribute.AttributeUpgradeable;
import mekanism.block.attribute.Attributes.AttributeRedstone;
import mekanism.block.attribute.Attributes.AttributeSecurity;
import mekanism.content.blocktype.Machine;
import mekanism.content.blocktype.Machine.MachineBuilder;
import mekanism.registration.impl.BlockRegistryObject;
import mekanism.registration.impl.TileEntityTypeRegistryObject;
import mekanism.tier.BinTier;
import mekanism.tile.TileEntityBin;

import java.util.function.Supplier;

public class MekanismBlockTypes {

    private MekanismBlockTypes() {
    }

    private static final FloatingLong RESISTIVE_HEATER_BASE_USAGE = FloatingLong.createConst(100);

//    private static final Table<FactoryTier, FactoryType, Factory<?>> FACTORIES = HashBasedTable.create();
//
//    // Enrichment Chamber
//    public static final FactoryMachine<TileEntityEnrichmentChamber> ENRICHMENT_CHAMBER = MachineBuilder
//          .createFactoryMachine(() -> MekanismTileEntityTypes.ENRICHMENT_CHAMBER, MekanismLang.DESCRIPTION_ENRICHMENT_CHAMBER, FactoryType.ENRICHING)
//          .withGui(() -> MekanismContainerTypes.ENRICHMENT_CHAMBER)
//          .withSound(MekanismSounds.ENRICHMENT_CHAMBER)
//          .withEnergyConfig(MekanismConfig.usage.enrichmentChamber, MekanismConfig.storage.enrichmentChamber)
//          .withComputerSupport("enrichmentChamber")
//          .build();
//    // Crusher
//    public static final FactoryMachine<TileEntityCrusher> CRUSHER = MachineBuilder
//          .createFactoryMachine(() -> MekanismTileEntityTypes.CRUSHER, MekanismLang.DESCRIPTION_CRUSHER, FactoryType.CRUSHING)
//          .withGui(() -> MekanismContainerTypes.CRUSHER)
//          .withSound(MekanismSounds.CRUSHER)
//          .withEnergyConfig(MekanismConfig.usage.crusher, MekanismConfig.storage.crusher)
//          .withComputerSupport("crusher")
//          .build();
//    // Energized Smelter
//    public static final FactoryMachine<TileEntityEnergizedSmelter> ENERGIZED_SMELTER = MachineBuilder
//          .createFactoryMachine(() -> MekanismTileEntityTypes.ENERGIZED_SMELTER, MekanismLang.DESCRIPTION_ENERGIZED_SMELTER, FactoryType.SMELTING)
//          .withGui(() -> MekanismContainerTypes.ENERGIZED_SMELTER)
//          .withSound(MekanismSounds.ENERGIZED_SMELTER)
//          .withEnergyConfig(MekanismConfig.usage.energizedSmelter, MekanismConfig.storage.energizedSmelter)
//          .withComputerSupport("energizedSmelter")
//          .build();
//    // Precision Sawmill
//    public static final FactoryMachine<TileEntityPrecisionSawmill> PRECISION_SAWMILL = MachineBuilder
//          .createFactoryMachine(() -> MekanismTileEntityTypes.PRECISION_SAWMILL, MekanismLang.DESCRIPTION_PRECISION_SAWMILL, FactoryType.SAWING)
//          .withGui(() -> MekanismContainerTypes.PRECISION_SAWMILL)
//          .withSound(MekanismSounds.PRECISION_SAWMILL)
//          .withEnergyConfig(MekanismConfig.usage.precisionSawmill, MekanismConfig.storage.precisionSawmill)
//          .withComputerSupport("precisionSawmill")
//          .build();
//    // Osmium Compressor
//    public static final FactoryMachine<TileEntityOsmiumCompressor> OSMIUM_COMPRESSOR = MachineBuilder
//          .createFactoryMachine(() -> MekanismTileEntityTypes.OSMIUM_COMPRESSOR, MekanismLang.DESCRIPTION_OSMIUM_COMPRESSOR, FactoryType.COMPRESSING)
//          .withGui(() -> MekanismContainerTypes.OSMIUM_COMPRESSOR)
//          .withSound(MekanismSounds.OSMIUM_COMPRESSOR)
//          .withEnergyConfig(MekanismConfig.usage.osmiumCompressor, MekanismConfig.storage.osmiumCompressor)
//          .withComputerSupport("osmiumCompressor")
//          .build();
//    // Combiner
//    public static final FactoryMachine<TileEntityCombiner> COMBINER = MachineBuilder
//          .createFactoryMachine(() -> MekanismTileEntityTypes.COMBINER, MekanismLang.DESCRIPTION_COMBINER, FactoryType.COMBINING)
//          .withGui(() -> MekanismContainerTypes.COMBINER)
//          .withSound(MekanismSounds.COMBINER)
//          .withEnergyConfig(MekanismConfig.usage.combiner, MekanismConfig.storage.combiner)
//          .withComputerSupport("combiner")
//          .build();
//    // Metallurgic Infuser
//    public static final FactoryMachine<TileEntityMetallurgicInfuser> METALLURGIC_INFUSER = MachineBuilder
//          .createFactoryMachine(() -> MekanismTileEntityTypes.METALLURGIC_INFUSER, MekanismLang.DESCRIPTION_METALLURGIC_INFUSER, FactoryType.INFUSING)
//          .withGui(() -> MekanismContainerTypes.METALLURGIC_INFUSER)
//          .withSound(MekanismSounds.METALLURGIC_INFUSER)
//          .withEnergyConfig(MekanismConfig.usage.metallurgicInfuser, MekanismConfig.storage.metallurgicInfuser)
//          .withCustomShape(BlockShapes.METALLURGIC_INFUSER)
//          .withComputerSupport("metallurgicInfuser")
//          .build();
//    // Purification Chamber
//    public static final FactoryMachine<TileEntityPurificationChamber> PURIFICATION_CHAMBER = MachineBuilder
//          .createFactoryMachine(() -> MekanismTileEntityTypes.PURIFICATION_CHAMBER, MekanismLang.DESCRIPTION_PURIFICATION_CHAMBER, FactoryType.PURIFYING)
//          .withGui(() -> MekanismContainerTypes.PURIFICATION_CHAMBER)
//          .withSound(MekanismSounds.PURIFICATION_CHAMBER)
//          .withEnergyConfig(MekanismConfig.usage.purificationChamber, MekanismConfig.storage.purificationChamber)
//          .withSupportedUpgrades(EnumSet.of(Upgrade.SPEED, Upgrade.ENERGY, Upgrade.MUFFLING, Upgrade.GAS))
//          .withComputerSupport("purificationChamber")
//          .build();
//    // Chemical Injection Chamber
//    public static final FactoryMachine<TileEntityChemicalInjectionChamber> CHEMICAL_INJECTION_CHAMBER = MachineBuilder
//          .createFactoryMachine(() -> MekanismTileEntityTypes.CHEMICAL_INJECTION_CHAMBER, MekanismLang.DESCRIPTION_CHEMICAL_INJECTION_CHAMBER, FactoryType.INJECTING)
//          .withGui(() -> MekanismContainerTypes.CHEMICAL_INJECTION_CHAMBER)
//          .withSound(MekanismSounds.CHEMICAL_INJECTION_CHAMBER)
//          .withEnergyConfig(MekanismConfig.usage.chemicalInjectionChamber, MekanismConfig.storage.chemicalInjectionChamber)
//          .withSupportedUpgrades(EnumSet.of(Upgrade.SPEED, Upgrade.ENERGY, Upgrade.MUFFLING, Upgrade.GAS))
//          .withComputerSupport("chemicalInjectionChamber")
//          .build();
//    // Pressurized Reaction Chamber
//    public static final Machine<TileEntityPressurizedReactionChamber> PRESSURIZED_REACTION_CHAMBER = MachineBuilder
//          .createMachine(() -> MekanismTileEntityTypes.PRESSURIZED_REACTION_CHAMBER, MekanismLang.DESCRIPTION_PRESSURIZED_REACTION_CHAMBER)
//          .withGui(() -> MekanismContainerTypes.PRESSURIZED_REACTION_CHAMBER)
//          .withSound(MekanismSounds.PRESSURIZED_REACTION_CHAMBER)
//          .withEnergyConfig(MekanismConfig.usage.pressurizedReactionBase, MekanismConfig.storage.pressurizedReactionBase)
//          .withCustomShape(BlockShapes.PRESSURIZED_REACTION_CHAMBER)
//          .withComputerSupport("pressurizedReactionChamber")
//          .build();
//    // Chemical Crystallizer
//    public static final Machine<TileEntityChemicalCrystallizer> CHEMICAL_CRYSTALLIZER = MachineBuilder
//          .createMachine(() -> MekanismTileEntityTypes.CHEMICAL_CRYSTALLIZER, MekanismLang.DESCRIPTION_CHEMICAL_CRYSTALLIZER)
//          .withGui(() -> MekanismContainerTypes.CHEMICAL_CRYSTALLIZER)
//          .withSound(MekanismSounds.CHEMICAL_CRYSTALLIZER)
//          .withEnergyConfig(MekanismConfig.usage.chemicalCrystallizer, MekanismConfig.storage.chemicalCrystallizer)
//          .withCustomShape(BlockShapes.CHEMICAL_CRYSTALLIZER)
//          .withComputerSupport("chemicalCrystallizer")
//          .build();
//    // Chemical Dissolution Chamber
//    public static final Machine<TileEntityChemicalDissolutionChamber> CHEMICAL_DISSOLUTION_CHAMBER = MachineBuilder
//          .createMachine(() -> MekanismTileEntityTypes.CHEMICAL_DISSOLUTION_CHAMBER, MekanismLang.DESCRIPTION_CHEMICAL_DISSOLUTION_CHAMBER)
//          .withGui(() -> MekanismContainerTypes.CHEMICAL_DISSOLUTION_CHAMBER)
//          .withSound(MekanismSounds.CHEMICAL_DISSOLUTION_CHAMBER)
//          .withEnergyConfig(MekanismConfig.usage.chemicalDissolutionChamber, MekanismConfig.storage.chemicalDissolutionChamber)
//          .withSupportedUpgrades(EnumSet.of(Upgrade.SPEED, Upgrade.ENERGY, Upgrade.MUFFLING, Upgrade.GAS))
//          .withCustomShape(BlockShapes.CHEMICAL_DISSOLUTION_CHAMBER)
//          .withComputerSupport("chemicalDissolutionChamber")
//          .build();
//    // Chemical Infuser
//    public static final Machine<TileEntityChemicalInfuser> CHEMICAL_INFUSER = MachineBuilder
//          .createMachine(() -> MekanismTileEntityTypes.CHEMICAL_INFUSER, MekanismLang.DESCRIPTION_CHEMICAL_INFUSER)
//          .withGui(() -> MekanismContainerTypes.CHEMICAL_INFUSER)
//          .withSound(MekanismSounds.CHEMICAL_INFUSER)
//          .withEnergyConfig(MekanismConfig.usage.chemicalInfuser, MekanismConfig.storage.chemicalInfuser)
//          .withCustomShape(BlockShapes.CHEMICAL_INFUSER)
//          .withComputerSupport("chemicalInfuser")
//          .build();
//    // Chemical Oxidizer
//    public static final Machine<TileEntityChemicalOxidizer> CHEMICAL_OXIDIZER = MachineBuilder
//          .createMachine(() -> MekanismTileEntityTypes.CHEMICAL_OXIDIZER, MekanismLang.DESCRIPTION_CHEMICAL_OXIDIZER)
//          .withGui(() -> MekanismContainerTypes.CHEMICAL_OXIDIZER)
//          .withSound(MekanismSounds.CHEMICAL_OXIDIZER)
//          .withEnergyConfig(MekanismConfig.usage.oxidationChamber, MekanismConfig.storage.oxidationChamber)
//          .withCustomShape(BlockShapes.CHEMICAL_OXIDIZER)
//          .withComputerSupport("chemicalOxidizer")
//          .build();
//    // Chemical Washer
//    public static final Machine<TileEntityChemicalWasher> CHEMICAL_WASHER = MachineBuilder
//          .createMachine(() -> MekanismTileEntityTypes.CHEMICAL_WASHER, MekanismLang.DESCRIPTION_CHEMICAL_WASHER)
//          .withGui(() -> MekanismContainerTypes.CHEMICAL_WASHER)
//          .withSound(MekanismSounds.CHEMICAL_WASHER)
//          .withEnergyConfig(MekanismConfig.usage.chemicalWasher, MekanismConfig.storage.chemicalWasher)
//          .withCustomShape(BlockShapes.CHEMICAL_WASHER)
//          .withComputerSupport("chemicalWasher")
//          .build();
//    // Rotary Condensentrator
//    public static final Machine<TileEntityRotaryCondensentrator> ROTARY_CONDENSENTRATOR = MachineBuilder
//          .createMachine(() -> MekanismTileEntityTypes.ROTARY_CONDENSENTRATOR, MekanismLang.DESCRIPTION_ROTARY_CONDENSENTRATOR)
//          .withGui(() -> MekanismContainerTypes.ROTARY_CONDENSENTRATOR)
//          .withSound(MekanismSounds.ROTARY_CONDENSENTRATOR)
//          .withEnergyConfig(MekanismConfig.usage.rotaryCondensentrator, MekanismConfig.storage.rotaryCondensentrator)
//          .withCustomShape(BlockShapes.ROTARY_CONDENSENTRATOR)
//          .withComputerSupport("rotaryCondensentrator")
//          .build();
//    // Electrolytic Separator
//    public static final Machine<TileEntityElectrolyticSeparator> ELECTROLYTIC_SEPARATOR = MachineBuilder
//          .createMachine(() -> MekanismTileEntityTypes.ELECTROLYTIC_SEPARATOR, MekanismLang.DESCRIPTION_ELECTROLYTIC_SEPARATOR)
//          .withGui(() -> MekanismContainerTypes.ELECTROLYTIC_SEPARATOR)
//          .withSound(MekanismSounds.ELECTROLYTIC_SEPARATOR)
//          .withEnergyConfig(() -> MekanismConfig.general.FROM_H2.get().multiply(2), MekanismConfig.storage.electrolyticSeparator)
//          .withCustomShape(BlockShapes.ELECTROLYTIC_SEPARATOR)
//          .withComputerSupport("electrolyticSeparator")
//          .build();
//    // Digital Miner
//    public static final Machine<TileEntityDigitalMiner> DIGITAL_MINER = MachineBuilder
//          .createMachine(() -> MekanismTileEntityTypes.DIGITAL_MINER, MekanismLang.DESCRIPTION_DIGITAL_MINER)
//          .withGui(() -> MekanismContainerTypes.DIGITAL_MINER)
//          .withEnergyConfig(MekanismConfig.usage.digitalMiner, MekanismConfig.storage.digitalMiner)
//          .withSupportedUpgrades(EnumSet.of(Upgrade.SPEED, Upgrade.ENERGY, Upgrade.ANCHOR, Upgrade.STONE_GENERATOR))
//          .withCustomShape(BlockShapes.DIGITAL_MINER)
//          .with(AttributeCustomSelectionBox.JSON)
//          .withBounding((pos, state, builder) -> {
//              for (int x = -1; x <= 1; x++) {
//                  for (int y = 0; y <= 1; y++) {
//                      for (int z = -1; z <= 1; z++) {
//                          if (x != 0 || y != 0 || z != 0) {
//                              builder.add(pos.offset(x, y, z));
//                          }
//                      }
//                  }
//              }
//          })
//          .withComputerSupport("digitalMiner")
//          .replace(Attributes.ACTIVE)
//          .build();
//    // Formulaic Assemblicator
//    public static final Machine<TileEntityFormulaicAssemblicator> FORMULAIC_ASSEMBLICATOR = MachineBuilder
//          .createMachine(() -> MekanismTileEntityTypes.FORMULAIC_ASSEMBLICATOR, MekanismLang.DESCRIPTION_FORMULAIC_ASSEMBLICATOR)
//          .withGui(() -> MekanismContainerTypes.FORMULAIC_ASSEMBLICATOR)
//          .withEnergyConfig(MekanismConfig.usage.formulaicAssemblicator, MekanismConfig.storage.formulaicAssemblicator)
//          .withSupportedUpgrades(EnumSet.of(Upgrade.SPEED, Upgrade.ENERGY))
//          .withComputerSupport("formulaicAssemblicator")
//          .build();
//    // Electric Pump
//    public static final Machine<TileEntityElectricPump> ELECTRIC_PUMP = MachineBuilder
//          .createMachine(() -> MekanismTileEntityTypes.ELECTRIC_PUMP, MekanismLang.DESCRIPTION_ELECTRIC_PUMP)
//          .withGui(() -> MekanismContainerTypes.ELECTRIC_PUMP)
//          .withEnergyConfig(MekanismConfig.usage.electricPump, MekanismConfig.storage.electricPump)
//          .withSupportedUpgrades(EnumSet.of(Upgrade.SPEED, Upgrade.ENERGY, Upgrade.FILTER))
//          .withCustomShape(BlockShapes.ELECTRIC_PUMP)
//          .withComputerSupport("electricPump")
//          .replace(Attributes.ACTIVE)
//          .build();
//    // Fluidic Plenisher
//    public static final Machine<TileEntityFluidicPlenisher> FLUIDIC_PLENISHER = MachineBuilder
//          .createMachine(() -> MekanismTileEntityTypes.FLUIDIC_PLENISHER, MekanismLang.DESCRIPTION_FLUIDIC_PLENISHER)
//          .withGui(() -> MekanismContainerTypes.FLUIDIC_PLENISHER)
//          .withEnergyConfig(MekanismConfig.usage.fluidicPlenisher, MekanismConfig.storage.fluidicPlenisher)
//          .withSupportedUpgrades(EnumSet.of(Upgrade.SPEED, Upgrade.ENERGY))
//          .withCustomShape(BlockShapes.FLUIDIC_PLENISHER)
//          .withComputerSupport("fluidicPlenisher")
//          .replace(Attributes.ACTIVE)
//          .build();
//    // Solar Neutron Activator
//    public static final Machine<TileEntitySolarNeutronActivator> SOLAR_NEUTRON_ACTIVATOR = MachineBuilder
//          .createMachine(() -> MekanismTileEntityTypes.SOLAR_NEUTRON_ACTIVATOR, MekanismLang.DESCRIPTION_SOLAR_NEUTRON_ACTIVATOR)
//          .withGui(() -> MekanismContainerTypes.SOLAR_NEUTRON_ACTIVATOR)
//          .without(AttributeParticleFX.class, AttributeUpgradeSupport.class)
//          .withCustomShape(BlockShapes.SOLAR_NEUTRON_ACTIVATOR)
//          .with(AttributeCustomSelectionBox.JAVA)
//          .withBounding((pos, state, builder) -> builder.add(pos.above()))
//          .withComputerSupport("solarNeutronActivator")
//          .replace(Attributes.ACTIVE)
//          .build();
//    // Teleporter
//    public static final Machine<TileEntityTeleporter> TELEPORTER = MachineBuilder
//          .createMachine(() -> MekanismTileEntityTypes.TELEPORTER, MekanismLang.DESCRIPTION_TELEPORTER)
//          .withGui(() -> MekanismContainerTypes.TELEPORTER)
//          .withEnergyConfig(MekanismConfig.storage.teleporter)
//          .withSupportedUpgrades(EnumSet.of(Upgrade.ANCHOR))
//          .without(AttributeStateActive.class, AttributeStateFacing.class, AttributeParticleFX.class)
//          .withLight(10)
//          .withComputerSupport("teleporter")
//          .build();
//    // Chargepad
//    public static final BlockTypeTile<TileEntityChargepad> CHARGEPAD = BlockTileBuilder
//          .createBlock(() -> MekanismTileEntityTypes.CHARGEPAD, MekanismLang.DESCRIPTION_CHARGEPAD)
//          .withEnergyConfig(MekanismConfig.usage.chargePad, MekanismConfig.storage.chargePad)
//          .withSound(MekanismSounds.CHARGEPAD)
//          .with(Attributes.ACTIVE_LIGHT, new AttributeStateFacing())
//          .withCustomShape(BlockShapes.CHARGEPAD)
//          .withComputerSupport("chargepad")
//          .build();
//    // Laser
//    public static final BlockTypeTile<TileEntityLaser> LASER = BlockTileBuilder
//          .createBlock(() -> MekanismTileEntityTypes.LASER, MekanismLang.DESCRIPTION_LASER)
//          .withEnergyConfig(MekanismConfig.usage.laser, MekanismConfig.storage.laser)
//          .withSound(MekanismSounds.LASER)
//          .with(Attributes.ACTIVE, new AttributeStateFacing(BlockStateProperties.FACING, FacePlacementType.SELECTED_FACE), Attributes.SECURITY)
//          .withCustomShape(BlockShapes.LASER)
//          .withComputerSupport("laser")
//          .build();
//    // Laser Amplifier
//    public static final BlockTypeTile<TileEntityLaserAmplifier> LASER_AMPLIFIER = BlockTileBuilder.createBlock(() -> MekanismTileEntityTypes.LASER_AMPLIFIER, MekanismLang.DESCRIPTION_LASER_AMPLIFIER)
//          .withGui(() -> MekanismContainerTypes.LASER_AMPLIFIER)
//          .withEnergyConfig(MekanismConfig.storage.laserAmplifier)
//          .with(new AttributeStateFacing(BlockStateProperties.FACING, FacePlacementType.SELECTED_FACE),
//                new AttributeRedstoneEmitter<>(TileEntityMekanism::getRedstoneLevel), Attributes.REDSTONE, Attributes.COMPARATOR, Attributes.SECURITY)
//          .withCustomShape(BlockShapes.LASER_AMPLIFIER)
//          .withComputerSupport("laserAmplifier")
//          .build();
//    // Laser Tractor Beam
//    public static final BlockTypeTile<TileEntityLaserTractorBeam> LASER_TRACTOR_BEAM = BlockTileBuilder
//          .createBlock(() -> MekanismTileEntityTypes.LASER_TRACTOR_BEAM, MekanismLang.DESCRIPTION_LASER_TRACTOR_BEAM)
//          .withGui(() -> MekanismContainerTypes.LASER_TRACTOR_BEAM)
//          .withEnergyConfig(MekanismConfig.storage.laserTractorBeam)
//          .with(new AttributeStateFacing(BlockStateProperties.FACING, FacePlacementType.SELECTED_FACE), Attributes.COMPARATOR, Attributes.SECURITY, Attributes.INVENTORY)
//          .withCustomShape(BlockShapes.LASER_AMPLIFIER)
//          .withComputerSupport("laserTractorBeam")
//          .build();
//    // Resistive Heater
//    public static final Machine<TileEntityResistiveHeater> RESISTIVE_HEATER = MachineBuilder
//          .createMachine(() -> MekanismTileEntityTypes.RESISTIVE_HEATER, MekanismLang.DESCRIPTION_RESISTIVE_HEATER)
//          .withGui(() -> MekanismContainerTypes.RESISTIVE_HEATER)
//          .withEnergyConfig(() -> RESISTIVE_HEATER_BASE_USAGE, null)
//          .without(AttributeComparator.class, AttributeUpgradeSupport.class)
//          .withCustomShape(BlockShapes.RESISTIVE_HEATER)
//          .withSound(MekanismSounds.RESISTIVE_HEATER)
//          .withComputerSupport("resistiveHeater")
//          .build();
//    // Seismic Vibrator
//    public static final Machine<TileEntitySeismicVibrator> SEISMIC_VIBRATOR = MachineBuilder
//          .createMachine(() -> MekanismTileEntityTypes.SEISMIC_VIBRATOR, MekanismLang.DESCRIPTION_SEISMIC_VIBRATOR)
//          .withGui(() -> MekanismContainerTypes.SEISMIC_VIBRATOR)
//          .withEnergyConfig(MekanismConfig.usage.seismicVibrator, MekanismConfig.storage.seismicVibrator)
//          .without(AttributeComparator.class, AttributeParticleFX.class, AttributeUpgradeSupport.class)
//          .withCustomShape(BlockShapes.SEISMIC_VIBRATOR)
//          .with(AttributeCustomSelectionBox.JAVA)
//          .withBounding((pos, state, builder) -> builder.add(pos.above()))
//          .withComputerSupport("seismicVibrator")
//          .build();
//    // Personal Barrel
//    public static final BlockTypeTile<TileEntityPersonalBarrel> PERSONAL_BARREL = BlockTileBuilder
//          .createBlock(() -> MekanismTileEntityTypes.PERSONAL_BARREL, MekanismLang.DESCRIPTION_PERSONAL_BARREL)
//          .withGui(() -> MekanismContainerTypes.PERSONAL_STORAGE_BLOCK)
//          .with(Attributes.SECURITY, Attributes.INVENTORY, AttributeStateOpen.INSTANCE, new AttributeStateFacing(BlockStateProperties.FACING), new AttributeCustomResistance(-1))
//          .build();
//    // Personal Chest
//    public static final BlockTypeTile<TileEntityPersonalChest> PERSONAL_CHEST = BlockTileBuilder
//          .createBlock(() -> MekanismTileEntityTypes.PERSONAL_CHEST, MekanismLang.DESCRIPTION_PERSONAL_CHEST)
//          .withGui(() -> MekanismContainerTypes.PERSONAL_STORAGE_BLOCK)
//          .with(Attributes.SECURITY, Attributes.INVENTORY, new AttributeStateFacing(), new AttributeCustomResistance(-1))
//          .withCustomShape(BlockShapes.PERSONAL_CHEST)
//          .build();
//    // Fuelwood Heater
//    public static final BlockTypeTile<TileEntityFuelwoodHeater> FUELWOOD_HEATER = BlockTileBuilder
//          .createBlock(() -> MekanismTileEntityTypes.FUELWOOD_HEATER, MekanismLang.DESCRIPTION_FUELWOOD_HEATER)
//          .withGui(() -> MekanismContainerTypes.FUELWOOD_HEATER)
//          .with(Attributes.SECURITY, Attributes.INVENTORY, Attributes.ACTIVE_LIGHT, new AttributeStateFacing(), new AttributeParticleFX()
//                .add(ParticleTypes.SMOKE, rand -> new Pos3D(rand.nextFloat() * 0.6F - 0.3F, rand.nextFloat() * 6.0F / 16.0F, -0.52))
//                .add(DustParticleOptions.REDSTONE, rand -> new Pos3D(rand.nextFloat() * 0.6F - 0.3F, rand.nextFloat() * 6.0F / 16.0F, -0.52)))
//          .withComputerSupport("fuelwoodHeater")
//          .build();
//    // Oredictionificator
//    public static final BlockTypeTile<TileEntityOredictionificator> OREDICTIONIFICATOR = BlockTileBuilder
//          .createBlock(() -> MekanismTileEntityTypes.OREDICTIONIFICATOR, MekanismLang.DESCRIPTION_OREDICTIONIFICATOR)
//          .withGui(() -> MekanismContainerTypes.OREDICTIONIFICATOR)
//          .with(Attributes.SECURITY, Attributes.INVENTORY, Attributes.ACTIVE, new AttributeStateFacing(), Attributes.REDSTONE)
//          .withComputerSupport("oredictionificator")
//          .build();
//    // Quantum Entangloporter
//    public static final Machine<TileEntityQuantumEntangloporter> QUANTUM_ENTANGLOPORTER = MachineBuilder
//          .createMachine(() -> MekanismTileEntityTypes.QUANTUM_ENTANGLOPORTER, MekanismLang.DESCRIPTION_QUANTUM_ENTANGLOPORTER)
//          .withGui(() -> MekanismContainerTypes.QUANTUM_ENTANGLOPORTER)
//          .withSupportedUpgrades(EnumSet.of(Upgrade.ANCHOR))
//          .with(new AttributeStateFacing(BlockStateProperties.FACING))
//          .without(AttributeStateActive.class, AttributeParticleFX.class, AttributeRedstone.class, AttributeComparator.class)
//          .withCustomShape(BlockShapes.QUANTUM_ENTANGLOPORTER)
//          .withComputerSupport("quantumEntangloporter")
//          .build();
//    // Logistical Sorter
//    public static final Machine<TileEntityLogisticalSorter> LOGISTICAL_SORTER = MachineBuilder
//          .createMachine(() -> MekanismTileEntityTypes.LOGISTICAL_SORTER, MekanismLang.DESCRIPTION_LOGISTICAL_SORTER)
//          .withGui(() -> MekanismContainerTypes.LOGISTICAL_SORTER)
//          .withSupportedUpgrades(EnumSet.of(Upgrade.MUFFLING))
//          .with(new AttributeStateFacing(BlockStateProperties.FACING, FacePlacementType.SELECTED_FACE))
//          .withCustomShape(BlockShapes.LOGISTICAL_SORTER)
//          .withSound(MekanismSounds.LOGISTICAL_SORTER)
//          .withComputerSupport("logisticalSorter")
//          .replace(Attributes.ACTIVE)
//          .build();
//    // Security Desk
//    public static final BlockTypeTile<TileEntitySecurityDesk> SECURITY_DESK = BlockTileBuilder
//          .createBlock(() -> MekanismTileEntityTypes.SECURITY_DESK, MekanismLang.DESCRIPTION_SECURITY_DESK)
//          .withGui(() -> MekanismContainerTypes.SECURITY_DESK)
//          .with(Attributes.INVENTORY, new AttributeStateFacing(), new AttributeCustomResistance(-1), Attributes.SECURITY)
//          .withCustomShape(BlockShapes.SECURITY_DESK)
//          .with(AttributeCustomSelectionBox.JSON)
//          .withBounding((pos, state, builder) -> builder.add(pos.above()))
//          .build();
//    // Modification Station
//    public static final BlockTypeTile<TileEntityModificationStation> MODIFICATION_STATION = BlockTileBuilder
//          .createBlock(() -> MekanismTileEntityTypes.MODIFICATION_STATION, MekanismLang.DESCRIPTION_MODIFICATION_STATION)
//          .withGui(() -> MekanismContainerTypes.MODIFICATION_STATION)
//          .withEnergyConfig(MekanismConfig.usage.modificationStation, MekanismConfig.storage.modificationStation)
//          .with(Attributes.INVENTORY, new AttributeStateFacing(false), Attributes.REDSTONE, Attributes.SECURITY)
//          .withCustomShape(BlockShapes.MODIFICATION_STATION)
//          .with(AttributeCustomSelectionBox.JSON)
//          .withBounding((pos, state, builder) -> {
//              builder.add(pos.above());
//              BlockPos rightPos = pos.relative(MekanismUtils.getRight(Attribute.getFacing(state)));
//              builder.add(rightPos);
//              builder.add(rightPos.above());
//          })
//          .withComputerSupport("modificationStation")
//          .build();
//    // Isotopic Centrifuge
//    public static final Machine<TileEntityIsotopicCentrifuge> ISOTOPIC_CENTRIFUGE = MachineBuilder
//          .createMachine(() -> MekanismTileEntityTypes.ISOTOPIC_CENTRIFUGE, MekanismLang.DESCRIPTION_ISOTOPIC_CENTRIFUGE)
//          .withGui(() -> MekanismContainerTypes.ISOTOPIC_CENTRIFUGE)
//          .withEnergyConfig(MekanismConfig.usage.isotopicCentrifuge, MekanismConfig.storage.isotopicCentrifuge)
//          .withSound(MekanismSounds.ISOTOPIC_CENTRIFUGE)
//          .withCustomShape(BlockShapes.ISOTOPIC_CENTRIFUGE)
//          .withBounding((pos, state, builder) -> builder.add(pos.above()))
//          .withComputerSupport("isotopicCentrifuge")
//          .build();
//    // Nutritional Liquifier
//    public static final Machine<TileEntityNutritionalLiquifier> NUTRITIONAL_LIQUIFIER = MachineBuilder
//          .createMachine(() -> MekanismTileEntityTypes.NUTRITIONAL_LIQUIFIER, MekanismLang.DESCRIPTION_NUTRITIONAL_LIQUIFIER)
//          .withGui(() -> MekanismContainerTypes.NUTRITIONAL_LIQUIFIER)
//          .withEnergyConfig(MekanismConfig.usage.nutritionalLiquifier, MekanismConfig.storage.nutritionalLiquifier)
//          .withSound(MekanismSounds.NUTRITIONAL_LIQUIFIER)
//          .withComputerSupport("nutritionalLiquifier")
//          .build();
//    // Antiprotonic Nucleosynthesizer
//    public static final Machine<TileEntityAntiprotonicNucleosynthesizer> ANTIPROTONIC_NUCLEOSYNTHESIZER = MachineBuilder
//          .createMachine(() -> MekanismTileEntityTypes.ANTIPROTONIC_NUCLEOSYNTHESIZER, MekanismLang.DESCRIPTION_ANTIPROTONIC_NUCLEOSYNTHESIZER)
//          .withGui(() -> MekanismContainerTypes.ANTIPROTONIC_NUCLEOSYNTHESIZER)
//          .withEnergyConfig(MekanismConfig.usage.antiprotonicNucleosynthesizer, MekanismConfig.storage.antiprotonicNucleosynthesizer)
//          .withSound(MekanismSounds.ANTIPROTONIC_NUCLEOSYNTHESIZER)
//          .withSupportedUpgrades(EnumSet.of(Upgrade.MUFFLING))
//          .withCustomShape(BlockShapes.ANTIPROTONIC_NUCLEOSYNTHESIZER)
//          .withComputerSupport("antiprotonicNucleosynthesizer")
//          .build();
//    // Pigment Extractor
//    public static final Machine<TileEntityPigmentExtractor> PIGMENT_EXTRACTOR = MachineBuilder
//          .createMachine(() -> MekanismTileEntityTypes.PIGMENT_EXTRACTOR, MekanismLang.DESCRIPTION_PIGMENT_EXTRACTOR)
//          .withGui(() -> MekanismContainerTypes.PIGMENT_EXTRACTOR)
//          .withSound(MekanismSounds.PIGMENT_EXTRACTOR)
//          .withEnergyConfig(MekanismConfig.usage.pigmentExtractor, MekanismConfig.storage.pigmentExtractor)
//          .withSupportedUpgrades(EnumSet.of(Upgrade.SPEED, Upgrade.ENERGY, Upgrade.MUFFLING))
//          .withComputerSupport("pigmentExtractor")
//          .build();
//    // Pigment Mixer
//    public static final Machine<TileEntityPigmentMixer> PIGMENT_MIXER = MachineBuilder
//          .createMachine(() -> MekanismTileEntityTypes.PIGMENT_MIXER, MekanismLang.DESCRIPTION_PIGMENT_MIXER)
//          .withGui(() -> MekanismContainerTypes.PIGMENT_MIXER)
//          .withSound(MekanismSounds.PIGMENT_MIXER)
//          .withEnergyConfig(MekanismConfig.usage.pigmentMixer, MekanismConfig.storage.pigmentMixer)
//          .withSupportedUpgrades(EnumSet.of(Upgrade.SPEED, Upgrade.ENERGY, Upgrade.MUFFLING))
//          .withCustomShape(BlockShapes.PIGMENT_MIXER)
//          .with(AttributeCustomSelectionBox.JAVA)
//          .withBounding((pos, state, builder) -> builder.add(pos.above()))
//          .withComputerSupport("pigmentMixer")
//          .build();
//    // Painting Machine
//    public static final Machine<TileEntityPaintingMachine> PAINTING_MACHINE = MachineBuilder
//          .createMachine(() -> MekanismTileEntityTypes.PAINTING_MACHINE, MekanismLang.DESCRIPTION_PAINTING_MACHINE)
//          .withGui(() -> MekanismContainerTypes.PAINTING_MACHINE)
//          .withSound(MekanismSounds.PAINTING_MACHINE)
//          .withEnergyConfig(MekanismConfig.usage.paintingMachine, MekanismConfig.storage.paintingMachine)
//          .withSupportedUpgrades(EnumSet.of(Upgrade.SPEED, Upgrade.ENERGY, Upgrade.MUFFLING))
//          .withComputerSupport("paintingMachine")
//          .build();
//
//    // QIO Drive Array
//    public static final BlockTypeTile<TileEntityQIODriveArray> QIO_DRIVE_ARRAY = BlockTileBuilder
//          .createBlock(() -> MekanismTileEntityTypes.QIO_DRIVE_ARRAY, MekanismLang.DESCRIPTION_QIO_DRIVE_ARRAY)
//          .withGui(() -> MekanismContainerTypes.QIO_DRIVE_ARRAY)
//          .withCustomShape(BlockShapes.QIO_DRIVE_ARRAY)
//          .with(new AttributeStateFacing(), Attributes.SECURITY, Attributes.INVENTORY, Attributes.ACTIVE)
//          .withComputerSupport("qioDriveArray")
//          .build();
//    // QIO Dashboard
//    public static final BlockTypeTile<TileEntityQIODashboard> QIO_DASHBOARD = BlockTileBuilder
//          .createBlock(() -> MekanismTileEntityTypes.QIO_DASHBOARD, MekanismLang.DESCRIPTION_QIO_DASHBOARD)
//          .withGui(() -> MekanismContainerTypes.QIO_DASHBOARD)
//          .withCustomShape(BlockShapes.QIO_DASHBOARD)
//          .with(new AttributeStateFacing(BlockStateProperties.FACING, FacePlacementType.SELECTED_FACE), Attributes.SECURITY, Attributes.ACTIVE, Attributes.INVENTORY)
//          .withComputerSupport("qioDashboard")
//          .build();
//    // QIO Importer
//    public static final BlockTypeTile<TileEntityQIOImporter> QIO_IMPORTER = BlockTileBuilder
//          .createBlock(() -> MekanismTileEntityTypes.QIO_IMPORTER, MekanismLang.DESCRIPTION_QIO_IMPORTER)
//          .withGui(() -> MekanismContainerTypes.QIO_IMPORTER)
//          .withCustomShape(BlockShapes.QIO_IMPORTER)
//          .with(new AttributeStateFacing(BlockStateProperties.FACING, FacePlacementType.SELECTED_FACE), Attributes.SECURITY, Attributes.REDSTONE, Attributes.ACTIVE)
//          .withSupportedUpgrades(EnumSet.of(Upgrade.SPEED))
//          .withComputerSupport("qioImporter")
//          .build();
//    // QIO Exporter
//    public static final BlockTypeTile<TileEntityQIOExporter> QIO_EXPORTER = BlockTileBuilder
//          .createBlock(() -> MekanismTileEntityTypes.QIO_EXPORTER, MekanismLang.DESCRIPTION_QIO_EXPORTER)
//          .withGui(() -> MekanismContainerTypes.QIO_EXPORTER)
//          .withCustomShape(BlockShapes.QIO_EXPORTER)
//          .with(new AttributeStateFacing(BlockStateProperties.FACING, FacePlacementType.SELECTED_FACE), Attributes.SECURITY, Attributes.REDSTONE, Attributes.ACTIVE)
//          .withSupportedUpgrades(EnumSet.of(Upgrade.SPEED))
//          .withComputerSupport("qioExporter")
//          .build();
//    // QIO Redstone Adapter
//    public static final BlockTypeTile<TileEntityQIORedstoneAdapter> QIO_REDSTONE_ADAPTER = BlockTileBuilder
//          .createBlock(() -> MekanismTileEntityTypes.QIO_REDSTONE_ADAPTER, MekanismLang.DESCRIPTION_QIO_REDSTONE_ADAPTER)
//          .withGui(() -> MekanismContainerTypes.QIO_REDSTONE_ADAPTER)
//          .withCustomShape(BlockShapes.QIO_REDSTONE_ADAPTER)
//          .with(new AttributeStateFacing(BlockStateProperties.FACING, FacePlacementType.SELECTED_FACE), Attributes.SECURITY, Attributes.ACTIVE)
//          .with(new AttributeRedstoneEmitter<>(tile -> tile.isPowering() ? 15 : 0))
//          .withComputerSupport("qioRedstoneAdapter")
//          .build();
//
//    // Dynamic Tank
//    public static final BlockTypeTile<TileEntityDynamicTank> DYNAMIC_TANK = BlockTileBuilder
//          .createBlock(() -> MekanismTileEntityTypes.DYNAMIC_TANK, MekanismLang.DESCRIPTION_DYNAMIC_TANK)
//          .withGui(() -> MekanismContainerTypes.DYNAMIC_TANK, MekanismLang.DYNAMIC_TANK)
//          .with(Attributes.INVENTORY)
//          .externalMultiblock()
//          .build();
//    // Dynamic Valve
//    public static final BlockTypeTile<TileEntityDynamicValve> DYNAMIC_VALVE = BlockTileBuilder
//          .createBlock(() -> MekanismTileEntityTypes.DYNAMIC_VALVE, MekanismLang.DESCRIPTION_DYNAMIC_VALVE)
//          .withGui(() -> MekanismContainerTypes.DYNAMIC_TANK, MekanismLang.DYNAMIC_TANK)
//          .with(Attributes.INVENTORY, Attributes.COMPARATOR)
//          .externalMultiblock()
//          .withComputerSupport("dynamicValve")
//          .build();
//    // Boiler Casing
//    public static final BlockTypeTile<TileEntityBoilerCasing> BOILER_CASING = BlockTileBuilder
//          .createBlock(() -> MekanismTileEntityTypes.BOILER_CASING, MekanismLang.DESCRIPTION_BOILER_CASING)
//          .withGui(() -> MekanismContainerTypes.THERMOELECTRIC_BOILER, MekanismLang.BOILER)
//          .externalMultiblock()
//          .build();
//    // Boiler Valve
//    public static final BlockTypeTile<TileEntityBoilerValve> BOILER_VALVE = BlockTileBuilder
//          .createBlock(() -> MekanismTileEntityTypes.BOILER_VALVE, MekanismLang.DESCRIPTION_BOILER_VALVE)
//          .withGui(() -> MekanismContainerTypes.THERMOELECTRIC_BOILER, MekanismLang.BOILER)
//          .with(Attributes.INVENTORY, Attributes.COMPARATOR, new AttributeStateBoilerValveMode())
//          .externalMultiblock()
//          .withComputerSupport("boilerValve")
//          .build();
//    // Pressure Disperser
//    public static final BlockTypeTile<TileEntityPressureDisperser> PRESSURE_DISPERSER = BlockTileBuilder
//          .createBlock(() -> MekanismTileEntityTypes.PRESSURE_DISPERSER, MekanismLang.DESCRIPTION_PRESSURE_DISPERSER)
//          .internalMultiblock()
//          .build();
//    // Superheating Element
//    public static final BlockTypeTile<TileEntitySuperheatingElement> SUPERHEATING_ELEMENT = BlockTileBuilder
//          .createBlock(() -> MekanismTileEntityTypes.SUPERHEATING_ELEMENT, MekanismLang.DESCRIPTION_SUPERHEATING_ELEMENT)
//          .with(Attributes.ACTIVE_LIGHT)
//          .internalMultiblock()
//          .build();
//    // Induction Casing
//    public static final BlockTypeTile<TileEntityInductionCasing> INDUCTION_CASING = BlockTileBuilder
//          .createBlock(() -> MekanismTileEntityTypes.INDUCTION_CASING, MekanismLang.DESCRIPTION_INDUCTION_CASING)
//          .withGui(() -> MekanismContainerTypes.INDUCTION_MATRIX, MekanismLang.MATRIX)
//          .with(Attributes.INVENTORY, Attributes.COMPARATOR)
//          .externalMultiblock()
//          .build();
//    // Induction Port
//    public static final BlockTypeTile<TileEntityInductionPort> INDUCTION_PORT = BlockTileBuilder
//          .createBlock(() -> MekanismTileEntityTypes.INDUCTION_PORT, MekanismLang.DESCRIPTION_INDUCTION_PORT)
//          .withGui(() -> MekanismContainerTypes.INDUCTION_MATRIX, MekanismLang.MATRIX)
//          .with(Attributes.INVENTORY, Attributes.COMPARATOR, Attributes.ACTIVE)
//          .externalMultiblock()
//          .withComputerSupport("inductionPort")
//          .build();
//    // Thermal Evaporation Controller
//    public static final BlockTypeTile<TileEntityThermalEvaporationController> THERMAL_EVAPORATION_CONTROLLER = BlockTileBuilder
//          .createBlock(() -> MekanismTileEntityTypes.THERMAL_EVAPORATION_CONTROLLER, MekanismLang.DESCRIPTION_THERMAL_EVAPORATION_CONTROLLER)
//          .withGui(() -> MekanismContainerTypes.THERMAL_EVAPORATION_CONTROLLER, MekanismLang.EVAPORATION_PLANT)
//          .with(Attributes.INVENTORY, Attributes.ACTIVE, new AttributeStateFacing(), new AttributeCustomResistance(9))
//          .externalMultiblock()
//          .withComputerSupport("thermalEvaporationController")
//          .build();
//    // Thermal Evaporation Valve
//    public static final BlockTypeTile<TileEntityThermalEvaporationValve> THERMAL_EVAPORATION_VALVE = BlockTileBuilder
//          .createBlock(() -> MekanismTileEntityTypes.THERMAL_EVAPORATION_VALVE, MekanismLang.DESCRIPTION_THERMAL_EVAPORATION_VALVE)
//          .with(Attributes.COMPARATOR, new AttributeCustomResistance(9))
//          .externalMultiblock()
//          .withComputerSupport("thermalEvaporationValve")
//          .build();
//    // Thermal Evaporation Block
//    public static final BlockTypeTile<TileEntityThermalEvaporationBlock> THERMAL_EVAPORATION_BLOCK = BlockTileBuilder
//          .createBlock(() -> MekanismTileEntityTypes.THERMAL_EVAPORATION_BLOCK, MekanismLang.DESCRIPTION_THERMAL_EVAPORATION_BLOCK)
//          .with(new AttributeCustomResistance(9))
//          .externalMultiblock()
//          .build();
//    // Teleporter Frame
//    public static final BlockType TELEPORTER_FRAME = BlockTypeBuilder
//          .createBlock(MekanismLang.DESCRIPTION_TELEPORTER_FRAME)
//          .withLight(10)
//          .build();
//    // Steel Casing
//    public static final BlockType STEEL_CASING = BlockTypeBuilder
//          .createBlock(MekanismLang.DESCRIPTION_STEEL_CASING)
//          .build();
//    // Radioactive Waste Barrel
//    public static final BlockTypeTile<TileEntityRadioactiveWasteBarrel> RADIOACTIVE_WASTE_BARREL = BlockTileBuilder
//          .createBlock(() -> MekanismTileEntityTypes.RADIOACTIVE_WASTE_BARREL, MekanismLang.DESCRIPTION_RADIOACTIVE_WASTE_BARREL)
//          .with(Attributes.ACTIVE_LIGHT, new AttributeStateFacing(), Attributes.COMPARATOR)
//          .withCustomShape(BlockShapes.RADIOACTIVE_WASTE_BARREL)
//          .build();
//    // Industrial Alarm
//    public static final BlockTypeTile<TileEntityIndustrialAlarm> INDUSTRIAL_ALARM = BlockTileBuilder
//          .createBlock(() -> MekanismTileEntityTypes.INDUSTRIAL_ALARM, MekanismLang.DESCRIPTION_INDUSTRIAL_ALARM)
//          .withSound(MekanismSounds.INDUSTRIAL_ALARM)
//          .withCustomShape(BlockShapes.INDUSTRIAL_ALARM)
//          .with(Attributes.ACTIVE_FULL_LIGHT, new AttributeStateFacing(BlockStateProperties.FACING, FacePlacementType.SELECTED_FACE), Attributes.REDSTONE)
//          .build();
//    // Structural Glass
//    public static final BlockTypeTile<TileEntityStructuralGlass> STRUCTURAL_GLASS = BlockTileBuilder
//          .createBlock(() -> MekanismTileEntityTypes.STRUCTURAL_GLASS, MekanismLang.DESCRIPTION_STRUCTURAL_GLASS)
//          .with(AttributeMultiblock.STRUCTURAL, AttributeMobSpawn.NEVER)
//          .build();
//    // SPS Casing
//    public static final BlockTypeTile<TileEntitySPSCasing> SPS_CASING = BlockTileBuilder
//          .createBlock(() -> MekanismTileEntityTypes.SPS_CASING, MekanismLang.DESCRIPTION_SPS_CASING)
//          .withGui(() -> MekanismContainerTypes.SPS, MekanismLang.SPS)
//          .withSound(MekanismSounds.SPS)
//          .externalMultiblock()
//          .build();
//    // SPS Port
//    public static final BlockTypeTile<TileEntitySPSPort> SPS_PORT = BlockTileBuilder
//          .createBlock(() -> MekanismTileEntityTypes.SPS_PORT, MekanismLang.DESCRIPTION_SPS_PORT)
//          .withGui(() -> MekanismContainerTypes.SPS, MekanismLang.SPS)
//          .withSound(MekanismSounds.SPS)
//          .withEnergyConfig(MekanismConfig.storage.spsPort)
//          .with(Attributes.ACTIVE)
//          .externalMultiblock()
//          .withComputerSupport("spsPort")
//          .build();
//    // Supercharged Coil
//    public static final BlockTypeTile<TileEntitySuperchargedCoil> SUPERCHARGED_COIL = BlockTileBuilder
//          .createBlock(() -> MekanismTileEntityTypes.SUPERCHARGED_COIL, MekanismLang.DESCRIPTION_SUPERCHARGED_COIL)
//          .with(new AttributeStateFacing(BlockStateProperties.FACING, FacePlacementType.SELECTED_FACE))
//          .withCustomShape(BlockShapes.SUPERCHARGED_COIL)
//          .internalMultiblock()
//          .build();
//
//    // Induction Cells
//    public static final BlockTypeTile<TileEntityInductionCell> BASIC_INDUCTION_CELL = createInductionCell(InductionCellTier.BASIC, () -> MekanismTileEntityTypes.BASIC_INDUCTION_CELL);
//    public static final BlockTypeTile<TileEntityInductionCell> ADVANCED_INDUCTION_CELL = createInductionCell(InductionCellTier.ADVANCED, () -> MekanismTileEntityTypes.ADVANCED_INDUCTION_CELL);
//    public static final BlockTypeTile<TileEntityInductionCell> ELITE_INDUCTION_CELL = createInductionCell(InductionCellTier.ELITE, () -> MekanismTileEntityTypes.ELITE_INDUCTION_CELL);
//    public static final BlockTypeTile<TileEntityInductionCell> ULTIMATE_INDUCTION_CELL = createInductionCell(InductionCellTier.ULTIMATE, () -> MekanismTileEntityTypes.ULTIMATE_INDUCTION_CELL);
//
//    // Induction Provider
//    public static final BlockTypeTile<TileEntityInductionProvider> BASIC_INDUCTION_PROVIDER = createInductionProvider(InductionProviderTier.BASIC, () -> MekanismTileEntityTypes.BASIC_INDUCTION_PROVIDER);
//    public static final BlockTypeTile<TileEntityInductionProvider> ADVANCED_INDUCTION_PROVIDER = createInductionProvider(InductionProviderTier.ADVANCED, () -> MekanismTileEntityTypes.ADVANCED_INDUCTION_PROVIDER);
//    public static final BlockTypeTile<TileEntityInductionProvider> ELITE_INDUCTION_PROVIDER = createInductionProvider(InductionProviderTier.ELITE, () -> MekanismTileEntityTypes.ELITE_INDUCTION_PROVIDER);
//    public static final BlockTypeTile<TileEntityInductionProvider> ULTIMATE_INDUCTION_PROVIDER = createInductionProvider(InductionProviderTier.ULTIMATE, () -> MekanismTileEntityTypes.ULTIMATE_INDUCTION_PROVIDER);

    // Bins
    public static final Machine<TileEntityBin> BASIC_BIN = createBin(BinTier.BASIC, () -> MekanismTileEntityTypes.BASIC_BIN, () -> MekanismBlocks.ADVANCED_BIN);
    public static final Machine<TileEntityBin> ADVANCED_BIN = createBin(BinTier.ADVANCED, () -> MekanismTileEntityTypes.ADVANCED_BIN, () -> MekanismBlocks.ELITE_BIN);
    public static final Machine<TileEntityBin> ELITE_BIN = createBin(BinTier.ELITE, () -> MekanismTileEntityTypes.ELITE_BIN, () -> MekanismBlocks.ULTIMATE_BIN);
    public static final Machine<TileEntityBin> ULTIMATE_BIN = createBin(BinTier.ULTIMATE, () -> MekanismTileEntityTypes.ULTIMATE_BIN, null);
    public static final Machine<TileEntityBin> CREATIVE_BIN = createBin(BinTier.CREATIVE, () -> MekanismTileEntityTypes.CREATIVE_BIN, null);

    // Energy Cubes
//    public static final Machine<TileEntityEnergyCube> BASIC_ENERGY_CUBE = createEnergyCube(EnergyCubeTier.BASIC, () -> MekanismTileEntityTypes.BASIC_ENERGY_CUBE, () -> MekanismBlocks.ADVANCED_ENERGY_CUBE);
//    public static final Machine<TileEntityEnergyCube> ADVANCED_ENERGY_CUBE = createEnergyCube(EnergyCubeTier.ADVANCED, () -> MekanismTileEntityTypes.ADVANCED_ENERGY_CUBE, () -> MekanismBlocks.ELITE_ENERGY_CUBE);
//    public static final Machine<TileEntityEnergyCube> ELITE_ENERGY_CUBE = createEnergyCube(EnergyCubeTier.ELITE, () -> MekanismTileEntityTypes.ELITE_ENERGY_CUBE, () -> MekanismBlocks.ULTIMATE_ENERGY_CUBE);
//    public static final Machine<TileEntityEnergyCube> ULTIMATE_ENERGY_CUBE = createEnergyCube(EnergyCubeTier.ULTIMATE, () -> MekanismTileEntityTypes.ULTIMATE_ENERGY_CUBE, null);
//    public static final Machine<TileEntityEnergyCube> CREATIVE_ENERGY_CUBE = createEnergyCube(EnergyCubeTier.CREATIVE, () -> MekanismTileEntityTypes.CREATIVE_ENERGY_CUBE, null);
//
//    // Fluid Tanks
//    public static final Machine<TileEntityFluidTank> BASIC_FLUID_TANK = createFluidTank(FluidTankTier.BASIC, () -> MekanismTileEntityTypes.BASIC_FLUID_TANK, () -> MekanismBlocks.ADVANCED_FLUID_TANK);
//    public static final Machine<TileEntityFluidTank> ADVANCED_FLUID_TANK = createFluidTank(FluidTankTier.ADVANCED, () -> MekanismTileEntityTypes.ADVANCED_FLUID_TANK, () -> MekanismBlocks.ELITE_FLUID_TANK);
//    public static final Machine<TileEntityFluidTank> ELITE_FLUID_TANK = createFluidTank(FluidTankTier.ELITE, () -> MekanismTileEntityTypes.ELITE_FLUID_TANK, () -> MekanismBlocks.ULTIMATE_FLUID_TANK);
//    public static final Machine<TileEntityFluidTank> ULTIMATE_FLUID_TANK = createFluidTank(FluidTankTier.ULTIMATE, () -> MekanismTileEntityTypes.ULTIMATE_FLUID_TANK, null);
//    public static final Machine<TileEntityFluidTank> CREATIVE_FLUID_TANK = createFluidTank(FluidTankTier.CREATIVE, () -> MekanismTileEntityTypes.CREATIVE_FLUID_TANK, null);
//
//    // Chemical Tanks
//    public static final Machine<TileEntityChemicalTank> BASIC_CHEMICAL_TANK = createChemicalTank(ChemicalTankTier.BASIC, () -> MekanismTileEntityTypes.BASIC_CHEMICAL_TANK, () -> MekanismBlocks.ADVANCED_CHEMICAL_TANK);
//    public static final Machine<TileEntityChemicalTank> ADVANCED_CHEMICAL_TANK = createChemicalTank(ChemicalTankTier.ADVANCED, () -> MekanismTileEntityTypes.ADVANCED_CHEMICAL_TANK, () -> MekanismBlocks.ELITE_CHEMICAL_TANK);
//    public static final Machine<TileEntityChemicalTank> ELITE_CHEMICAL_TANK = createChemicalTank(ChemicalTankTier.ELITE, () -> MekanismTileEntityTypes.ELITE_CHEMICAL_TANK, () -> MekanismBlocks.ULTIMATE_CHEMICAL_TANK);
//    public static final Machine<TileEntityChemicalTank> ULTIMATE_CHEMICAL_TANK = createChemicalTank(ChemicalTankTier.ULTIMATE, () -> MekanismTileEntityTypes.ULTIMATE_CHEMICAL_TANK, null);
//    public static final Machine<TileEntityChemicalTank> CREATIVE_CHEMICAL_TANK = createChemicalTank(ChemicalTankTier.CREATIVE, () -> MekanismTileEntityTypes.CREATIVE_CHEMICAL_TANK, null);
//
//    static {
//        for (FactoryTier tier : EnumUtils.FACTORY_TIERS) {
//            for (FactoryType type : EnumUtils.FACTORY_TYPES) {
//                FACTORIES.put(tier, type, FactoryBuilder.createFactory(() -> MekanismTileEntityTypes.getFactoryTile(tier, type), type, tier).build());
//            }
//        }
//    }
//
//    public static Factory<?> getFactory(FactoryTier tier, FactoryType type) {
//        return FACTORIES.get(tier, type);
//    }
//
//    private static <TILE extends TileEntityInductionCell> BlockTypeTile<TILE> createInductionCell(InductionCellTier tier, Supplier<TileEntityTypeRegistryObject<TILE>> tile) {
//        return BlockTileBuilder.createBlock(tile, MekanismLang.DESCRIPTION_INDUCTION_CELL)
//              .withEnergyConfig(tier::getMaxEnergy)
//              .with(new AttributeTier<>(tier))
//              .internalMultiblock()
//              .build();
//    }
//
//    private static <TILE extends TileEntityInductionProvider> BlockTypeTile<TILE> createInductionProvider(InductionProviderTier tier, Supplier<TileEntityTypeRegistryObject<TILE>> tile) {
//        return BlockTileBuilder.createBlock(tile, MekanismLang.DESCRIPTION_INDUCTION_PROVIDER)
//              .with(new AttributeTier<>(tier))
//              .internalMultiblock()
//              .build();
//    }

    private static <TILE extends TileEntityBin> Machine<TILE> createBin(BinTier tier, Supplier<TileEntityTypeRegistryObject<TILE>> tile, Supplier<BlockRegistryObject<?, ?>> upgradeBlock) {
        return MachineBuilder.createMachine(tile, MekanismLang.DESCRIPTION_BIN)
              .with(new AttributeTier<>(tier), new AttributeUpgradeable(upgradeBlock))
              .without(AttributeParticleFX.class, AttributeSecurity.class, AttributeUpgradeSupport.class, AttributeRedstone.class)
              .withComputerSupport(tier, "Bin")
              .build();
    }

//    private static <TILE extends TileEntityEnergyCube> Machine<TILE> createEnergyCube(EnergyCubeTier tier, Supplier<TileEntityTypeRegistryObject<TILE>> tile, Supplier<BlockRegistryObject<?, ?>> upgradeBlock) {
//        return MachineBuilder.createMachine(tile, MekanismLang.DESCRIPTION_ENERGY_CUBE)
//              .withGui(() -> MekanismContainerTypes.ENERGY_CUBE)
//              .withEnergyConfig(tier::getMaxEnergy)
//              .with(new AttributeTier<>(tier), new AttributeUpgradeable(upgradeBlock), new AttributeStateFacing(BlockStateProperties.FACING))
//              .without(AttributeParticleFX.class, AttributeStateActive.class, AttributeUpgradeSupport.class)
//              .withComputerSupport(tier, "EnergyCube")
//              .build();
//    }
//
//    private static <TILE extends TileEntityFluidTank> Machine<TILE> createFluidTank(FluidTankTier tier, Supplier<TileEntityTypeRegistryObject<TILE>> tile, Supplier<BlockRegistryObject<?, ?>> upgradeBlock) {
//        return MachineBuilder.createMachine(tile, MekanismLang.DESCRIPTION_FLUID_TANK)
//              .withGui(() -> MekanismContainerTypes.FLUID_TANK)
//              .withCustomShape(BlockShapes.FLUID_TANK)
//              .with(new AttributeTier<>(tier), new AttributeUpgradeable(upgradeBlock))
//              .without(AttributeParticleFX.class, AttributeStateFacing.class, AttributeRedstone.class, AttributeUpgradeSupport.class)
//              .withComputerSupport(tier, "FluidTank")
//              .build();
//    }
//
//    private static <TILE extends TileEntityChemicalTank> Machine<TILE> createChemicalTank(ChemicalTankTier tier, Supplier<TileEntityTypeRegistryObject<TILE>> tile, Supplier<BlockRegistryObject<?, ?>> upgradeBlock) {
//        return MachineBuilder.createMachine(tile, MekanismLang.DESCRIPTION_CHEMICAL_TANK)
//              .withGui(() -> MekanismContainerTypes.CHEMICAL_TANK)
//              .withCustomShape(BlockShapes.CHEMICAL_TANK)
//              .with(new AttributeTier<>(tier), new AttributeUpgradeable(upgradeBlock))
//              .without(AttributeParticleFX.class, AttributeStateActive.class, AttributeUpgradeSupport.class)
//              .withComputerSupport(tier, "ChemicalTank")
//              .build();
//    }
}
