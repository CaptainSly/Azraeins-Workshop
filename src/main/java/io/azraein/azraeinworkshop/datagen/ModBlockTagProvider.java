package io.azraein.azraeinworkshop.datagen;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import io.azraein.azraeinworkshop.AzraeinWorkshop;
import io.azraein.azraeinworkshop.block.ModBlocks;
import io.azraein.azraeinworkshop.tags.ModTags;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockTagProvider extends BlockTagsProvider {

        public ModBlockTagProvider(PackOutput output, CompletableFuture<Provider> lookupProvider,
                        @Nullable ExistingFileHelper existingFileHelper) {
                super(output, lookupProvider, AzraeinWorkshop.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(Provider provider) {
                tag(BlockTags.MINEABLE_WITH_PICKAXE)
                                .add(ModBlocks.SMASHING_ROCK.get())
                                .add(ModBlocks.DEEPSLATE_PEACOCK_ORE.get())
                                .add(ModBlocks.PEACOCK_BLOCK.get())
                                .add(ModBlocks.PEACOCK_ORE.get())
                                .add(ModBlocks.RAW_PEACOCK_BLOCK.get())
                                .add(ModBlocks.DEEPSLATE_FIRE_METAL_ORE.get())
                                .add(ModBlocks.FIRE_METAL_ORE.get())
                                .add(ModBlocks.RAW_FIRE_METAL_BLOCK.get())
                                .add(ModBlocks.FIRE_METAL_BLOCK.get());

                tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.SMASHING_ROCK.get())
                                .add(ModBlocks.DEEPSLATE_FIRE_METAL_ORE.get())
                                .add(ModBlocks.FIRE_METAL_ORE.get())
                                .add(ModBlocks.RAW_FIRE_METAL_BLOCK.get())
                                .add(ModBlocks.FIRE_METAL_BLOCK.get());

                tag(BlockTags.NEEDS_IRON_TOOL)
                                .add(ModBlocks.DEEPSLATE_PEACOCK_ORE.get())
                                .add(ModBlocks.PEACOCK_BLOCK.get())
                                .add(ModBlocks.PEACOCK_ORE.get())
                                .add(ModBlocks.RAW_PEACOCK_BLOCK.get());

                tag(ModTags.Blocks.NEEDS_FIRE_METAL_TOOL).addTag(BlockTags.NEEDS_IRON_TOOL);
                tag(ModTags.Blocks.INCORRECT_FOR_FIRE_METAL_TOOL).addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                                .remove(ModTags.Blocks.NEEDS_FIRE_METAL_TOOL);

        }

}
