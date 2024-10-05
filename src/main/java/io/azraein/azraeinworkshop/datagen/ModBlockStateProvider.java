package io.azraein.azraeinworkshop.datagen;

import io.azraein.azraeinworkshop.AzraeinWorkshop;
import io.azraein.azraeinworkshop.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper efh) {
        super(output, AzraeinWorkshop.MOD_ID, efh);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.DEEPSLATE_PEACOCK_ORE);
        blockWithItem(ModBlocks.PEACOCK_ORE);
        
        blockWithItem(ModBlocks.DEEPSLATE_FIRE_METAL_ORE);
        blockWithItem(ModBlocks.FIRE_METAL_ORE);

        blockWithItem(ModBlocks.PEACOCK_BLOCK);
        blockWithItem(ModBlocks.RAW_PEACOCK_BLOCK);
        blockWithItem(ModBlocks.FIRE_METAL_BLOCK);
        blockWithItem(ModBlocks.RAW_FIRE_METAL_BLOCK);

        slabBlock(ModBlocks.SMASHING_ROCK.get(), blockTexture(ModBlocks.SMASHING_ROCK.get()),
                blockTexture(ModBlocks.SMASHING_ROCK.get()));

        blockItem(ModBlocks.SMASHING_ROCK);

    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(),
                new ModelFile.UncheckedModelFile(AzraeinWorkshop.MOD_ID + ":block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile(
            AzraeinWorkshop.MOD_ID + ":block/" + deferredBlock.getId().getPath() + appendix));
    }

}
