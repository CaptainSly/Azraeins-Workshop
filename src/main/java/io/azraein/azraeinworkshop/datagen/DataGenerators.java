package io.azraein.azraeinworkshop.datagen;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import io.azraein.azraeinworkshop.AzraeinWorkshop;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = AzraeinWorkshop.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput packOut = gen.getPackOutput();
        ExistingFileHelper efh = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        gen.addProvider(event.includeServer(), new LootTableProvider(packOut, Collections.emptySet(), List
                .of(new LootTableProvider.SubProviderEntry(ModBlockLootTableProvider::new, LootContextParamSets.BLOCK)),
                lookupProvider));

        gen.addProvider(event.includeServer(), new ModRecipeProvider(packOut, lookupProvider));

        BlockTagsProvider blockTagsProvider = new ModBlockTagProvider(packOut, lookupProvider, efh);
        gen.addProvider(event.includeServer(), blockTagsProvider);
        gen.addProvider(event.includeServer(),
                new ModItemTagProvider(packOut, lookupProvider, blockTagsProvider.contentsGetter(), efh));

        gen.addProvider(event.includeServer(), new ModMusicProvider(packOut, lookupProvider));
        gen.addProvider(event.includeServer(), new ModDataMapProvider(packOut, lookupProvider));

        gen.addProvider(event.includeClient(), new ModItemModelProvider(packOut, efh));
        gen.addProvider(event.includeClient(), new ModBlockStateProvider(packOut, efh));
        gen.addProvider(event.includeClient(), new ModSoundDefinitionsProvider(packOut, efh));
        gen.addProvider(event.includeClient(), new ModParticleDescriptionProvider(packOut, efh));
    }

}
