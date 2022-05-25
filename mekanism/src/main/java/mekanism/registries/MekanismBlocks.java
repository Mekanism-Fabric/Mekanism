package mekanism.registries;

import mekanism.Mekanism;
import mekanism.api.tier.ITier;
import mekanism.block.BlockOre;
import mekanism.block.basic.BlockResource;
import mekanism.block.interfaces.IHasDescription;
import mekanism.item.block.ItemBlockResource;
import mekanism.item.block.ItemBlockTooltip;
import mekanism.registration.impl.BlockDeferredRegister;
import mekanism.registration.impl.BlockRegistryObject;
import mekanism.resource.BlockResourceInfo;
import mekanism.resource.IResource;
import mekanism.resource.PrimaryResource;
import mekanism.resource.ore.OreBlockType;
import mekanism.resource.ore.OreType;
import mekanism.util.EnumUtils;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MaterialColor;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class MekanismBlocks {

    private MekanismBlocks() {
    }

    public static final BlockDeferredRegister BLOCKS = new BlockDeferredRegister(Mekanism.MODID);

    public static final Map<IResource, BlockRegistryObject<?, ?>> PROCESSED_RESOURCE_BLOCKS = new LinkedHashMap<>();
    public static final Map<OreType, OreBlockType> ORES = new LinkedHashMap<>();

//    private static final Table<FactoryTier, FactoryType, BlockRegistryObject<BlockFactory<?>, ItemBlockFactory>> FACTORIES = HashBasedTable.create();

    static {
        // factories
//        for (FactoryTier tier : EnumUtils.FACTORY_TIERS) {
//            for (FactoryType type : EnumUtils.FACTORY_TYPES) {
//                FACTORIES.put(tier, type, registerFactory(MekanismBlockTypes.getFactory(tier, type)));
//            }
//        }
        // resource blocks
        for (PrimaryResource resource : EnumUtils.PRIMARY_RESOURCES) {
            if (resource.getResourceBlockInfo() != null) {
                PROCESSED_RESOURCE_BLOCKS.put(resource, registerResourceBlock(resource.getResourceBlockInfo()));
            }
            BlockResourceInfo rawResource = resource.getRawResourceBlockInfo();
            if (rawResource != null) {
                PROCESSED_RESOURCE_BLOCKS.put(rawResource, registerResourceBlock(rawResource));
            }
        }
        // ores
        for (OreType ore : EnumUtils.ORE_TYPES) {
            ORES.put(ore, registerOre(ore));
        }
    }

    public static final BlockRegistryObject<BlockResource, ItemBlockResource> BRONZE_BLOCK = registerResourceBlock(BlockResourceInfo.BRONZE);
    public static final BlockRegistryObject<BlockResource, ItemBlockResource> REFINED_OBSIDIAN_BLOCK = registerResourceBlock(BlockResourceInfo.REFINED_OBSIDIAN);
    public static final BlockRegistryObject<BlockResource, ItemBlockResource> CHARCOAL_BLOCK = registerResourceBlock(BlockResourceInfo.CHARCOAL);
    public static final BlockRegistryObject<BlockResource, ItemBlockResource> REFINED_GLOWSTONE_BLOCK = registerResourceBlock(BlockResourceInfo.REFINED_GLOWSTONE);
    public static final BlockRegistryObject<BlockResource, ItemBlockResource> STEEL_BLOCK = registerResourceBlock(BlockResourceInfo.STEEL);
    public static final BlockRegistryObject<BlockResource, ItemBlockResource> FLUORITE_BLOCK = registerResourceBlock(BlockResourceInfo.FLUORITE);

//    public static final BlockRegistryObject<BlockBin, ItemBlockBin> BASIC_BIN = registerBin(MekanismBlockTypes.BASIC_BIN);
//    public static final BlockRegistryObject<BlockBin, ItemBlockBin> ADVANCED_BIN = registerBin(MekanismBlockTypes.ADVANCED_BIN);
//    public static final BlockRegistryObject<BlockBin, ItemBlockBin> ELITE_BIN = registerBin(MekanismBlockTypes.ELITE_BIN);
//    public static final BlockRegistryObject<BlockBin, ItemBlockBin> ULTIMATE_BIN = registerBin(MekanismBlockTypes.ULTIMATE_BIN);
//    public static final BlockRegistryObject<BlockBin, ItemBlockBin> CREATIVE_BIN = registerBin(MekanismBlockTypes.CREATIVE_BIN);

//    public static final BlockRegistryObject<BlockBase<BlockType>, ItemBlockTooltip<BlockBase<BlockType>>> TELEPORTER_FRAME = registerBlock("teleporter_frame", () -> new BlockBase<>(MekanismBlockTypes.TELEPORTER_FRAME, properties -> properties.strength(5, 6)));
//    public static final BlockRegistryObject<BlockBase<BlockType>, ItemBlockTooltip<BlockBase<BlockType>>> STEEL_CASING = registerBlock("steel_casing", () -> new BlockBase<>(MekanismBlockTypes.STEEL_CASING, properties -> properties.strength(3.5F, 9)));
//    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityDynamicTank>, ItemBlockTooltip<BlockBasicMultiblock<TileEntityDynamicTank>>> DYNAMIC_TANK = registerBlock("dynamic_tank", () -> new BlockBasicMultiblock<>(MekanismBlockTypes.DYNAMIC_TANK));
//    public static final BlockRegistryObject<BlockStructuralGlass<TileEntityStructuralGlass>, ItemBlockTooltip<BlockStructuralGlass<TileEntityStructuralGlass>>> STRUCTURAL_GLASS = registerBlock("structural_glass", () -> new BlockStructuralGlass<>(MekanismBlockTypes.STRUCTURAL_GLASS));
//    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityDynamicValve>, ItemBlockTooltip<BlockBasicMultiblock<TileEntityDynamicValve>>> DYNAMIC_VALVE = registerBlock("dynamic_valve", () -> new BlockBasicMultiblock<>(MekanismBlockTypes.DYNAMIC_VALVE));
//    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityThermalEvaporationController>, ItemBlockTooltip<BlockBasicMultiblock<TileEntityThermalEvaporationController>>> THERMAL_EVAPORATION_CONTROLLER = registerBlock("thermal_evaporation_controller", () -> new BlockBasicMultiblock<>(MekanismBlockTypes.THERMAL_EVAPORATION_CONTROLLER));
//    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityThermalEvaporationValve>, ItemBlockTooltip<BlockBasicMultiblock<TileEntityThermalEvaporationValve>>> THERMAL_EVAPORATION_VALVE = registerBlock("thermal_evaporation_valve", () -> new BlockBasicMultiblock<>(MekanismBlockTypes.THERMAL_EVAPORATION_VALVE));
//    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityThermalEvaporationBlock>, ItemBlockTooltip<BlockBasicMultiblock<TileEntityThermalEvaporationBlock>>> THERMAL_EVAPORATION_BLOCK = registerBlock("thermal_evaporation_block", () -> new BlockBasicMultiblock<>(MekanismBlockTypes.THERMAL_EVAPORATION_BLOCK));
//    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityInductionCasing>, ItemBlockTooltip<BlockBasicMultiblock<TileEntityInductionCasing>>> INDUCTION_CASING = registerBlock("induction_casing", () -> new BlockBasicMultiblock<>(MekanismBlockTypes.INDUCTION_CASING));
//    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityInductionPort>, ItemBlockTooltip<BlockBasicMultiblock<TileEntityInductionPort>>> INDUCTION_PORT = registerBlock("induction_port", () -> new BlockBasicMultiblock<>(MekanismBlockTypes.INDUCTION_PORT));
//
//    public static final BlockRegistryObject<BlockTile<TileEntityInductionCell, BlockTypeTile<TileEntityInductionCell>>, ItemBlockInductionCell> BASIC_INDUCTION_CELL = registerInductionCell(MekanismBlockTypes.BASIC_INDUCTION_CELL);
//    public static final BlockRegistryObject<BlockTile<TileEntityInductionCell, BlockTypeTile<TileEntityInductionCell>>, ItemBlockInductionCell> ADVANCED_INDUCTION_CELL = registerInductionCell(MekanismBlockTypes.ADVANCED_INDUCTION_CELL);
//    public static final BlockRegistryObject<BlockTile<TileEntityInductionCell, BlockTypeTile<TileEntityInductionCell>>, ItemBlockInductionCell> ELITE_INDUCTION_CELL = registerInductionCell(MekanismBlockTypes.ELITE_INDUCTION_CELL);
//    public static final BlockRegistryObject<BlockTile<TileEntityInductionCell, BlockTypeTile<TileEntityInductionCell>>, ItemBlockInductionCell> ULTIMATE_INDUCTION_CELL = registerInductionCell(MekanismBlockTypes.ULTIMATE_INDUCTION_CELL);
//
//    public static final BlockRegistryObject<BlockTile<TileEntityInductionProvider, BlockTypeTile<TileEntityInductionProvider>>, ItemBlockInductionProvider> BASIC_INDUCTION_PROVIDER = registerInductionProvider(MekanismBlockTypes.BASIC_INDUCTION_PROVIDER);
//    public static final BlockRegistryObject<BlockTile<TileEntityInductionProvider, BlockTypeTile<TileEntityInductionProvider>>, ItemBlockInductionProvider> ADVANCED_INDUCTION_PROVIDER = registerInductionProvider(MekanismBlockTypes.ADVANCED_INDUCTION_PROVIDER);
//    public static final BlockRegistryObject<BlockTile<TileEntityInductionProvider, BlockTypeTile<TileEntityInductionProvider>>, ItemBlockInductionProvider> ELITE_INDUCTION_PROVIDER = registerInductionProvider(MekanismBlockTypes.ELITE_INDUCTION_PROVIDER);
//    public static final BlockRegistryObject<BlockTile<TileEntityInductionProvider, BlockTypeTile<TileEntityInductionProvider>>, ItemBlockInductionProvider> ULTIMATE_INDUCTION_PROVIDER = registerInductionProvider(MekanismBlockTypes.ULTIMATE_INDUCTION_PROVIDER);
//
//    public static final BlockRegistryObject<BlockTile<TileEntitySuperheatingElement, BlockTypeTile<TileEntitySuperheatingElement>>, ItemBlockTooltip<BlockTile<TileEntitySuperheatingElement, BlockTypeTile<TileEntitySuperheatingElement>>>> SUPERHEATING_ELEMENT = registerBlock("superheating_element", () -> new BlockTile<>(MekanismBlockTypes.SUPERHEATING_ELEMENT));
//    public static final BlockRegistryObject<BlockTile<TileEntityPressureDisperser, BlockTypeTile<TileEntityPressureDisperser>>, ItemBlockTooltip<BlockTile<TileEntityPressureDisperser, BlockTypeTile<TileEntityPressureDisperser>>>> PRESSURE_DISPERSER = registerBlock("pressure_disperser", () -> new BlockTile<>(MekanismBlockTypes.PRESSURE_DISPERSER));
//    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityBoilerCasing>, ItemBlockTooltip<BlockBasicMultiblock<TileEntityBoilerCasing>>> BOILER_CASING = registerBlock("boiler_casing", () -> new BlockBasicMultiblock<>(MekanismBlockTypes.BOILER_CASING));
//    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityBoilerValve>, ItemBlockTooltip<BlockBasicMultiblock<TileEntityBoilerValve>>> BOILER_VALVE = registerBlock("boiler_valve", () -> new BlockBasicMultiblock<>(MekanismBlockTypes.BOILER_VALVE));
//    public static final BlockRegistryObject<BlockTileModel<TileEntitySecurityDesk, BlockTypeTile<TileEntitySecurityDesk>>, ItemBlockSecurityDesk> SECURITY_DESK = BLOCKS.register("security_desk", () -> new BlockTileModel<>(MekanismBlockTypes.SECURITY_DESK), ItemBlockSecurityDesk::new);
//    public static final BlockRegistryObject<BlockRadioactiveWasteBarrel, ItemBlockRadioactiveWasteBarrel> RADIOACTIVE_WASTE_BARREL = BLOCKS.registerDefaultProperties("radioactive_waste_barrel", BlockRadioactiveWasteBarrel::new, ItemBlockRadioactiveWasteBarrel::new);
//    public static final BlockRegistryObject<BlockIndustrialAlarm, ItemBlockTooltip<BlockIndustrialAlarm>> INDUSTRIAL_ALARM = BLOCKS.register("industrial_alarm", BlockIndustrialAlarm::new, ItemBlockIndustrialAlarm::new);
//
//    public static final BlockRegistryObject<BlockFactoryMachine<TileEntityEnrichmentChamber, FactoryMachine<TileEntityEnrichmentChamber>>, ItemBlockMachine> ENRICHMENT_CHAMBER = BLOCKS.register("enrichment_chamber", () -> new BlockFactoryMachine<>(MekanismBlockTypes.ENRICHMENT_CHAMBER), ItemBlockMachine::new);
//    public static final BlockRegistryObject<BlockFactoryMachine<TileEntityOsmiumCompressor, FactoryMachine<TileEntityOsmiumCompressor>>, ItemBlockMachine> OSMIUM_COMPRESSOR = BLOCKS.register("osmium_compressor", () -> new BlockFactoryMachine<>(MekanismBlockTypes.OSMIUM_COMPRESSOR), ItemBlockMachine::new);
//    public static final BlockRegistryObject<BlockFactoryMachine<TileEntityCombiner, FactoryMachine<TileEntityCombiner>>, ItemBlockMachine> COMBINER = BLOCKS.register("combiner", () -> new BlockFactoryMachine<>(MekanismBlockTypes.COMBINER), ItemBlockMachine::new);
//    public static final BlockRegistryObject<BlockFactoryMachine<TileEntityCrusher, FactoryMachine<TileEntityCrusher>>, ItemBlockMachine> CRUSHER = BLOCKS.register("crusher", () -> new BlockFactoryMachine<>(MekanismBlockTypes.CRUSHER), ItemBlockMachine::new);
//    public static final BlockRegistryObject<BlockTileModel<TileEntityDigitalMiner, Machine<TileEntityDigitalMiner>>, ItemBlockMachine> DIGITAL_MINER = BLOCKS.register("digital_miner", () -> new BlockTileModel<>(MekanismBlockTypes.DIGITAL_MINER), ItemBlockMachine::new);
//
//    public static final BlockRegistryObject<BlockFactoryMachineModel<TileEntityMetallurgicInfuser>, ItemBlockMachine> METALLURGIC_INFUSER = BLOCKS.register("metallurgic_infuser", () -> new BlockFactoryMachineModel<>(MekanismBlockTypes.METALLURGIC_INFUSER), ItemBlockMachine::new);
//    public static final BlockRegistryObject<BlockFactoryMachine<TileEntityPurificationChamber, FactoryMachine<TileEntityPurificationChamber>>, ItemBlockMachine> PURIFICATION_CHAMBER = BLOCKS.register("purification_chamber", () -> new BlockFactoryMachine<>(MekanismBlockTypes.PURIFICATION_CHAMBER), ItemBlockMachine::new);
//    public static final BlockRegistryObject<BlockFactoryMachine<TileEntityEnergizedSmelter, FactoryMachine<TileEntityEnergizedSmelter>>, ItemBlockMachine> ENERGIZED_SMELTER = BLOCKS.register("energized_smelter", () -> new BlockFactoryMachine<>(MekanismBlockTypes.ENERGIZED_SMELTER), ItemBlockMachine::new);
//    public static final BlockRegistryObject<BlockTile<TileEntityTeleporter, Machine<TileEntityTeleporter>>, ItemBlockMachine> TELEPORTER = BLOCKS.register("teleporter", () -> new BlockTile<>(MekanismBlockTypes.TELEPORTER), ItemBlockTeleporter::new);
//    public static final BlockRegistryObject<BlockTileModel<TileEntityElectricPump, Machine<TileEntityElectricPump>>, ItemBlockMachine> ELECTRIC_PUMP = BLOCKS.register("electric_pump", () -> new BlockTileModel<>(MekanismBlockTypes.ELECTRIC_PUMP), ItemBlockMachine::new);
//    public static final BlockRegistryObject<BlockPersonalBarrel, ItemBlockPersonalStorage<BlockPersonalBarrel>> PERSONAL_BARREL = BLOCKS.register("personal_barrel", BlockPersonalBarrel::new, block -> new ItemBlockPersonalStorage<>(block, Stats.OPEN_BARREL));
//    public static final BlockRegistryObject<BlockPersonalChest, ItemBlockPersonalStorage<BlockPersonalChest>> PERSONAL_CHEST = BLOCKS.register("personal_chest", BlockPersonalChest::new, block -> new ItemBlockPersonalStorage<>(block, Stats.OPEN_CHEST));
//    public static final BlockRegistryObject<BlockTileModel<TileEntityChargepad, BlockTypeTile<TileEntityChargepad>>, ItemBlockTooltip<BlockTileModel<TileEntityChargepad, BlockTypeTile<TileEntityChargepad>>>> CHARGEPAD = BLOCKS.register("chargepad", () -> new BlockTileModel<>(MekanismBlockTypes.CHARGEPAD), ItemBlockTooltip::new);
//    public static final BlockRegistryObject<BlockLogisticalSorter, ItemBlockMachine> LOGISTICAL_SORTER = BLOCKS.register("logistical_sorter", BlockLogisticalSorter::new, ItemBlockMachine::new);
//    public static final BlockRegistryObject<BlockTileModel<TileEntityRotaryCondensentrator, Machine<TileEntityRotaryCondensentrator>>, ItemBlockMachine> ROTARY_CONDENSENTRATOR = BLOCKS.register("rotary_condensentrator", () -> new BlockTileModel<>(MekanismBlockTypes.ROTARY_CONDENSENTRATOR), ItemBlockMachine::new);
//    public static final BlockRegistryObject<BlockTileModel<TileEntityChemicalOxidizer, Machine<TileEntityChemicalOxidizer>>, ItemBlockMachine> CHEMICAL_OXIDIZER = BLOCKS.register("chemical_oxidizer", () -> new BlockTileModel<>(MekanismBlockTypes.CHEMICAL_OXIDIZER), ItemBlockMachine::new);
//    public static final BlockRegistryObject<BlockTileModel<TileEntityChemicalInfuser, Machine<TileEntityChemicalInfuser>>, ItemBlockMachine> CHEMICAL_INFUSER = BLOCKS.register("chemical_infuser", () -> new BlockTileModel<>(MekanismBlockTypes.CHEMICAL_INFUSER), ItemBlockMachine::new);
//    public static final BlockRegistryObject<BlockFactoryMachine<TileEntityChemicalInjectionChamber, FactoryMachine<TileEntityChemicalInjectionChamber>>, ItemBlockMachine> CHEMICAL_INJECTION_CHAMBER = BLOCKS.register("chemical_injection_chamber", () -> new BlockFactoryMachine<>(MekanismBlockTypes.CHEMICAL_INJECTION_CHAMBER), ItemBlockMachine::new);
//    public static final BlockRegistryObject<BlockTileModel<TileEntityElectrolyticSeparator, Machine<TileEntityElectrolyticSeparator>>, ItemBlockMachine> ELECTROLYTIC_SEPARATOR = BLOCKS.register("electrolytic_separator", () -> new BlockTileModel<>(MekanismBlockTypes.ELECTROLYTIC_SEPARATOR), ItemBlockMachine::new);
//    public static final BlockRegistryObject<BlockFactoryMachine<TileEntityPrecisionSawmill, FactoryMachine<TileEntityPrecisionSawmill>>, ItemBlockMachine> PRECISION_SAWMILL = BLOCKS.register("precision_sawmill", () -> new BlockFactoryMachine<>(MekanismBlockTypes.PRECISION_SAWMILL), ItemBlockMachine::new);
//    public static final BlockRegistryObject<BlockTileModel<TileEntityChemicalDissolutionChamber, Machine<TileEntityChemicalDissolutionChamber>>, ItemBlockMachine> CHEMICAL_DISSOLUTION_CHAMBER = BLOCKS.register("chemical_dissolution_chamber", () -> new BlockTileModel<>(MekanismBlockTypes.CHEMICAL_DISSOLUTION_CHAMBER), ItemBlockChemicalDissolutionChamber::new);
//    public static final BlockRegistryObject<BlockTileModel<TileEntityChemicalWasher, Machine<TileEntityChemicalWasher>>, ItemBlockMachine> CHEMICAL_WASHER = BLOCKS.register("chemical_washer", () -> new BlockTileModel<>(MekanismBlockTypes.CHEMICAL_WASHER), ItemBlockMachine::new);
//    public static final BlockRegistryObject<BlockTileModel<TileEntityChemicalCrystallizer, Machine<TileEntityChemicalCrystallizer>>, ItemBlockMachine> CHEMICAL_CRYSTALLIZER = BLOCKS.register("chemical_crystallizer", () -> new BlockTileModel<>(MekanismBlockTypes.CHEMICAL_CRYSTALLIZER), ItemBlockMachine::new);
//    public static final BlockRegistryObject<BlockTileModel<TileEntitySeismicVibrator, Machine<TileEntitySeismicVibrator>>, ItemBlockSeismicVibrator> SEISMIC_VIBRATOR = BLOCKS.register("seismic_vibrator", () -> new BlockTileModel<>(MekanismBlockTypes.SEISMIC_VIBRATOR), ItemBlockSeismicVibrator::new);
//    public static final BlockRegistryObject<BlockTileModel<TileEntityPressurizedReactionChamber, Machine<TileEntityPressurizedReactionChamber>>, ItemBlockMachine> PRESSURIZED_REACTION_CHAMBER = BLOCKS.register("pressurized_reaction_chamber", () -> new BlockTileModel<>(MekanismBlockTypes.PRESSURIZED_REACTION_CHAMBER), ItemBlockMachine::new);
//    public static final BlockRegistryObject<BlockTileModel<TileEntityIsotopicCentrifuge, Machine<TileEntityIsotopicCentrifuge>>, ItemBlockMachine> ISOTOPIC_CENTRIFUGE = BLOCKS.register("isotopic_centrifuge", () -> new BlockTileModel<>(MekanismBlockTypes.ISOTOPIC_CENTRIFUGE), ItemBlockMachine::new);
//    public static final BlockRegistryObject<BlockTile<TileEntityNutritionalLiquifier, Machine<TileEntityNutritionalLiquifier>>, ItemBlockMachine> NUTRITIONAL_LIQUIFIER = BLOCKS.register("nutritional_liquifier", () -> new BlockTile<>(MekanismBlockTypes.NUTRITIONAL_LIQUIFIER, Properties::noOcclusion), ItemBlockMachine::new);
//
//    public static final BlockRegistryObject<BlockFluidTank, ItemBlockFluidTank> BASIC_FLUID_TANK = registerFluidTank(MekanismBlockTypes.BASIC_FLUID_TANK);
//    public static final BlockRegistryObject<BlockFluidTank, ItemBlockFluidTank> ADVANCED_FLUID_TANK = registerFluidTank(MekanismBlockTypes.ADVANCED_FLUID_TANK);
//    public static final BlockRegistryObject<BlockFluidTank, ItemBlockFluidTank> ELITE_FLUID_TANK = registerFluidTank(MekanismBlockTypes.ELITE_FLUID_TANK);
//    public static final BlockRegistryObject<BlockFluidTank, ItemBlockFluidTank> ULTIMATE_FLUID_TANK = registerFluidTank(MekanismBlockTypes.ULTIMATE_FLUID_TANK);
//    public static final BlockRegistryObject<BlockFluidTank, ItemBlockFluidTank> CREATIVE_FLUID_TANK = registerFluidTank(MekanismBlockTypes.CREATIVE_FLUID_TANK);
//
//    public static final BlockRegistryObject<BlockTileModel<TileEntityFluidicPlenisher, Machine<TileEntityFluidicPlenisher>>, ItemBlockMachine> FLUIDIC_PLENISHER = BLOCKS.register("fluidic_plenisher", () -> new BlockTileModel<>(MekanismBlockTypes.FLUIDIC_PLENISHER), ItemBlockMachine::new);
//    public static final BlockRegistryObject<BlockTileModel<TileEntityLaser, BlockTypeTile<TileEntityLaser>>, ItemBlockTooltip<BlockTileModel<TileEntityLaser, BlockTypeTile<TileEntityLaser>>>> LASER = BLOCKS.register("laser", () -> new BlockTileModel<>(MekanismBlockTypes.LASER), ItemBlockTooltip::new);
//    public static final BlockRegistryObject<BlockTileModel<TileEntityLaserAmplifier, BlockTypeTile<TileEntityLaserAmplifier>>, ItemBlockTooltip<BlockTileModel<TileEntityLaserAmplifier, BlockTypeTile<TileEntityLaserAmplifier>>>> LASER_AMPLIFIER = BLOCKS.register("laser_amplifier", () -> new BlockTileModel<>(MekanismBlockTypes.LASER_AMPLIFIER), ItemBlockTooltip::new);
//    public static final BlockRegistryObject<BlockTileModel<TileEntityLaserTractorBeam, BlockTypeTile<TileEntityLaserTractorBeam>>, ItemBlockMachine> LASER_TRACTOR_BEAM = BLOCKS.register("laser_tractor_beam", () -> new BlockTileModel<>(MekanismBlockTypes.LASER_TRACTOR_BEAM), ItemBlockMachine::new);
//    public static final BlockRegistryObject<BlockTileModel<TileEntityQuantumEntangloporter, Machine<TileEntityQuantumEntangloporter>>, ItemBlockQuantumEntangloporter> QUANTUM_ENTANGLOPORTER = BLOCKS.register("quantum_entangloporter", () -> new BlockTileModel<>(MekanismBlockTypes.QUANTUM_ENTANGLOPORTER), ItemBlockQuantumEntangloporter::new);
//    public static final BlockRegistryObject<BlockTileModel<TileEntitySolarNeutronActivator, Machine<TileEntitySolarNeutronActivator>>, ItemBlockSolarNeutronActivator> SOLAR_NEUTRON_ACTIVATOR = BLOCKS.register("solar_neutron_activator", () -> new BlockTileModel<>(MekanismBlockTypes.SOLAR_NEUTRON_ACTIVATOR), ItemBlockSolarNeutronActivator::new);
//    public static final BlockRegistryObject<BlockTile<TileEntityOredictionificator, BlockTypeTile<TileEntityOredictionificator>>, ItemBlockMachine> OREDICTIONIFICATOR = BLOCKS.register("oredictionificator", () -> new BlockTile<>(MekanismBlockTypes.OREDICTIONIFICATOR), ItemBlockMachine::new);
//    public static final BlockRegistryObject<BlockTileModel<TileEntityResistiveHeater, Machine<TileEntityResistiveHeater>>, ItemBlockMachine> RESISTIVE_HEATER = BLOCKS.register("resistive_heater", () -> new BlockTileModel<>(MekanismBlockTypes.RESISTIVE_HEATER), ItemBlockMachine::new);
//    public static final BlockRegistryObject<BlockTile<TileEntityFormulaicAssemblicator, Machine<TileEntityFormulaicAssemblicator>>, ItemBlockMachine> FORMULAIC_ASSEMBLICATOR = BLOCKS.register("formulaic_assemblicator", () -> new BlockTile<>(MekanismBlockTypes.FORMULAIC_ASSEMBLICATOR), ItemBlockMachine::new);
//    public static final BlockRegistryObject<BlockTile<TileEntityFuelwoodHeater, BlockTypeTile<TileEntityFuelwoodHeater>>, ItemBlockMachine> FUELWOOD_HEATER = BLOCKS.register("fuelwood_heater", () -> new BlockTile<>(MekanismBlockTypes.FUELWOOD_HEATER), ItemBlockMachine::new);
//    public static final BlockRegistryObject<BlockTileModel<TileEntityModificationStation, BlockTypeTile<TileEntityModificationStation>>, ItemBlockMachine> MODIFICATION_STATION = BLOCKS.register("modification_station", () -> new BlockTileModel<>(MekanismBlockTypes.MODIFICATION_STATION), ItemBlockMachine::new);
//    public static final BlockRegistryObject<BlockTileModel<TileEntityAntiprotonicNucleosynthesizer, Machine<TileEntityAntiprotonicNucleosynthesizer>>, ItemBlockMachine> ANTIPROTONIC_NUCLEOSYNTHESIZER = BLOCKS.register("antiprotonic_nucleosynthesizer", () -> new BlockTileModel<>(MekanismBlockTypes.ANTIPROTONIC_NUCLEOSYNTHESIZER), ItemBlockMachine::new);
//    public static final BlockRegistryObject<BlockTile<TileEntityPigmentExtractor, Machine<TileEntityPigmentExtractor>>, ItemBlockMachine> PIGMENT_EXTRACTOR = BLOCKS.register("pigment_extractor", () -> new BlockTile<>(MekanismBlockTypes.PIGMENT_EXTRACTOR), ItemBlockMachine::new);
//    //Note: Bottom of the mixer block has no model, so it uses the normal BlockTile instead of BlockTileModel
//    public static final BlockRegistryObject<BlockTile<TileEntityPigmentMixer, Machine<TileEntityPigmentMixer>>, ItemBlockMachine> PIGMENT_MIXER = BLOCKS.register("pigment_mixer", () -> new BlockTile<>(MekanismBlockTypes.PIGMENT_MIXER), ItemBlockMachine::new);
//    public static final BlockRegistryObject<BlockTile<TileEntityPaintingMachine, Machine<TileEntityPaintingMachine>>, ItemBlockMachine> PAINTING_MACHINE = BLOCKS.register("painting_machine", () -> new BlockTile<>(MekanismBlockTypes.PAINTING_MACHINE), ItemBlockMachine::new);
//    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntitySPSCasing>, ItemBlockTooltip<BlockBasicMultiblock<TileEntitySPSCasing>>> SPS_CASING = registerBlock("sps_casing", () -> new BlockBasicMultiblock<>(MekanismBlockTypes.SPS_CASING), Rarity.EPIC);
//    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntitySPSPort>, ItemBlockTooltip<BlockBasicMultiblock<TileEntitySPSPort>>> SPS_PORT = registerBlock("sps_port", () -> new BlockBasicMultiblock<>(MekanismBlockTypes.SPS_PORT), Rarity.EPIC);
//    public static final BlockRegistryObject<BlockTileModel<TileEntitySuperchargedCoil, BlockTypeTile<TileEntitySuperchargedCoil>>, ItemBlockTooltip<BlockTileModel<TileEntitySuperchargedCoil, BlockTypeTile<TileEntitySuperchargedCoil>>>> SUPERCHARGED_COIL = registerBlock("supercharged_coil", () -> new BlockTileModel<>(MekanismBlockTypes.SUPERCHARGED_COIL), Rarity.EPIC);
//
//    public static final BlockRegistryObject<BlockTileModel<TileEntityQIODriveArray, BlockTypeTile<TileEntityQIODriveArray>>, ItemBlockMachine> QIO_DRIVE_ARRAY = BLOCKS.register("qio_drive_array", () -> new BlockTileModel<>(MekanismBlockTypes.QIO_DRIVE_ARRAY), ItemBlockQIOComponent::new);
//    public static final BlockRegistryObject<BlockTile<TileEntityQIODashboard, BlockTypeTile<TileEntityQIODashboard>>, ItemBlockMachine> QIO_DASHBOARD = BLOCKS.register("qio_dashboard", () -> new BlockTile<>(MekanismBlockTypes.QIO_DASHBOARD), ItemBlockQIOComponent::new);
//    public static final BlockRegistryObject<BlockTile<TileEntityQIOImporter, BlockTypeTile<TileEntityQIOImporter>>, ItemBlockMachine> QIO_IMPORTER = BLOCKS.register("qio_importer", () -> new BlockTile<>(MekanismBlockTypes.QIO_IMPORTER), ItemBlockQIOComponent::new);
//    public static final BlockRegistryObject<BlockTile<TileEntityQIOExporter, BlockTypeTile<TileEntityQIOExporter>>, ItemBlockMachine> QIO_EXPORTER = BLOCKS.register("qio_exporter", () -> new BlockTile<>(MekanismBlockTypes.QIO_EXPORTER), ItemBlockQIOComponent::new);
//    public static final BlockRegistryObject<BlockTile<TileEntityQIORedstoneAdapter, BlockTypeTile<TileEntityQIORedstoneAdapter>>, ItemBlockMachine> QIO_REDSTONE_ADAPTER = BLOCKS.register("qio_redstone_adapter", () -> new BlockTile<>(MekanismBlockTypes.QIO_REDSTONE_ADAPTER), ItemBlockQIOComponent::new);
//
//    public static final BlockRegistryObject<BlockEnergyCube, ItemBlockEnergyCube> BASIC_ENERGY_CUBE = registerEnergyCube(MekanismBlockTypes.BASIC_ENERGY_CUBE);
//    public static final BlockRegistryObject<BlockEnergyCube, ItemBlockEnergyCube> ADVANCED_ENERGY_CUBE = registerEnergyCube(MekanismBlockTypes.ADVANCED_ENERGY_CUBE);
//    public static final BlockRegistryObject<BlockEnergyCube, ItemBlockEnergyCube> ELITE_ENERGY_CUBE = registerEnergyCube(MekanismBlockTypes.ELITE_ENERGY_CUBE);
//    public static final BlockRegistryObject<BlockEnergyCube, ItemBlockEnergyCube> ULTIMATE_ENERGY_CUBE = registerEnergyCube(MekanismBlockTypes.ULTIMATE_ENERGY_CUBE);
//    public static final BlockRegistryObject<BlockEnergyCube, ItemBlockEnergyCube> CREATIVE_ENERGY_CUBE = registerEnergyCube(MekanismBlockTypes.CREATIVE_ENERGY_CUBE);
//
//    public static final BlockRegistryObject<BlockUniversalCable, ItemBlockUniversalCable> BASIC_UNIVERSAL_CABLE = registerUniversalCable(CableTier.BASIC);
//    public static final BlockRegistryObject<BlockUniversalCable, ItemBlockUniversalCable> ADVANCED_UNIVERSAL_CABLE = registerUniversalCable(CableTier.ADVANCED);
//    public static final BlockRegistryObject<BlockUniversalCable, ItemBlockUniversalCable> ELITE_UNIVERSAL_CABLE = registerUniversalCable(CableTier.ELITE);
//    public static final BlockRegistryObject<BlockUniversalCable, ItemBlockUniversalCable> ULTIMATE_UNIVERSAL_CABLE = registerUniversalCable(CableTier.ULTIMATE);
//
//    public static final BlockRegistryObject<BlockMechanicalPipe, ItemBlockMechanicalPipe> BASIC_MECHANICAL_PIPE = registerMechanicalPipe(PipeTier.BASIC);
//    public static final BlockRegistryObject<BlockMechanicalPipe, ItemBlockMechanicalPipe> ADVANCED_MECHANICAL_PIPE = registerMechanicalPipe(PipeTier.ADVANCED);
//    public static final BlockRegistryObject<BlockMechanicalPipe, ItemBlockMechanicalPipe> ELITE_MECHANICAL_PIPE = registerMechanicalPipe(PipeTier.ELITE);
//    public static final BlockRegistryObject<BlockMechanicalPipe, ItemBlockMechanicalPipe> ULTIMATE_MECHANICAL_PIPE = registerMechanicalPipe(PipeTier.ULTIMATE);
//
//    public static final BlockRegistryObject<BlockPressurizedTube, ItemBlockPressurizedTube> BASIC_PRESSURIZED_TUBE = registerPressurizedTube(TubeTier.BASIC);
//    public static final BlockRegistryObject<BlockPressurizedTube, ItemBlockPressurizedTube> ADVANCED_PRESSURIZED_TUBE = registerPressurizedTube(TubeTier.ADVANCED);
//    public static final BlockRegistryObject<BlockPressurizedTube, ItemBlockPressurizedTube> ELITE_PRESSURIZED_TUBE = registerPressurizedTube(TubeTier.ELITE);
//    public static final BlockRegistryObject<BlockPressurizedTube, ItemBlockPressurizedTube> ULTIMATE_PRESSURIZED_TUBE = registerPressurizedTube(TubeTier.ULTIMATE);
//
//    public static final BlockRegistryObject<BlockLogisticalTransporter, ItemBlockLogisticalTransporter> BASIC_LOGISTICAL_TRANSPORTER = registerLogisticalTransporter(TransporterTier.BASIC);
//    public static final BlockRegistryObject<BlockLogisticalTransporter, ItemBlockLogisticalTransporter> ADVANCED_LOGISTICAL_TRANSPORTER = registerLogisticalTransporter(TransporterTier.ADVANCED);
//    public static final BlockRegistryObject<BlockLogisticalTransporter, ItemBlockLogisticalTransporter> ELITE_LOGISTICAL_TRANSPORTER = registerLogisticalTransporter(TransporterTier.ELITE);
//    public static final BlockRegistryObject<BlockLogisticalTransporter, ItemBlockLogisticalTransporter> ULTIMATE_LOGISTICAL_TRANSPORTER = registerLogisticalTransporter(TransporterTier.ULTIMATE);
//
//    public static final BlockRegistryObject<BlockRestrictiveTransporter, ItemBlockRestrictiveTransporter> RESTRICTIVE_TRANSPORTER = BLOCKS.register("restrictive_transporter", BlockRestrictiveTransporter::new, ItemBlockRestrictiveTransporter::new);
//    public static final BlockRegistryObject<BlockDiversionTransporter, ItemBlockDiversionTransporter> DIVERSION_TRANSPORTER = BLOCKS.register("diversion_transporter", BlockDiversionTransporter::new, ItemBlockDiversionTransporter::new);
//
//    public static final BlockRegistryObject<BlockThermodynamicConductor, ItemBlockThermodynamicConductor> BASIC_THERMODYNAMIC_CONDUCTOR = registerThermodynamicConductor(ConductorTier.BASIC);
//    public static final BlockRegistryObject<BlockThermodynamicConductor, ItemBlockThermodynamicConductor> ADVANCED_THERMODYNAMIC_CONDUCTOR = registerThermodynamicConductor(ConductorTier.ADVANCED);
//    public static final BlockRegistryObject<BlockThermodynamicConductor, ItemBlockThermodynamicConductor> ELITE_THERMODYNAMIC_CONDUCTOR = registerThermodynamicConductor(ConductorTier.ELITE);
//    public static final BlockRegistryObject<BlockThermodynamicConductor, ItemBlockThermodynamicConductor> ULTIMATE_THERMODYNAMIC_CONDUCTOR = registerThermodynamicConductor(ConductorTier.ULTIMATE);
//
//    public static final BlockRegistryObject<BlockBounding, BlockItem> BOUNDING_BLOCK = registerBoundingBlock("bounding_block", BlockBounding::new);
//
//    public static final BlockRegistryObject<BlockTileModel<TileEntityChemicalTank, Machine<TileEntityChemicalTank>>, ItemBlockChemicalTank> BASIC_CHEMICAL_TANK = registerChemicalTank(MekanismBlockTypes.BASIC_CHEMICAL_TANK);
//    public static final BlockRegistryObject<BlockTileModel<TileEntityChemicalTank, Machine<TileEntityChemicalTank>>, ItemBlockChemicalTank> ADVANCED_CHEMICAL_TANK = registerChemicalTank(MekanismBlockTypes.ADVANCED_CHEMICAL_TANK);
//    public static final BlockRegistryObject<BlockTileModel<TileEntityChemicalTank, Machine<TileEntityChemicalTank>>, ItemBlockChemicalTank> ELITE_CHEMICAL_TANK = registerChemicalTank(MekanismBlockTypes.ELITE_CHEMICAL_TANK);
//    public static final BlockRegistryObject<BlockTileModel<TileEntityChemicalTank, Machine<TileEntityChemicalTank>>, ItemBlockChemicalTank> ULTIMATE_CHEMICAL_TANK = registerChemicalTank(MekanismBlockTypes.ULTIMATE_CHEMICAL_TANK);
//    public static final BlockRegistryObject<BlockTileModel<TileEntityChemicalTank, Machine<TileEntityChemicalTank>>, ItemBlockChemicalTank> CREATIVE_CHEMICAL_TANK = registerChemicalTank(MekanismBlockTypes.CREATIVE_CHEMICAL_TANK);
//
//    public static final BlockRegistryObject<BlockCardboardBox, ItemBlockCardboardBox> CARDBOARD_BOX = BLOCKS.register("cardboard_box", BlockCardboardBox::new, ItemBlockCardboardBox::new);
//    public static final BlockRegistryObject<Block, BlockItem> SALT_BLOCK = BLOCKS.register("block_salt", Properties.of(Material.SAND).strength(0.5F).sound(SoundType.SAND));

    //    private static BlockRegistryObject<BlockBounding, BlockItem> registerBoundingBlock(String name, Supplier<BlockBounding> blockSupplier) {
//        return BLOCKS.register(name, blockSupplier, block -> new BlockItem(block, new Item.Properties()));
//    }
//
    private static BlockRegistryObject<BlockResource, ItemBlockResource> registerResourceBlock(BlockResourceInfo resource) {
        return BLOCKS.registerDefaultProperties("block_" + resource.getRegistrySuffix(), () -> new BlockResource(resource), (block, properties) -> {
            if (!block.getResourceInfo().burnsInFire()) {
                properties = properties.fireResistant();
            }
            return new ItemBlockResource(block, properties);
        });
    }

//    private static BlockRegistryObject<BlockBin, ItemBlockBin> registerBin(BlockTypeTile<TileEntityBin> type) {
//        return registerTieredBlock(type.get(AttributeTier.class).tier(), "_bin", () -> new BlockBin(type), ItemBlockBin::new);
//    }
//
//    private static BlockRegistryObject<BlockTile<TileEntityInductionCell, BlockTypeTile<TileEntityInductionCell>>, ItemBlockInductionCell> registerInductionCell(BlockTypeTile<TileEntityInductionCell> type) {
//        return registerTieredBlock(type.get(AttributeTier.class).tier(), "_induction_cell", () -> new BlockTile<>(type), ItemBlockInductionCell::new);
//    }
//
//    private static BlockRegistryObject<BlockTile<TileEntityInductionProvider, BlockTypeTile<TileEntityInductionProvider>>, ItemBlockInductionProvider> registerInductionProvider(BlockTypeTile<TileEntityInductionProvider> type) {
//        return registerTieredBlock(type.get(AttributeTier.class).tier(), "_induction_provider", () -> new BlockTile<>(type), ItemBlockInductionProvider::new);
//    }
//
//    private static BlockRegistryObject<BlockFluidTank, ItemBlockFluidTank> registerFluidTank(Machine<TileEntityFluidTank> type) {
//        return registerTieredBlock(type.get(AttributeTier.class).tier(), "_fluid_tank", () -> new BlockFluidTank(type), ItemBlockFluidTank::new);
//    }
//
//    private static BlockRegistryObject<BlockEnergyCube, ItemBlockEnergyCube> registerEnergyCube(Machine<TileEntityEnergyCube> type) {
//        return registerTieredBlock(type.get(AttributeTier.class).tier(), "_energy_cube", () -> new BlockEnergyCube(type), ItemBlockEnergyCube::new);
//    }
//
//    private static BlockRegistryObject<BlockUniversalCable, ItemBlockUniversalCable> registerUniversalCable(CableTier tier) {
//        return registerTieredBlock(tier, "_universal_cable", () -> new BlockUniversalCable(tier), ItemBlockUniversalCable::new);
//    }
//
//    private static BlockRegistryObject<BlockMechanicalPipe, ItemBlockMechanicalPipe> registerMechanicalPipe(PipeTier tier) {
//        return registerTieredBlock(tier, "_mechanical_pipe", () -> new BlockMechanicalPipe(tier), ItemBlockMechanicalPipe::new);
//    }
//
//    private static BlockRegistryObject<BlockPressurizedTube, ItemBlockPressurizedTube> registerPressurizedTube(TubeTier tier) {
//        return registerTieredBlock(tier, "_pressurized_tube", () -> new BlockPressurizedTube(tier), ItemBlockPressurizedTube::new);
//    }
//
//    private static BlockRegistryObject<BlockLogisticalTransporter, ItemBlockLogisticalTransporter> registerLogisticalTransporter(TransporterTier tier) {
//        return registerTieredBlock(tier, "_logistical_transporter", () -> new BlockLogisticalTransporter(tier), ItemBlockLogisticalTransporter::new);
//    }
//
//    private static BlockRegistryObject<BlockThermodynamicConductor, ItemBlockThermodynamicConductor> registerThermodynamicConductor(ConductorTier tier) {
//        return registerTieredBlock(tier, "_thermodynamic_conductor", () -> new BlockThermodynamicConductor(tier), ItemBlockThermodynamicConductor::new);
//    }
//
//    private static BlockRegistryObject<BlockTileModel<TileEntityChemicalTank, Machine<TileEntityChemicalTank>>, ItemBlockChemicalTank> registerChemicalTank(
//          Machine<TileEntityChemicalTank> type) {
//        return registerTieredBlock(type.get(AttributeTier.class).tier(), "_chemical_tank", () -> new BlockTileModel<>(type), ItemBlockChemicalTank::new);
//    }
//
//    private static <TILE extends TileEntityFactory<?>> BlockRegistryObject<BlockFactory<?>, ItemBlockFactory> registerFactory(Factory<TILE> type) {
//        return registerTieredBlock(type.get(AttributeTier.class).tier(), "_" + type.get(AttributeFactoryType.class).getFactoryType().getRegistryNameComponent() + "_factory", () -> new BlockFactory<>(type), ItemBlockFactory::new);
//    }

    private static <BLOCK extends Block, ITEM extends BlockItem> BlockRegistryObject<BLOCK, ITEM> registerTieredBlock(ITier tier, String suffix,
                                                                                                                      Supplier<? extends BLOCK> blockSupplier, Function<BLOCK, ITEM> itemCreator) {
        return BLOCKS.register(tier.getBaseTier().getLowerName() + suffix, blockSupplier, itemCreator);
    }

    private static OreBlockType registerOre(OreType ore) {
        String name = ore.getResource().getRegistrySuffix() + "_ore";
        BlockRegistryObject<BlockOre, ItemBlockTooltip<BlockOre>> stoneOre = registerBlock(name, () -> new BlockOre(ore));
        BlockRegistryObject<BlockOre, ItemBlockTooltip<BlockOre>> deepslateOre = BLOCKS.registerDefaultProperties("deepslate_" + name,
              () -> new BlockOre(ore, BlockBehaviour.Properties.copy(stoneOre.getBlock()).color(MaterialColor.DEEPSLATE)
                    .strength(4.5F, 3).sound(SoundType.DEEPSLATE)), ItemBlockTooltip::new);
        return new OreBlockType(stoneOre, deepslateOre);
    }

    private static <BLOCK extends Block & IHasDescription> BlockRegistryObject<BLOCK, ItemBlockTooltip<BLOCK>> registerBlock(String name,
                                                                                                                             Supplier<? extends BLOCK> blockSupplier) {
        return BLOCKS.registerDefaultProperties(name, blockSupplier, ItemBlockTooltip::new);
    }

    private static <BLOCK extends Block & IHasDescription> BlockRegistryObject<BLOCK, ItemBlockTooltip<BLOCK>> registerBlock(String name,
                                                                                                                             Supplier<? extends BLOCK> blockSupplier, Rarity rarity) {
        return BLOCKS.registerDefaultProperties(name, blockSupplier, (block, props) -> new ItemBlockTooltip<>(block, props.rarity(rarity)));
    }

//    /**
//     * Retrieves a Factory with a defined tier and recipe type.
//     *
//     * @param tier - tier to add to the Factory
//     * @param type - recipe type to add to the Factory
//     * @return factory with defined tier and recipe type
//     */
//    public static BlockRegistryObject<BlockFactory<?>, ItemBlockFactory> getFactory(@Nonnull FactoryTier tier, @Nonnull FactoryType type) {
//        return FACTORIES.get(tier, type);
//    }
//
//    @SuppressWarnings("unchecked")
//    public static BlockRegistryObject<BlockFactory<?>, ItemBlockFactory>[] getFactoryBlocks() {
//        return FACTORIES.values().toArray(new BlockRegistryObject[0]);
//    }
    public static void init() {
    }
}