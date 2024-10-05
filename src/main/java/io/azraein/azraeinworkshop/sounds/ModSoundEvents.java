package io.azraein.azraeinworkshop.sounds;

import io.azraein.azraeinworkshop.AzraeinWorkshop;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModSoundEvents {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister
            .create(BuiltInRegistries.SOUND_EVENT, AzraeinWorkshop.MOD_ID);

    public static final DeferredHolder<SoundEvent, SoundEvent> SMASHING_ROCK_GOURD_SMASH = registerSound("gourd_smash");

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }

    private static DeferredHolder<SoundEvent, SoundEvent> registerSound(String soundName) {
        return SOUND_EVENTS.register(soundName, () -> SoundEvent
                .createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(AzraeinWorkshop.MOD_ID, soundName)));
    }

}
