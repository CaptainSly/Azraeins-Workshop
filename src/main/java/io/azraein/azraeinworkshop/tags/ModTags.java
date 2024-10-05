package io.azraein.azraeinworkshop.tags;

import io.azraein.azraeinworkshop.AzraeinWorkshop;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static class Blocks {

        public static final TagKey<Block> NEEDS_FIRE_METAL_TOOL = createTag("needs_fire_metal_tool");
        public static final TagKey<Block> INCORRECT_FOR_FIRE_METAL_TOOL = createTag("incorrect_for_fire_metal_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(AzraeinWorkshop.MOD_ID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> SMASHABLE_GOURD = createTag("smashable_gourd");

        // Tanning Rack Tags
        public static final TagKey<Item> TANNABLE = createTag("tannable");
        public static final TagKey<Item> TANNING_KNIFE = createTag("tanning_knife");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(AzraeinWorkshop.MOD_ID, name));
        }

    }

}
