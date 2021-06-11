package mekanism.tools.config.tools;

import com.electronwill.nightconfig.core.conversion.Path;
import com.electronwill.nightconfig.core.conversion.SpecFloatInRange;
import com.electronwill.nightconfig.core.conversion.SpecIntInRange;
import lombok.Getter;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import mekanism.config.TOMLConfigSerializer;
import mekanism.tools.materials.SteelMaterialDefaults;
import net.minecraft.entity.EquipmentSlot;

public class Steel extends AbstractMaterialConfig implements ConfigData {

    @Getter
    @Path(SteelMaterialDefaults.name + "AttackDamage")
    @ConfigEntry.Gui.Tooltip
    @SpecFloatInRange(min = 0.0F, max = Float.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Base attack damage of " + SteelMaterialDefaults.name + " items."
    })
    public float attackDamage = DEFAULT.getAttackDamage();

    @Getter
    @Path(SteelMaterialDefaults.name + "ShieldDurability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + SteelMaterialDefaults.name + " shields."
    })
    public int shieldDurability = DEFAULT.getShieldDurability();

    @Path(SteelMaterialDefaults.name + "SwordDamage")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack damage modifier of " + SteelMaterialDefaults.name + " swords."
    })
    public float swordDamage = DEFAULT.getSwordDamage();

    @Path(SteelMaterialDefaults.name + "SwordAtkSpeed")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack speed of " + SteelMaterialDefaults.name + " swords."
    })
    public float swordAtkSpeed = DEFAULT.getSwordAtkSpeed();

    @Path(SteelMaterialDefaults.name + "ShovelDamage")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack damage modifier of " + SteelMaterialDefaults.name + " shovels."
    })
    public float shovelDamage = DEFAULT.getShovelDamage();

    @Path(SteelMaterialDefaults.name + "ShovelAtkSpeed")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack speed of " + SteelMaterialDefaults.name + " shovels."
    })
    public float shovelAtkSpeed = DEFAULT.getShovelAtkSpeed();

    @Getter
    @Path(SteelMaterialDefaults.name + "AxeDamage")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack damage modifier of " + SteelMaterialDefaults.name + " axes."
    })
    public float axeDamage = DEFAULT.getAxeDamage();

    @Getter
    @Path(SteelMaterialDefaults.name + "AxeAtkSpeed")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack speed of " + SteelMaterialDefaults.name + " axes."
    })
    public float axeAtkSpeed = DEFAULT.getAxeAtkSpeed();

    @Path(SteelMaterialDefaults.name + "PickaxeDamage")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack damage modifier of " + SteelMaterialDefaults.name + " pickaxes."
    })
    public float pickaxeDamage = DEFAULT.getPickaxeDamage();

    @Path(SteelMaterialDefaults.name + "PickaxeAtkSpeed")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack speed of " + SteelMaterialDefaults.name + " pickaxes."
    })
    public float pickaxeAtkSpeed = DEFAULT.getPickaxeAtkSpeed();

    @Path(SteelMaterialDefaults.name + "HoeDamage")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack damage modifier of " + SteelMaterialDefaults.name + " hoes."
    })
    public float hoeDamage = DEFAULT.getPickaxeAtkSpeed();

    @Path(SteelMaterialDefaults.name + "HoeAtkSpeed")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack speed of " + SteelMaterialDefaults.name + " hoes."
    })
    public float hoeAtkSpeed = DEFAULT.getHoeAtkSpeed();

    @Getter
    @Path(SteelMaterialDefaults.name + "ToolMaxUses")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + SteelMaterialDefaults.name + " tools."
    })
    public int durability = DEFAULT.getDurability();

    @Getter
    @Path(SteelMaterialDefaults.name + "Efficiency")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Efficiency of " + SteelMaterialDefaults.name + " tools."
    })
    public float miningSpeedMultiplier = DEFAULT.getMiningSpeedMultiplier();

    @Getter
    @Path(SteelMaterialDefaults.name + "PaxelHarvestLevel")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Harvest level of " + SteelMaterialDefaults.name + " paxels."
    })
    public int paxelHarvestLevel = DEFAULT.getPaxelHarvestLevel();

    @Getter
    @Path(SteelMaterialDefaults.name + "PaxelDamage")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack damage modifier of " + SteelMaterialDefaults.name + " paxels."
    })
    public float paxelDamage = DEFAULT.getPaxelDamage();

    @Path(SteelMaterialDefaults.name + "PaxelAtkSpeed")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack speed of " + SteelMaterialDefaults.name + " paxels."
    })
    public float paxelAtkSpeed = DEFAULT.getPaxelAtkSpeed();

    @Getter
    @Path(SteelMaterialDefaults.name + "PaxelEfficiency")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Efficiency of " + SteelMaterialDefaults.name + " paxels."
    })
    public float paxelEfficiency = DEFAULT.getPaxelEfficiency();

    @Getter
    @Path(SteelMaterialDefaults.name + "PaxelEnchantability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Natural enchantability factor of " + SteelMaterialDefaults.name + " paxels."
    })
    public int paxelEnchantability = DEFAULT.getPaxelEnchantability();

    @Getter
    @Path(SteelMaterialDefaults.name + "PaxelMaxUses")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + SteelMaterialDefaults.name + " paxels."
    })
    public int paxelMaxUses = DEFAULT.getPaxelMaxUses();

    @Getter
    @Path(SteelMaterialDefaults.name + "HarvestLevel")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Harvest level of " + SteelMaterialDefaults.name + " tools."
    })
    public int miningLevel = DEFAULT.getMiningLevel();

    @Getter
    @Path(SteelMaterialDefaults.name + "Enchantability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Natural enchantability factor of " + SteelMaterialDefaults.name + " items."
    })
    public int enchantability = DEFAULT.getEnchantability();

    @Getter
    @Path(SteelMaterialDefaults.name + "Toughness")
    @ConfigEntry.Gui.Tooltip
    @SpecFloatInRange(min = 0.0F, max = Float.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Base armor toughness value of " + SteelMaterialDefaults.name + " armor."
    })
    public float toughness = DEFAULT.getToughness();

    @Getter
    @Path(SteelMaterialDefaults.name + "KnockbackResistance")
    @ConfigEntry.Gui.Tooltip
    @SpecFloatInRange(min = 0.0F, max = Float.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Base armor knockback resistance value of " + SteelMaterialDefaults.name + " armor."
    })
    public float knockbackResistance = DEFAULT.getKnockbackResistance();

    @Getter
    @Path(SteelMaterialDefaults.name + "BootDurability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + SteelMaterialDefaults.name + " boots."
    })
    public int bootDurability = DEFAULT.getDurability(EquipmentSlot.FEET);

    @Getter
    @Path(SteelMaterialDefaults.name + "LeggingDurability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + SteelMaterialDefaults.name + " leggings."
    })
    public int leggingDurability = DEFAULT.getDurability(EquipmentSlot.LEGS);

    @Getter
    @Path(SteelMaterialDefaults.name + "ChestplateDurability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + SteelMaterialDefaults.name + " chestplates."
    })
    public int chestplateDurability = DEFAULT.getDurability(EquipmentSlot.CHEST);

    @Getter
    @Path(SteelMaterialDefaults.name + "HelmetDurability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + SteelMaterialDefaults.name + " helmets."
    })
    public int helmetDurability = DEFAULT.getDurability(EquipmentSlot.HEAD);

    @Getter
    @Path(SteelMaterialDefaults.name + "BootArmor")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Protection value of " + SteelMaterialDefaults.name + " boots."
    })
    public int bootArmor = DEFAULT.getProtectionAmount(EquipmentSlot.FEET);

    @Getter
    @Path(SteelMaterialDefaults.name + "LeggingArmor")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Protection value of " + SteelMaterialDefaults.name + " leggings."
    })
    public int leggingArmor = DEFAULT.getProtectionAmount(EquipmentSlot.LEGS);

    @Getter
    @Path(SteelMaterialDefaults.name + "ChestplateArmor")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Protection value of " + SteelMaterialDefaults.name + " chestplates."
    })
    public int chestplateArmor = DEFAULT.getProtectionAmount(EquipmentSlot.CHEST);

    @Getter
    @Path(SteelMaterialDefaults.name + "HelmetArmor")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Protection value of " + SteelMaterialDefaults.name + " helmets."
    })
    public int helmetArmor = DEFAULT.getProtectionAmount(EquipmentSlot.HEAD);

    protected Steel() { super(new SteelMaterialDefaults()); }

}
