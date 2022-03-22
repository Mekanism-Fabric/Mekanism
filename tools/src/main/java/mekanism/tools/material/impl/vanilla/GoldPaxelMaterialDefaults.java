package mekanism.tools.material.impl.vanilla;

import mekanism.tools.material.VanillaPaxelMaterial;
import net.minecraft.item.ToolMaterials;
import org.jetbrains.annotations.NotNull;

public class GoldPaxelMaterialDefaults extends VanillaPaxelMaterial {

    @NotNull
    @Override
    public ToolMaterials getVanillaTier() {
        return ToolMaterials.GOLD;
    }

    @Override
    public float getPaxelDamage() {
        return 7;
    }

    @Override
    public String getConfigCommentName() {
        return "Gold";
    }
}