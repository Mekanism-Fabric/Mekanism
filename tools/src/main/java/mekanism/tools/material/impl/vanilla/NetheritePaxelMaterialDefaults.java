package mekanism.tools.material.impl.vanilla;

import mekanism.tools.material.VanillaPaxelMaterial;
import net.minecraft.item.ToolMaterials;
import org.jetbrains.annotations.NotNull;

public class NetheritePaxelMaterialDefaults extends VanillaPaxelMaterial {

    @NotNull
    @Override
    public ToolMaterials getVanillaTier() {
        return ToolMaterials.NETHERITE;
    }

    @Override
    public float getPaxelDamage() {
        return 6;
    }

    @Override
    public String getConfigCommentName() {
        return "Netherite";
    }
}