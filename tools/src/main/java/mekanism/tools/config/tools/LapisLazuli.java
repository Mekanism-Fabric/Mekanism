package mekanism.tools.config.tools;

import com.electronwill.nightconfig.core.conversion.Path;
import com.electronwill.nightconfig.core.conversion.SpecFloatInRange;
import com.electronwill.nightconfig.core.conversion.SpecIntInRange;
import lombok.Getter;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import mekanism.config.TOMLConfigSerializer;
import mekanism.tools.materials.LapisLazuliMaterialDefaults;
import net.minecraft.entity.EquipmentSlot;

public class LapisLazuli extends AbstractMaterialConfig implements ConfigData {

    @Getter
    @Path(LapisLazuliMaterialDefaults.name + "AttackDamage")
    @ConfigEntry.Gui.Tooltip
    @SpecFloatInRange(min = 0.0F, max = Float.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Base attack damage of " + LapisLazuliMaterialDefaults.name + " items."
    })
    public float attackDamage = DEFAULT.getAttackDamage();

    @Getter
    @Path(LapisLazuliMaterialDefaults.name + "ShieldDurability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + LapisLazuliMaterialDefaults.name + " shields."
    })
    public int shieldDurability = DEFAULT.getShieldDurability();

    @Path(LapisLazuliMaterialDefaults.name + "SwordDamage")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack damage modifier of " + LapisLazuliMaterialDefaults.name + " swords."
    })
    public float swordDamage = DEFAULT.getSwordDamage();

    @Path(LapisLazuliMaterialDefaults.name + "SwordAtkSpeed")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack speed of " + LapisLazuliMaterialDefaults.name + " swords."
    })
    public float swordAtkSpeed = DEFAULT.getSwordAtkSpeed();

    @Path(LapisLazuliMaterialDefaults.name + "ShovelDamage")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack damage modifier of " + LapisLazuliMaterialDefaults.name + " shovels."
    })
    public float shovelDamage = DEFAULT.getShovelDamage();

    @Path(LapisLazuliMaterialDefaults.name + "ShovelAtkSpeed")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack speed of " + LapisLazuliMaterialDefaults.name + " shovels."
    })
    public float shovelAtkSpeed = DEFAULT.getShovelAtkSpeed();

    @Getter
    @Path(LapisLazuliMaterialDefaults.name + "AxeDamage")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack damage modifier of " + LapisLazuliMaterialDefaults.name + " axes."
    })
    public float axeDamage = DEFAULT.getAxeDamage();

    @Getter
    @Path(LapisLazuliMaterialDefaults.name + "AxeAtkSpeed")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack speed of " + LapisLazuliMaterialDefaults.name + " axes."
    })
    public float axeAtkSpeed = DEFAULT.getAxeAtkSpeed();

    @Path(LapisLazuliMaterialDefaults.name + "PickaxeDamage")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack damage modifier of " + LapisLazuliMaterialDefaults.name + " pickaxes."
    })
    public float pickaxeDamage = DEFAULT.getPickaxeDamage();

    @Path(LapisLazuliMaterialDefaults.name + "PickaxeAtkSpeed")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack speed of " + LapisLazuliMaterialDefaults.name + " pickaxes."
    })
    public float pickaxeAtkSpeed = DEFAULT.getPickaxeAtkSpeed();

    @Path(LapisLazuliMaterialDefaults.name + "HoeDamage")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack damage modifier of " + LapisLazuliMaterialDefaults.name + " hoes."
    })
    public float hoeDamage = DEFAULT.getPickaxeAtkSpeed();

    @Path(LapisLazuliMaterialDefaults.name + "HoeAtkSpeed")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack speed of " + LapisLazuliMaterialDefaults.name + " hoes."
    })
    public float hoeAtkSpeed = DEFAULT.getHoeAtkSpeed();

    @Getter
    @Path(LapisLazuliMaterialDefaults.name + "ToolMaxUses")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + LapisLazuliMaterialDefaults.name + " tools."
    })
    public int durability = DEFAULT.getDurability();

    @Getter
    @Path(LapisLazuliMaterialDefaults.name + "Efficiency")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Efficiency of " + LapisLazuliMaterialDefaults.name + " tools."
    })
    public float miningSpeedMultiplier = DEFAULT.getMiningSpeedMultiplier();

    @Getter
    @Path(LapisLazuliMaterialDefaults.name + "PaxelHarvestLevel")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Harvest level of " + LapisLazuliMaterialDefaults.name + " paxels."
    })
    public int paxelHarvestLevel = DEFAULT.getPaxelHarvestLevel();

    @Getter
    @Path(LapisLazuliMaterialDefaults.name + "PaxelDamage")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack damage modifier of " + LapisLazuliMaterialDefaults.name + " paxels."
    })
    public float paxelDamage = DEFAULT.getPaxelDamage();

    @Path(LapisLazuliMaterialDefaults.name + "PaxelAtkSpeed")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack speed of " + LapisLazuliMaterialDefaults.name + " paxels."
    })
    public float paxelAtkSpeed = DEFAULT.getPaxelAtkSpeed();

    @Getter
    @Path(LapisLazuliMaterialDefaults.name + "PaxelEfficiency")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Efficiency of " + LapisLazuliMaterialDefaults.name + " paxels."
    })
    public float paxelEfficiency = DEFAULT.getPaxelEfficiency();

    @Getter
    @Path(LapisLazuliMaterialDefaults.name + "PaxelEnchantability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Natural enchantability factor of " + LapisLazuliMaterialDefaults.name + " paxels."
    })
    public int paxelEnchantability = DEFAULT.getPaxelEnchantability();

    @Getter
    @Path(LapisLazuliMaterialDefaults.name + "PaxelMaxUses")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + LapisLazuliMaterialDefaults.name + " paxels."
    })
    public int paxelMaxUses = DEFAULT.getPaxelMaxUses();

    @Getter
    @Path(LapisLazuliMaterialDefaults.name + "HarvestLevel")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Harvest level of " + LapisLazuliMaterialDefaults.name + " tools."
    })
    public int miningLevel = DEFAULT.getMiningLevel();

    @Getter
    @Path(LapisLazuliMaterialDefaults.name + "Enchantability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Natural enchantability factor of " + LapisLazuliMaterialDefaults.name + " items."
    })
    public int enchantability = DEFAULT.getEnchantability();

    @Getter
    @Path(LapisLazuliMaterialDefaults.name + "Toughness")
    @ConfigEntry.Gui.Tooltip
    @SpecFloatInRange(min = 0.0F, max = Float.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Base armor toughness value of " + LapisLazuliMaterialDefaults.name + " armor."
    })
    public float toughness = DEFAULT.getToughness();

    @Getter
    @Path(LapisLazuliMaterialDefaults.name + "KnockbackResistance")
    @ConfigEntry.Gui.Tooltip
    @SpecFloatInRange(min = 0.0F, max = Float.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Base armor knockback resistance value of " + LapisLazuliMaterialDefaults.name + " armor."
    })
    public float knockbackResistance = DEFAULT.getKnockbackResistance();

    @Getter
    @Path(LapisLazuliMaterialDefaults.name + "BootDurability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + LapisLazuliMaterialDefaults.name + " boots."
    })
    public int bootDurability = DEFAULT.getDurability(EquipmentSlot.FEET);

    @Getter
    @Path(LapisLazuliMaterialDefaults.name + "LeggingDurability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + LapisLazuliMaterialDefaults.name + " leggings."
    })
    public int leggingDurability = DEFAULT.getDurability(EquipmentSlot.LEGS);

    @Getter
    @Path(LapisLazuliMaterialDefaults.name + "ChestplateDurability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + LapisLazuliMaterialDefaults.name + " chestplates."
    })
    public int chestplateDurability = DEFAULT.getDurability(EquipmentSlot.CHEST);

    @Getter
    @Path(LapisLazuliMaterialDefaults.name + "HelmetDurability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + LapisLazuliMaterialDefaults.name + " helmets."
    })
    public int helmetDurability = DEFAULT.getDurability(EquipmentSlot.HEAD);

    @Getter
    @Path(LapisLazuliMaterialDefaults.name + "BootArmor")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Protection value of " + LapisLazuliMaterialDefaults.name + " boots."
    })
    public int bootArmor = DEFAULT.getProtectionAmount(EquipmentSlot.FEET);

    @Getter
    @Path(LapisLazuliMaterialDefaults.name + "LeggingArmor")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Protection value of " + LapisLazuliMaterialDefaults.name + " leggings."
    })
    public int leggingArmor = DEFAULT.getProtectionAmount(EquipmentSlot.LEGS);

    @Getter
    @Path(LapisLazuliMaterialDefaults.name + "ChestplateArmor")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Protection value of " + LapisLazuliMaterialDefaults.name + " chestplates."
    })
    public int chestplateArmor = DEFAULT.getProtectionAmount(EquipmentSlot.CHEST);

    @Getter
    @Path(LapisLazuliMaterialDefaults.name + "HelmetArmor")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Protection value of " + LapisLazuliMaterialDefaults.name + " helmets."
    })
    public int helmetArmor = DEFAULT.getProtectionAmount(EquipmentSlot.HEAD);

    protected LapisLazuli() { super(new LapisLazuliMaterialDefaults()); }

}
