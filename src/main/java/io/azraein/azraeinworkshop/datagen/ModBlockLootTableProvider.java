package io.azraein.azraeinworkshop.datagen;

import java.util.Set;

import io.azraein.azraeinworkshop.block.ModBlocks;
import io.azraein.azraeinworkshop.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class ModBlockLootTableProvider extends BlockLootSubProvider {

        protected ModBlockLootTableProvider(Provider registries) {
                super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
        }

        @Override
        protected void generate() {
                dropSelf(ModBlocks.PEACOCK_BLOCK.get());
                dropSelf(ModBlocks.FIRE_METAL_BLOCK.get());
                dropSelf(ModBlocks.RAW_FIRE_METAL_BLOCK.get());
                dropSelf(ModBlocks.SMASHING_ROCK.get());

                add(ModBlocks.SMASHING_ROCK.get(), block -> createSlabItemTable(ModBlocks.SMASHING_ROCK.get()));

                addMultiOreDrop(ModBlocks.PEACOCK_ORE.get(), ModItems.PEACOCK_GEM.get(), 1, 2);
                addMultiOreDrop(ModBlocks.DEEPSLATE_PEACOCK_ORE.get(), ModItems.PEACOCK_GEM.get(), 1, 2);


                addMultiOreDrop(ModBlocks.FIRE_METAL_ORE.get(), ModItems.RAW_FIRE_METAL_CHUNK.get(), 1, 4);
                addMultiOreDrop(ModBlocks.DEEPSLATE_FIRE_METAL_ORE.get(), ModItems.RAW_FIRE_METAL_CHUNK.get(), 1, 4);

        }

        private void addOreDrop(Block ore, Item drop) {
                add(ore, block -> createOreDrop(ore, drop));
        }

        private void addMultiOreDrop(Block ore, Item drop, float minDrops, float maxDrops) {
                add(ore, block -> createMultipleOreDrops(ore, drop, minDrops, maxDrops));
        }

        private LootTable.Builder createMultipleOreDrops(Block block, Item item, float minDrops, float maxDrops) {
                HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries
                                .lookupOrThrow(Registries.ENCHANTMENT);
                return this.createSilkTouchDispatchTable(
                                block,
                                (LootPoolEntryContainer.Builder<?>) this.applyExplosionDecay(
                                                block,
                                                LootItem.lootTableItem(item)
                                                                .apply(SetItemCountFunction.setCount(UniformGenerator
                                                                                .between(minDrops, maxDrops)))
                                                                .apply(ApplyBonusCount
                                                                                .addOreBonusCount(registrylookup
                                                                                                .getOrThrow(Enchantments.FORTUNE)))));
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
                return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
        }

}
