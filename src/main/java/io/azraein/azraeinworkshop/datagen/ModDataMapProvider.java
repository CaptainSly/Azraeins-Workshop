package io.azraein.azraeinworkshop.datagen;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;

public class ModDataMapProvider extends DataMapProvider {

    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {
        /*
         * this.builder(NeoForgeDataMaps.DATAMAP)
         */
    }

}
