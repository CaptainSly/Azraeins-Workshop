package io.azraein.azraeinworkshop.datagen;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import io.azraein.azraeinworkshop.AzraeinWorkshop;
import net.minecraft.Util;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModMusicProvider extends DatapackBuiltinEntriesProvider {

    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(Registries.JUKEBOX_SONG,
            ModMusicProvider::bootstrap);

    public static void bootstrap(BootstrapContext<JukeboxSong> ctx) {
    }

    public static void register(
            BootstrapContext<JukeboxSong> ctx, ResourceKey<JukeboxSong> key, JukeboxSong song) {
        ctx.register(key, song);

    }

    public static void register(
            BootstrapContext<JukeboxSong> context, ResourceKey<JukeboxSong> resourceKey,
            DeferredHolder<SoundEvent, SoundEvent> soundEvent,
            float songLengthInSeconds, int comparatorOutput) {
        context.register(
                resourceKey,
                new JukeboxSong(soundEvent,
                        Component.translatable(Util.makeDescriptionId("jukebox_song", resourceKey.location())),
                        (float) songLengthInSeconds, comparatorOutput));

    }

    public ModMusicProvider(PackOutput output, CompletableFuture<Provider> registries) {
        super(output, registries, BUILDER, Set.of(AzraeinWorkshop.MOD_ID));
    }

}
