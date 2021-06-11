package mekanism.tools.config.tools;

import com.electronwill.nightconfig.core.conversion.Path;
import com.electronwill.nightconfig.core.conversion.SpecFloatInRange;
import com.electronwill.nightconfig.core.conversion.SpecIntInRange;
import lombok.Getter;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import mekanism.config.TOMLConfigSerializer;
import mekanism.tools.materials.RefinedGlowstoneMaterialDefaults;
import net.minecraft.entity.EquipmentSlot;

public class RefinedGlowstone extends AbstractMaterialConfig implements ConfigData {

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "AttackDamage")
    @ConfigEntry.Gui.Tooltip
    @SpecFloatInRange(min = 0.0F, max = Float.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Base attack damage of " + RefinedGlowstoneMaterialDefaults.name + " items."
    })
    public float attackDamage = DEFAULT.getAttackDamage();

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "ShieldDurability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + RefinedGlowstoneMaterialDefaults.name + " shields."
    })
    public int shieldDurability = DEFAULT.getShieldDurability();

    @Path(RefinedGlowstoneMaterialDefaults.name + "SwordDamage")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack damage modifier of " + RefinedGlowstoneMaterialDefaults.name + " swords."
    })
    public float swordDamage = DEFAULT.getSwordDamage();

    @Path(RefinedGlowstoneMaterialDefaults.name + "SwordAtkSpeed")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack speed of " + RefinedGlowstoneMaterialDefaults.name + " swords."
    })
    public float swordAtkSpeed = DEFAULT.getSwordAtkSpeed();

    @Path(RefinedGlowstoneMaterialDefaults.name + "ShovelDamage")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack damage modifier of " + RefinedGlowstoneMaterialDefaults.name + " shovels."
    })
    public float shovelDamage = DEFAULT.getShovelDamage();

    @Path(RefinedGlowstoneMaterialDefaults.name + "ShovelAtkSpeed")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack speed of " + RefinedGlowstoneMaterialDefaults.name + " shovels."
    })
    public float shovelAtkSpeed = DEFAULT.getShovelAtkSpeed();

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "AxeDamage")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack damage modifier of " + RefinedGlowstoneMaterialDefaults.name + " axes."
    })
    public float axeDamage = DEFAULT.getAxeDamage();

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "AxeAtkSpeed")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack speed of " + RefinedGlowstoneMaterialDefaults.name + " axes."
    })
    public float axeAtkSpeed = DEFAULT.getAxeAtkSpeed();

    @Path(RefinedGlowstoneMaterialDefaults.name + "PickaxeDamage")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack damage modifier of " + RefinedGlowstoneMaterialDefaults.name + " pickaxes."
    })
    public float pickaxeDamage = DEFAULT.getPickaxeDamage();

    @Path(RefinedGlowstoneMaterialDefaults.name + "PickaxeAtkSpeed")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack speed of " + RefinedGlowstoneMaterialDefaults.name + " pickaxes."
    })
    public float pickaxeAtkSpeed = DEFAULT.getPickaxeAtkSpeed();

    @Path(RefinedGlowstoneMaterialDefaults.name + "HoeDamage")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack damage modifier of " + RefinedGlowstoneMaterialDefaults.name + " hoes."
    })
    public float hoeDamage = DEFAULT.getPickaxeAtkSpeed();

    @Path(RefinedGlowstoneMaterialDefaults.name + "HoeAtkSpeed")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack speed of " + RefinedGlowstoneMaterialDefaults.name + " hoes."
    })
    public float hoeAtkSpeed = DEFAULT.getHoeAtkSpeed();

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "ToolMaxUses")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + RefinedGlowstoneMaterialDefaults.name + " tools."
    })
    public int durability = DEFAULT.getDurability();

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "Efficiency")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Efficiency of " + RefinedGlowstoneMaterialDefaults.name + " tools."
    })
    public float miningSpeedMultiplier = DEFAULT.getMiningSpeedMultiplier();

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "PaxelHarvestLevel")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Harvest level of " + RefinedGlowstoneMaterialDefaults.name + " paxels."
    })
    public int paxelHarvestLevel = DEFAULT.getPaxelHarvestLevel();

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "PaxelDamage")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack damage modifier of " + RefinedGlowstoneMaterialDefaults.name + " paxels."
    })
    public float paxelDamage = DEFAULT.getPaxelDamage();

    @Path(RefinedGlowstoneMaterialDefaults.name + "PaxelAtkSpeed")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Attack speed of " + RefinedGlowstoneMaterialDefaults.name + " paxels."
    })
    public float paxelAtkSpeed = DEFAULT.getPaxelAtkSpeed();

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "PaxelEfficiency")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Efficiency of " + RefinedGlowstoneMaterialDefaults.name + " paxels."
    })
    public float paxelEfficiency = DEFAULT.getPaxelEfficiency();

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "PaxelEnchantability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Natural enchantability factor of " + RefinedGlowstoneMaterialDefaults.name + " paxels."
    })
    public int paxelEnchantability = DEFAULT.getPaxelEnchantability();

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "PaxelMaxUses")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + RefinedGlowstoneMaterialDefaults.name + " paxels."
    })
    public int paxelMaxUses = DEFAULT.getPaxelMaxUses();

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "HarvestLevel")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Harvest level of " + RefinedGlowstoneMaterialDefaults.name + " tools."
    })
    public int miningLevel = DEFAULT.getMiningLevel();

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "Enchantability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Natural enchantability factor of " + RefinedGlowstoneMaterialDefaults.name + " items."
    })
    public int enchantability = DEFAULT.getEnchantability();

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "Toughness")
    @ConfigEntry.Gui.Tooltip
    @SpecFloatInRange(min = 0.0F, max = Float.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Base armor toughness value of " + RefinedGlowstoneMaterialDefaults.name + " armor."
    })
    public float toughness = DEFAULT.getToughness();

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "KnockbackResistance")
    @ConfigEntry.Gui.Tooltip
    @SpecFloatInRange(min = 0.0F, max = Float.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Base armor knockback resistance value of " + RefinedGlowstoneMaterialDefaults.name + " armor."
    })
    public float knockbackResistance = DEFAULT.getKnockbackResistance();

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "BootDurability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + RefinedGlowstoneMaterialDefaults.name + " boots."
    })
    public int bootDurability = DEFAULT.getDurability(EquipmentSlot.FEET);

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "LeggingDurability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + RefinedGlowstoneMaterialDefaults.name + " leggings."
    })
    public int leggingDurability = DEFAULT.getDurability(EquipmentSlot.LEGS);

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "ChestplateDurability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + RefinedGlowstoneMaterialDefaults.name + " chestplates."
    })
    public int chestplateDurability = DEFAULT.getDurability(EquipmentSlot.CHEST);

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "HelmetDurability")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Maximum durability of " + RefinedGlowstoneMaterialDefaults.name + " helmets."
    })
    public int helmetDurability = DEFAULT.getDurability(EquipmentSlot.HEAD);

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "BootArmor")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Protection value of " + RefinedGlowstoneMaterialDefaults.name + " boots."
    })
    public int bootArmor = DEFAULT.getProtectionAmount(EquipmentSlot.FEET);

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "LeggingArmor")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Protection value of " + RefinedGlowstoneMaterialDefaults.name + " leggings."
    })
    public int leggingArmor = DEFAULT.getProtectionAmount(EquipmentSlot.LEGS);

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "ChestplateArmor")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Protection value of " + RefinedGlowstoneMaterialDefaults.name + " chestplates."
    })
    public int chestplateArmor = DEFAULT.getProtectionAmount(EquipmentSlot.CHEST);

    @Getter
    @Path(RefinedGlowstoneMaterialDefaults.name + "HelmetArmor")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Protection value of " + RefinedGlowstoneMaterialDefaults.name + " helmets."
    })
    public int helmetArmor = DEFAULT.getProtectionAmount(EquipmentSlot.HEAD);

    protected RefinedGlowstone() { super(new RefinedGlowstoneMaterialDefaults()); }

}
