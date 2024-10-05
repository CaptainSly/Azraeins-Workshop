package io.azraein.azraeinworkshop.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import io.azraein.azraeinworkshop.AzraeinWorkshop;
import io.azraein.azraeinworkshop.block.ModBlocks;
import io.azraein.azraeinworkshop.item.ModItems;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

        List<ItemLike> PEACOCK_GEM_SMELTABLES = List.of(ModItems.RAW_PEACOCK_CHUNK,
                        ModBlocks.PEACOCK_ORE, ModBlocks.DEEPSLATE_PEACOCK_ORE);

        List<ItemLike> FIRE_METAL_INGOT_SMETABLES = List.of(ModItems.RAW_FIRE_METAL_CHUNK,
                        ModBlocks.DEEPSLATE_FIRE_METAL_ORE, ModBlocks.FIRE_METAL_ORE);

        List<ItemLike> GOURD_SMELTABLES = List.of(ModItems.GOURD);

        public ModRecipeProvider(PackOutput output, CompletableFuture<Provider> registries) {
                super(output, registries);
        }

        @Override
        protected void buildRecipes(RecipeOutput recipeOutput) {

                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SMASHING_ROCK.get())
                                .pattern("   ")
                                .pattern("SSS")
                                .pattern("CCC")
                                .define('S', Blocks.STONE_SLAB)
                                .define('C', Blocks.COBBLESTONE)
                                .unlockedBy("has_stone_slab", has(Blocks.STONE_SLAB))
                                .save(recipeOutput);

                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.XYLOTH_STAFF.get())
                                .pattern("SB ")
                                .pattern("BT ")
                                .pattern("  T")
                                .define('B', ModItems.BAKED_GOURD)
                                .define('S', Items.STRING)
                                .define('T', Items.STICK)
                                .unlockedBy("has_baked_gourd", has(ModItems.BAKED_GOURD))
                                .save(recipeOutput);

                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WORKSHOP_MANUAL.get(), 1)
                                .requires(ModItems.GOURD)
                                .requires(Items.BOOK)
                                .unlockedBy("has_gourd", has(ModItems.GOURD))
                                .save(recipeOutput);

                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PEACOCK_GEM.get(), 9)
                                .requires(ModBlocks.PEACOCK_BLOCK)
                                .unlockedBy("has_peacock_block", has(ModBlocks.PEACOCK_BLOCK))
                                .save(recipeOutput);

                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FIRE_METAL_NUGGET.get(), 9)
                                .requires(ModItems.FIRE_METAL_INGOT)
                                .unlockedBy("has_fire_metal_ingot", has(ModItems.FIRE_METAL_INGOT))
                                .save(recipeOutput);

                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FIRE_METAL_INGOT.get(), 9)
                                .requires(ModBlocks.FIRE_METAL_BLOCK)
                                .unlockedBy("has_peacock_block", has(ModBlocks.FIRE_METAL_BLOCK))
                                .save(recipeOutput, AzraeinWorkshop.MOD_ID + ":" + "fire_metal_block_to_ingots");

                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_FIRE_METAL_CHUNK.get(), 9)
                                .requires(ModBlocks.RAW_FIRE_METAL_BLOCK)
                                .unlockedBy("has_raw_fire_metal_block", has(ModBlocks.RAW_FIRE_METAL_BLOCK))
                                .save(recipeOutput);

                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_PEACOCK_CHUNK.get(), 9)
                                .requires(ModBlocks.RAW_PEACOCK_BLOCK)
                                .unlockedBy("has_raw_peacock_block", has(ModBlocks.RAW_PEACOCK_BLOCK))
                                .save(recipeOutput);

                fullBlockRecipe(recipeOutput, ModBlocks.PEACOCK_BLOCK, Ingredient.of(ModItems.PEACOCK_GEM),
                                "has_peacock_gem", ModItems.PEACOCK_GEM.get());

                fullBlockRecipe(recipeOutput, ModBlocks.FIRE_METAL_BLOCK, Ingredient.of(ModItems.FIRE_METAL_INGOT),
                                "has_fire_metal_ingot", ModItems.FIRE_METAL_INGOT.get());

                fullBlockRecipe(recipeOutput, ModBlocks.RAW_PEACOCK_BLOCK, Ingredient.of(ModItems.RAW_PEACOCK_CHUNK),
                                "has_raw_peacock_chunk", ModItems.RAW_PEACOCK_CHUNK.get());

                fullBlockRecipe(recipeOutput, ModItems.FIRE_METAL_INGOT, Ingredient.of(ModItems.FIRE_METAL_NUGGET),
                                "has_fire_metal_ingot", ModItems.FIRE_METAL_INGOT.get());

                fullBlockRecipe(recipeOutput, ModBlocks.RAW_FIRE_METAL_BLOCK,
                                Ingredient.of(ModItems.RAW_FIRE_METAL_CHUNK), "has_raw_fire_metal_chunk",
                                ModItems.RAW_FIRE_METAL_CHUNK.get());

                oreSmelting(recipeOutput, PEACOCK_GEM_SMELTABLES, RecipeCategory.MISC, ModItems.PEACOCK_GEM.get(),
                                0.25f, 200,
                                "peacock_gem");

                oreSmelting(recipeOutput, FIRE_METAL_INGOT_SMETABLES, RecipeCategory.MISC,
                                ModItems.FIRE_METAL_INGOT.get(), 0.52f, 150, "fire_metal_ingot");

                oreSmelting(recipeOutput, GOURD_SMELTABLES, RecipeCategory.FOOD, ModItems.BAKED_GOURD.get(), 0.35f, 350,
                                "baked_gourd");

                oreBlasting(recipeOutput, PEACOCK_GEM_SMELTABLES, RecipeCategory.MISC, ModItems.PEACOCK_GEM.get(),
                                0.25f, 100,
                                "peacock_gem");

                oreBlasting(recipeOutput, FIRE_METAL_INGOT_SMETABLES, RecipeCategory.MISC,
                                ModItems.FIRE_METAL_INGOT.get(), 0.52f, 100, "fire_metal_ingot");

                knifeRecipe(ModItems.WOOD_KNIFE, ItemTags.LOGS, recipeOutput);
                knifeRecipe(ModItems.COBBLE_KNIFE, Blocks.COBBLESTONE, recipeOutput);
                knifeRecipe(ModItems.IRON_KNIFE, Items.IRON_INGOT, recipeOutput);
                knifeRecipe(ModItems.FIRE_METAL_KNIFE, ModItems.FIRE_METAL_INGOT, recipeOutput);
                knifeRecipe(ModItems.GOLD_KNIFE, Items.GOLD_INGOT, recipeOutput);
                knifeRecipe(ModItems.DIAMOND_KNIFE, Items.DIAMOND, recipeOutput);
                knifeRecipe(ModItems.PEACOCK_KNIFE, ModItems.PEACOCK_GEM, recipeOutput);
                knifeRecipe(ModItems.NETHERITE_KNIFE, Items.NETHERITE_INGOT, recipeOutput);

                swordRecipe(ModItems.FIRE_METAL_SWORD, ModItems.FIRE_METAL_INGOT, recipeOutput);
                shovelRecipe(ModItems.FIRE_METAL_SHOVEL, ModItems.FIRE_METAL_INGOT, recipeOutput);
                pickaxeRecipe(ModItems.FIRE_METAL_PICKAXE, ModItems.FIRE_METAL_INGOT, recipeOutput);
                axeRecipe(ModItems.FIRE_METAL_AXE, ModItems.FIRE_METAL_INGOT, recipeOutput);
                hoeRecipe(ModItems.FIRE_METAL_HOE, ModItems.FIRE_METAL_INGOT, recipeOutput);
        }

        protected static void fullBlockRecipe(RecipeOutput recipeOutput, DeferredItem<Item> itemToCreate,
                        Ingredient ingredients, String unlockString, Item unlockItem) {
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, itemToCreate.get())
                                .pattern("PPP")
                                .pattern("PPP")
                                .pattern("PPP")
                                .define('P', ingredients)
                                .unlockedBy(unlockString, has(unlockItem))
                                .save(recipeOutput);
        }

        protected static void fullBlockRecipe(RecipeOutput recipeOutput, DeferredBlock<Block> blockToCreate,
                        Ingredient ingredients, String unlockString, Item unlockItem) {
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, blockToCreate.get())
                                .pattern("PPP")
                                .pattern("PPP")
                                .pattern("PPP")
                                .define('P', ingredients)
                                .unlockedBy(unlockString, has(unlockItem))
                                .save(recipeOutput);
        }

        protected static void knifeRecipe(DeferredItem<Item> itemToCreate, ItemLike materialItem,
                        RecipeOutput recipeOutput) {
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, itemToCreate.get())
                                .pattern("MM ")
                                .pattern("MS ")
                                .pattern("  S")
                                .define('S', Items.STICK)
                                .define('M', materialItem)
                                .unlockedBy("has_material_item_stick",
                                                has(Items.STICK))
                                .save(recipeOutput);
        }

        protected static void knifeRecipe(DeferredItem<Item> itemToCreate, TagKey<Item> materialIngredient,
                        RecipeOutput recipeOutput) {
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, itemToCreate.get())
                                .pattern("MM ")
                                .pattern("MS ")
                                .pattern("  S")
                                .define('S', Items.STICK)
                                .define('M', materialIngredient)
                                .unlockedBy("has_material_item_stick", has(Items.STICK))
                                .save(recipeOutput);
        }

        protected static void swordRecipe(DeferredItem<SwordItem> itemToCreate, ItemLike materialItem,
                        RecipeOutput recipeOutput) {
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, itemToCreate.get())
                                .pattern(" M ")
                                .pattern(" M ")
                                .pattern(" S ")
                                .define('S', Items.STICK)
                                .define('M', materialItem)
                                .unlockedBy("has_material_item_stick",
                                                has(Items.STICK))
                                .save(recipeOutput);
        }

        protected static void shovelRecipe(DeferredItem<ShovelItem> itemToCreate, ItemLike materialItem,
                        RecipeOutput recipeOutput) {
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, itemToCreate.get())
                                .pattern(" M ")
                                .pattern(" S ")
                                .pattern(" S ")
                                .define('S', Items.STICK)
                                .define('M', materialItem)
                                .unlockedBy("has_material_item_stick",
                                                has(Items.STICK))
                                .save(recipeOutput);
        }

        protected static void pickaxeRecipe(DeferredItem<PickaxeItem> itemToCreate, ItemLike materialItem,
                        RecipeOutput recipeOutput) {
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, itemToCreate.get())
                                .pattern("MMM")
                                .pattern(" S ")
                                .pattern(" S ")
                                .define('S', Items.STICK)
                                .define('M', materialItem)
                                .unlockedBy("has_material_item_stick",
                                                has(Items.STICK))
                                .save(recipeOutput);
        }

        protected static void axeRecipe(DeferredItem<AxeItem> itemToCreate, ItemLike materialItem,
                        RecipeOutput recipeOutput) {
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, itemToCreate.get())
                                .pattern("MM ")
                                .pattern("MS ")
                                .pattern(" S ")
                                .define('S', Items.STICK)
                                .define('M', materialItem)
                                .unlockedBy("has_material_item_stick",
                                                has(Items.STICK))
                                .save(recipeOutput);
        }

        protected static void hoeRecipe(DeferredItem<HoeItem> itemToCreate, ItemLike materialItem,
                        RecipeOutput recipeOutput) {
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, itemToCreate.get())
                                .pattern("MM ")
                                .pattern(" S ")
                                .pattern(" S ")
                                .define('S', Items.STICK)
                                .define('M', materialItem)
                                .unlockedBy("has_material_item_stick",
                                                has(Items.STICK))
                                .save(recipeOutput);
        }

        protected static void oreSmelting(
                        RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category, ItemLike result,
                        float experience, int cookingTime, String group) {
                oreCooking(
                                recipeOutput,
                                RecipeSerializer.SMELTING_RECIPE,
                                SmeltingRecipe::new,
                                ingredients,
                                category,
                                result,
                                experience,
                                cookingTime,
                                group,
                                "_from_smelting");
        }

        protected static void oreBlasting(
                        RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category, ItemLike result,
                        float experience, int cookingTime, String group) {
                oreCooking(
                                recipeOutput,
                                RecipeSerializer.BLASTING_RECIPE,
                                BlastingRecipe::new,
                                ingredients,
                                category,
                                result,
                                experience,
                                cookingTime,
                                group,
                                "_from_blasting");
        }

        protected static <T extends AbstractCookingRecipe> void oreCooking(
                        RecipeOutput recipeOutput,
                        RecipeSerializer<T> serializer,
                        AbstractCookingRecipe.Factory<T> recipeFactory,
                        List<ItemLike> ingredients,
                        RecipeCategory category,
                        ItemLike result,
                        float experience,
                        int cookingTime,
                        String group,
                        String suffix) {
                for (ItemLike itemlike : ingredients) {
                        SimpleCookingRecipeBuilder
                                        .generic(Ingredient.of(itemlike), category, result, experience, cookingTime,
                                                        serializer,
                                                        recipeFactory)
                                        .group(group)
                                        .unlockedBy(getHasName(itemlike), has(itemlike))
                                        .save(recipeOutput,
                                                        AzraeinWorkshop.MOD_ID + ":" + getItemName(result) + suffix
                                                                        + "_"
                                                                        + getItemName(itemlike));
                }
        }

}
