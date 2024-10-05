package io.azraein.azraeinworkshop.datagen;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import io.azraein.azraeinworkshop.AzraeinWorkshop;
import io.azraein.azraeinworkshop.item.ModItems;
import io.azraein.azraeinworkshop.tags.ModTags;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(PackOutput output, CompletableFuture<Provider> lookupProvider,
            CompletableFuture<TagLookup<Block>> blockTags,
            @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, AzraeinWorkshop.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider) {

        // Minecraft Tags
        tag(ItemTags.SWORDS).add(ModItems.FIRE_METAL_SWORD.get());
        tag(ItemTags.PICKAXES).add(ModItems.FIRE_METAL_PICKAXE.get());
        tag(ItemTags.AXES).add(ModItems.FIRE_METAL_AXE.get());
        tag(ItemTags.SHOVELS).add(ModItems.FIRE_METAL_SHOVEL.get());
        tag(ItemTags.HOES).add(ModItems.FIRE_METAL_HOE.get());

        // Lion King Tags
        tag(ModTags.Items.SMASHABLE_GOURD)
                .add(ModItems.GOURD.get());

        // Hides and Pelts
        tag(ModTags.Items.TANNABLE).add(ModItems.ZEBRA_HIDE.get());

        // Knives
        tag(ModTags.Items.TANNING_KNIFE).add(ModItems.WOOD_KNIFE.get(), ModItems.COBBLE_KNIFE.get(),
                ModItems.IRON_KNIFE.get(), ModItems.FIRE_METAL_KNIFE.get(), ModItems.DIAMOND_KNIFE.get(),
                ModItems.GOLD_KNIFE.get(),
                ModItems.PEACOCK_KNIFE.get(), ModItems.NETHERITE_KNIFE.get());

    }

}
