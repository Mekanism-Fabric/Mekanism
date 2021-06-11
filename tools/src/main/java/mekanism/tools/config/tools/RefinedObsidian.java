package mekanism.tools.config.tools;

import com.electronwill.nightconfig.core.conversion.Path;
import com.electronwill.nightconfig.core.conversion.SpecFloatInRange;
import com.electronwill.nightconfig.core.conversion.SpecIntInRange;
import lombok.Getter;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import mekanism.config.TOMLConfigSerializer;
import mekanism.tools.materials.RefinedObsidianMaterialDefaults;
import net.minecraft.entity.EquipmentSlot;

public class RefinedObsidian extends AbstractMaterialConfig implements ConfigData {

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "AttackDamage")
    @ConfigEntry.Gui.Tooltip
    @SpecFloatInRange(min = 0.0F, max = Float.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Base attack damage of " + RefinedObsidianMaterialDefaults.name + " items."
    })
    public float attackDamage = DEFAULT.getAttackDamage();

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "ShieldDurability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + RefinedObsidianMaterialDefaults.name + " shields."
    })
    public int shieldDurability = DEFAULT.getShieldDurability();

    @Path(RefinedObsidianMaterialDefaults.name + "SwordDamage")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack damage modifier of " + RefinedObsidianMaterialDefaults.name + " swords."
    })
    public float swordDamage = DEFAULT.getSwordDamage();

    @Path(RefinedObsidianMaterialDefaults.name + "SwordAtkSpeed")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack speed of " + RefinedObsidianMaterialDefaults.name + " swords."
    })
    public float swordAtkSpeed = DEFAULT.getSwordAtkSpeed();

    @Path(RefinedObsidianMaterialDefaults.name + "ShovelDamage")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack damage modifier of " + RefinedObsidianMaterialDefaults.name + " shovels."
    })
    public float shovelDamage = DEFAULT.getShovelDamage();

    @Path(RefinedObsidianMaterialDefaults.name + "ShovelAtkSpeed")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack speed of " + RefinedObsidianMaterialDefaults.name + " shovels."
    })
    public float shovelAtkSpeed = DEFAULT.getShovelAtkSpeed();

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "AxeDamage")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack damage modifier of " + RefinedObsidianMaterialDefaults.name + " axes."
    })
    public float axeDamage = DEFAULT.getAxeDamage();

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "AxeAtkSpeed")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack speed of " + RefinedObsidianMaterialDefaults.name + " axes."
    })
    public float axeAtkSpeed = DEFAULT.getAxeAtkSpeed();

    @Path(RefinedObsidianMaterialDefaults.name + "PickaxeDamage")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack damage modifier of " + RefinedObsidianMaterialDefaults.name + " pickaxes."
    })
    public float pickaxeDamage = DEFAULT.getPickaxeDamage();

    @Path(RefinedObsidianMaterialDefaults.name + "PickaxeAtkSpeed")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack speed of " + RefinedObsidianMaterialDefaults.name + " pickaxes."
    })
    public float pickaxeAtkSpeed = DEFAULT.getPickaxeAtkSpeed();

    @Path(RefinedObsidianMaterialDefaults.name + "HoeDamage")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack damage modifier of " + RefinedObsidianMaterialDefaults.name + " hoes."
    })
    public float hoeDamage = DEFAULT.getPickaxeAtkSpeed();

    @Path(RefinedObsidianMaterialDefaults.name + "HoeAtkSpeed")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack speed of " + RefinedObsidianMaterialDefaults.name + " hoes."
    })
    public float hoeAtkSpeed = DEFAULT.getHoeAtkSpeed();

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "ToolMaxUses")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + RefinedObsidianMaterialDefaults.name + " tools."
    })
    public int durability = DEFAULT.getDurability();

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "Efficiency")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Efficiency of " + RefinedObsidianMaterialDefaults.name + " tools."
    })
    public float miningSpeedMultiplier = DEFAULT.getMiningSpeedMultiplier();

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "PaxelHarvestLevel")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Harvest level of " + RefinedObsidianMaterialDefaults.name + " paxels."
    })
    public int paxelHarvestLevel = DEFAULT.getPaxelHarvestLevel();

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "PaxelDamage")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack damage modifier of " + RefinedObsidianMaterialDefaults.name + " paxels."
    })
    public float paxelDamage = DEFAULT.getPaxelDamage();

    @Path(RefinedObsidianMaterialDefaults.name + "PaxelAtkSpeed")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack speed of " + RefinedObsidianMaterialDefaults.name + " paxels."
    })
    public float paxelAtkSpeed = DEFAULT.getPaxelAtkSpeed();

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "PaxelEfficiency")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Efficiency of " + RefinedObsidianMaterialDefaults.name + " paxels."
    })
    public float paxelEfficiency = DEFAULT.getPaxelEfficiency();

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "PaxelEnchantability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Natural enchantability factor of " + RefinedObsidianMaterialDefaults.name + " paxels."
    })
    public int paxelEnchantability = DEFAULT.getPaxelEnchantability();

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "PaxelMaxUses")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + RefinedObsidianMaterialDefaults.name + " paxels."
    })
    public int paxelMaxUses = DEFAULT.getPaxelMaxUses();

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "HarvestLevel")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Harvest level of " + RefinedObsidianMaterialDefaults.name + " tools."
    })
    public int miningLevel = DEFAULT.getMiningLevel();

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "Enchantability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Natural enchantability factor of " + RefinedObsidianMaterialDefaults.name + " items."
    })
    public int enchantability = DEFAULT.getEnchantability();

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "Toughness")
    @ConfigEntry.Gui.Tooltip
    @SpecFloatInRange(min = 0.0F, max = Float.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Base armor toughness value of " + RefinedObsidianMaterialDefaults.name + " armor."
    })
    public float toughness = DEFAULT.getToughness();

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "KnockbackResistance")
    @ConfigEntry.Gui.Tooltip
    @SpecFloatInRange(min = 0.0F, max = Float.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Base armor knockback resistance value of " + RefinedObsidianMaterialDefaults.name + " armor."
    })
    public float knockbackResistance = DEFAULT.getKnockbackResistance();

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "BootDurability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + RefinedObsidianMaterialDefaults.name + " boots."
    })
    public int bootDurability = DEFAULT.getDurability(EquipmentSlot.FEET);

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "LeggingDurability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + RefinedObsidianMaterialDefaults.name + " leggings."
    })
    public int leggingDurability = DEFAULT.getDurability(EquipmentSlot.LEGS);

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "ChestplateDurability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + RefinedObsidianMaterialDefaults.name + " chestplates."
    })
    public int chestplateDurability = DEFAULT.getDurability(EquipmentSlot.CHEST);

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "HelmetDurability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + RefinedObsidianMaterialDefaults.name + " helmets."
    })
    public int helmetDurability = DEFAULT.getDurability(EquipmentSlot.HEAD);

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "BootArmor")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Protection value of " + RefinedObsidianMaterialDefaults.name + " boots."
    })
    public int bootArmor = DEFAULT.getProtectionAmount(EquipmentSlot.FEET);

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "LeggingArmor")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Protection value of " + RefinedObsidianMaterialDefaults.name + " leggings."
    })
    public int leggingArmor = DEFAULT.getProtectionAmount(EquipmentSlot.LEGS);

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "ChestplateArmor")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Protection value of " + RefinedObsidianMaterialDefaults.name + " chestplates."
    })
    public int chestplateArmor = DEFAULT.getProtectionAmount(EquipmentSlot.CHEST);

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "HelmetArmor")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Protection value of " + RefinedObsidianMaterialDefaults.name + " helmets."
    })
    public int helmetArmor = DEFAULT.getProtectionAmount(EquipmentSlot.HEAD);

    protected RefinedObsidian() { super(new RefinedObsidianMaterialDefaults()); }

}
