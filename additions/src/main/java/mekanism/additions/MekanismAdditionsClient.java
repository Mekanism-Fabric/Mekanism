package mekanism.additions;

import mekanism.additions.registries.AdditionsEntityRenderers;
import net.fabricmc.api.ClientModInitializer;

public class MekanismAdditionsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        AdditionsEntityRenderers.init();
    }

}
