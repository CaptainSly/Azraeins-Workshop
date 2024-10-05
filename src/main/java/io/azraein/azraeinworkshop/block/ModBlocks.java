package io.azraein.azraeinworkshop.block;

import java.util.function.Supplier;

import io.azraein.azraeinworkshop.AzraeinWorkshop;
import io.azraein.azraeinworkshop.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

// TODO: Clean up the code a bit, create helper methods for common block types

public class ModBlocks {

        public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(AzraeinWorkshop.MOD_ID);

        public static final DeferredBlock<Block> PEACOCK_ORE = createOre("peacock_ore", 2, 4, 2, SoundType.STONE);

        public static final DeferredBlock<Block> DEEPSLATE_PEACOCK_ORE = registerBlock("deepslate_peacock_ore",
                        () -> new DropExperienceBlock(UniformInt.of(2, 4),
                                        BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()
                                                        .sound(SoundType.STONE)));

        public static final DeferredBlock<Block> FIRE_METAL_ORE = registerBlock("fire_metal_ore",
                        () -> new DropExperienceBlock(UniformInt.of(2, 4),
                                        BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()
                                                        .sound(SoundType.STONE)));

        public static final DeferredBlock<Block> DEEPSLATE_FIRE_METAL_ORE = registerBlock("deepslate_fire_metal_ore",
                        () -> new DropExperienceBlock(UniformInt.of(2, 4),
                                        BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()
                                                        .sound(SoundType.STONE)));

        public static final DeferredBlock<Block> PEACOCK_BLOCK = registerBlock("peacock_block",
                        () -> new PeacockBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()
                                        .sound(SoundType.AMETHYST)));

        public static final DeferredBlock<Block> FIRE_METAL_BLOCK = registerBlock("fire_metal_block",
                        () -> new Block(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()
                                        .sound(SoundType.STONE)));

        public static final DeferredBlock<Block> RAW_FIRE_METAL_BLOCK = registerBlock("raw_fire_metal_block",
                        () -> new Block(
                                        BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()
                                                        .sound(SoundType.STONE)));

        public static final DeferredBlock<Block> RAW_PEACOCK_BLOCK = registerBlock("raw_peacock_block",
                        () -> new Block(
                                        BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()
                                                        .sound(SoundType.STONE)));

        public static final DeferredBlock<SlabBlock> SMASHING_ROCK = registerBlock("smashing_rock",
                        () -> new SmashingRockBlock(
                                        BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()
                                                        .sound(SoundType.STONE)));

        private static DeferredBlock<Block> createOre(String oreId, int minExpDrop, int maxExpDrop, float strength,
                        SoundType soundType) {
                return registerBlock(oreId, () -> new DropExperienceBlock(UniformInt.of(minExpDrop, maxExpDrop),
                                BlockBehaviour.Properties.of().strength(strength)
                                                .requiresCorrectToolForDrops()
                                                .sound(soundType)));
        }

        private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
                DeferredBlock<T> retBlock = BLOCKS.register(name, block);
                registerBlockItem(name, retBlock);
                return retBlock;
        }

        private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
                ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        }

        public static void register(IEventBus eventBus) {
                BLOCKS.register(eventBus);
        }

}
