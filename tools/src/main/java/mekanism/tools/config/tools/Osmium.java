package mekanism.tools.config.tools;

import com.electronwill.nightconfig.core.conversion.Path;
import com.electronwill.nightconfig.core.conversion.SpecFloatInRange;
import com.electronwill.nightconfig.core.conversion.SpecIntInRange;
import lombok.Getter;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import mekanism.config.helpers.TOMLConfigSerializer;
import mekanism.tools.materials.OsmiumMaterialDefaults;
import net.minecraft.entity.EquipmentSlot;

public class Osmium extends AbstractMaterialConfig implements ConfigData {

    @Getter
    @Path(OsmiumMaterialDefaults.name + "AttackDamage")
    @ConfigEntry.Gui.Tooltip
    @SpecFloatInRange(min = 0.0F, max = Float.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Base attack damage of " + OsmiumMaterialDefaults.name + " items."
    })
    public float attackDamage = DEFAULT.getAttackDamage();

    @Getter
    @Path(OsmiumMaterialDefaults.name + "ShieldDurability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + OsmiumMaterialDefaults.name + " shields."
    })
    public int shieldDurability = DEFAULT.getShieldDurability();

    @Path(OsmiumMaterialDefaults.name + "SwordDamage")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack damage modifier of " + OsmiumMaterialDefaults.name + " swords."
    })
    public float swordDamage = DEFAULT.getSwordDamage();

    @Path(OsmiumMaterialDefaults.name + "SwordAtkSpeed")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack speed of " + OsmiumMaterialDefaults.name + " swords."
    })
    public float swordAtkSpeed = DEFAULT.getSwordAtkSpeed();

    @Path(OsmiumMaterialDefaults.name + "ShovelDamage")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack damage modifier of " + OsmiumMaterialDefaults.name + " shovels."
    })
    public float shovelDamage = DEFAULT.getShovelDamage();

    @Path(OsmiumMaterialDefaults.name + "ShovelAtkSpeed")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack speed of " + OsmiumMaterialDefaults.name + " shovels."
    })
    public float shovelAtkSpeed = DEFAULT.getShovelAtkSpeed();

    @Getter
    @Path(OsmiumMaterialDefaults.name + "AxeDamage")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack damage modifier of " + OsmiumMaterialDefaults.name + " axes."
    })
    public float axeDamage = DEFAULT.getAxeDamage();

    @Getter
    @Path(OsmiumMaterialDefaults.name + "AxeAtkSpeed")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack speed of " + OsmiumMaterialDefaults.name + " axes."
    })
    public float axeAtkSpeed = DEFAULT.getAxeAtkSpeed();

    @Path(OsmiumMaterialDefaults.name + "PickaxeDamage")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack damage modifier of " + OsmiumMaterialDefaults.name + " pickaxes."
    })
    public float pickaxeDamage = DEFAULT.getPickaxeDamage();

    @Path(OsmiumMaterialDefaults.name + "PickaxeAtkSpeed")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack speed of " + OsmiumMaterialDefaults.name + " pickaxes."
    })
    public float pickaxeAtkSpeed = DEFAULT.getPickaxeAtkSpeed();

    @Path(OsmiumMaterialDefaults.name + "HoeDamage")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack damage modifier of " + OsmiumMaterialDefaults.name + " hoes."
    })
    public float hoeDamage = DEFAULT.getPickaxeAtkSpeed();

    @Path(OsmiumMaterialDefaults.name + "HoeAtkSpeed")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack speed of " + OsmiumMaterialDefaults.name + " hoes."
    })
    public float hoeAtkSpeed = DEFAULT.getHoeAtkSpeed();

    @Getter
    @Path(OsmiumMaterialDefaults.name + "ToolMaxUses")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + OsmiumMaterialDefaults.name + " tools."
    })
    public int durability = DEFAULT.getDurability();

    @Getter
    @Path(OsmiumMaterialDefaults.name + "Efficiency")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Efficiency of " + OsmiumMaterialDefaults.name + " tools."
    })
    public float miningSpeedMultiplier = DEFAULT.getMiningSpeedMultiplier();

    @Getter
    @Path(OsmiumMaterialDefaults.name + "PaxelHarvestLevel")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Harvest level of " + OsmiumMaterialDefaults.name + " paxels."
    })
    public int paxelHarvestLevel = DEFAULT.getPaxelHarvestLevel();

    @Getter
    @Path(OsmiumMaterialDefaults.name + "PaxelDamage")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack damage modifier of " + OsmiumMaterialDefaults.name + " paxels."
    })
    public float paxelDamage = DEFAULT.getPaxelDamage();

    @Path(OsmiumMaterialDefaults.name + "PaxelAtkSpeed")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack speed of " + OsmiumMaterialDefaults.name + " paxels."
    })
    public float paxelAtkSpeed = DEFAULT.getPaxelAtkSpeed();

    @Getter
    @Path(OsmiumMaterialDefaults.name + "PaxelEfficiency")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Efficiency of " + OsmiumMaterialDefaults.name + " paxels."
    })
    public float paxelEfficiency = DEFAULT.getPaxelEfficiency();

    @Getter
    @Path(OsmiumMaterialDefaults.name + "PaxelEnchantability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Natural enchantability factor of " + OsmiumMaterialDefaults.name + " paxels."
    })
    public int paxelEnchantability = DEFAULT.getPaxelEnchantability();

    @Getter
    @Path(OsmiumMaterialDefaults.name + "PaxelMaxUses")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + OsmiumMaterialDefaults.name + " paxels."
    })
    public int paxelMaxUses = DEFAULT.getPaxelMaxUses();

    @Getter
    @Path(OsmiumMaterialDefaults.name + "HarvestLevel")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Harvest level of " + OsmiumMaterialDefaults.name + " tools."
    })
    public int miningLevel = DEFAULT.getMiningLevel();

    @Getter
    @Path(OsmiumMaterialDefaults.name + "Enchantability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Natural enchantability factor of " + OsmiumMaterialDefaults.name + " items."
    })
    public int enchantability = DEFAULT.getEnchantability();

    @Getter
    @Path(OsmiumMaterialDefaults.name + "Toughness")
    @ConfigEntry.Gui.Tooltip
    @SpecFloatInRange(min = 0.0F, max = Float.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Base armor toughness value of " + OsmiumMaterialDefaults.name + " armor."
    })
    public float toughness = DEFAULT.getToughness();

    @Getter
    @Path(OsmiumMaterialDefaults.name + "KnockbackResistance")
    @ConfigEntry.Gui.Tooltip
    @SpecFloatInRange(min = 0.0F, max = Float.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Base armor knockback resistance value of " + OsmiumMaterialDefaults.name + " armor."
    })
    public float knockbackResistance = DEFAULT.getKnockbackResistance();

    @Getter
    @Path(OsmiumMaterialDefaults.name + "BootDurability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + OsmiumMaterialDefaults.name + " boots."
    })
    public int bootDurability = DEFAULT.getDurability(EquipmentSlot.FEET);

    @Getter
    @Path(OsmiumMaterialDefaults.name + "LeggingDurability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + OsmiumMaterialDefaults.name + " leggings."
    })
    public int leggingDurability = DEFAULT.getDurability(EquipmentSlot.LEGS);

    @Getter
    @Path(OsmiumMaterialDefaults.name + "ChestplateDurability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + OsmiumMaterialDefaults.name + " chestplates."
    })
    public int chestplateDurability = DEFAULT.getDurability(EquipmentSlot.CHEST);

    @Getter
    @Path(OsmiumMaterialDefaults.name + "HelmetDurability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + OsmiumMaterialDefaults.name + " helmets."
    })
    public int helmetDurability = DEFAULT.getDurability(EquipmentSlot.HEAD);

    @Getter
    @Path(OsmiumMaterialDefaults.name + "BootArmor")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Protection value of " + OsmiumMaterialDefaults.name + " boots."
    })
    public int bootArmor = DEFAULT.getProtectionAmount(EquipmentSlot.FEET);

    @Getter
    @Path(OsmiumMaterialDefaults.name + "LeggingArmor")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Protection value of " + OsmiumMaterialDefaults.name + " leggings."
    })
    public int leggingArmor = DEFAULT.getProtectionAmount(EquipmentSlot.LEGS);

    @Getter
    @Path(OsmiumMaterialDefaults.name + "ChestplateArmor")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Protection value of " + OsmiumMaterialDefaults.name + " chestplates."
    })
    public int chestplateArmor = DEFAULT.getProtectionAmount(EquipmentSlot.CHEST);

    @Getter
    @Path(OsmiumMaterialDefaults.name + "HelmetArmor")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Protection value of " + OsmiumMaterialDefaults.name + " helmets."
    })
    public int helmetArmor = DEFAULT.getProtectionAmount(EquipmentSlot.HEAD);

    protected Osmium() { super(new OsmiumMaterialDefaults()); }

}
