package io.azraein.azraeinworkshop.datagen;

import io.azraein.azraeinworkshop.AzraeinWorkshop;
import io.azraein.azraeinworkshop.sounds.ModSoundEvents;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinition.SoundType;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

public class ModSoundDefinitionsProvider extends SoundDefinitionsProvider {

    public ModSoundDefinitionsProvider(final PackOutput output, final ExistingFileHelper helper) {
        super(output, AzraeinWorkshop.MOD_ID, helper);
    }

    @Override
    public void registerSounds() {
        add(ModSoundEvents.SMASHING_ROCK_GOURD_SMASH,
                getDefinition("gourd_smash", SoundType.SOUND, false));


    }

    private SoundDefinition getDefinition(String soundName, SoundType soundType, float volume,
            float pitch, int weight,
            int attenuationDist,
            boolean stream, boolean preload, boolean replace) {
        return definition().with(sound(ResourceLocation.fromNamespaceAndPath(AzraeinWorkshop.MOD_ID, soundName), soundType)
                .volume(volume)
                .pitch(pitch)
                .weight(weight)
                .attenuationDistance(attenuationDist)
                .stream(stream)
                .preload(preload)).subtitle("sound." + AzraeinWorkshop.MOD_ID + "." + soundName).replace(replace);
    }

    private SoundDefinition getDefinition(String soundName, SoundType soundType, boolean stream) {
        return definition()
                .with(sound(ResourceLocation.fromNamespaceAndPath(AzraeinWorkshop.MOD_ID, soundName), soundType)
                        .stream(stream))
                .subtitle("sound." + AzraeinWorkshop.MOD_ID + "." + soundName);
    }

}
