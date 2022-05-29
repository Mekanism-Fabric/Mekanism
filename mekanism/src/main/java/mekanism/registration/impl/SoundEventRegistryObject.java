package mekanism.registration.impl;

import mekanism.api.text.ILangEntry;
import mekanism.registration.WrappedRegistryObject;
import net.minecraft.Util;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class SoundEventRegistryObject<SOUND extends SoundEvent> extends WrappedRegistryObject<SOUND> implements ILangEntry {

    private final String translationKey;

    public SoundEventRegistryObject(ResourceLocation identifier, SOUND registryObject) {
        super(identifier, registryObject);
        translationKey = Util.makeDescriptionId("sound_event", this.registryObject.getLocation());
    }

    @Override
    public String getTranslationKey() {
        return translationKey;
    }
}