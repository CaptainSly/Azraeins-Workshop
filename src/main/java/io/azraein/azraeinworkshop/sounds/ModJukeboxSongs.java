package io.azraein.azraeinworkshop.sounds;

import io.azraein.azraeinworkshop.AzraeinWorkshop;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.JukeboxSong;

public class ModJukeboxSongs {


    private static ResourceKey<JukeboxSong> createSong(String songId) {
        return ResourceKey.create(Registries.JUKEBOX_SONG,
                ResourceLocation.fromNamespaceAndPath(AzraeinWorkshop.MOD_ID, songId));
    }

}
