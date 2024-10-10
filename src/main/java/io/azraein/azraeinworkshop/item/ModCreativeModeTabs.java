package io.azraein.azraeinworkshop.item;

import java.util.function.Supplier;

import io.azraein.azraeinworkshop.AzraeinWorkshop;
import io.azraein.azraeinworkshop.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
            AzraeinWorkshop.MOD_ID);

    public static final Supplier<CreativeModeTab> AZRAEIN_WORKSHOP_ITEM_TAB = TABS.register("items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.BLUE_FEATHER.get()))
                    .title(Component.translatable("creativetab." + AzraeinWorkshop.MOD_ID + ".items_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.RED_FEATHER);
                        output.accept(ModItems.PURPLE_FEATHER);
                        output.accept(ModItems.YELLOW_FEATHER);
                        output.accept(ModItems.BLUE_FEATHER);
                        output.accept(ModItems.GREEN_FEATHER);

                        output.accept(ModItems.PEACOCK_GEM);
                        output.accept(ModItems.RAW_FIRE_METAL_CHUNK);
                        output.accept(ModItems.FIRE_METAL_INGOT);
                        output.accept(ModItems.FIRE_METAL_NUGGET);

                        output.accept(ModItems.XYLOTH_STAFF);

                        output.accept(ModItems.BAOBAB_FRUIT);
                        output.accept(ModItems.BAKED_GOURD);
                        output.accept(ModItems.SMASHED_GOURD);
                        output.accept(ModItems.GOURD);

                        output.accept(ModItems.WORKSHOP_MANUAL);

                        output.accept(ModItems.ZEBRA_HIDE);

                        output.accept(ModItems.WOOD_KNIFE);
                        output.accept(ModItems.COBBLE_KNIFE);
                        output.accept(ModItems.IRON_KNIFE);
                        output.accept(ModItems.FIRE_METAL_KNIFE);
                        output.accept(ModItems.GOLD_KNIFE);
                        output.accept(ModItems.DIAMOND_KNIFE);
                        output.accept(ModItems.PEACOCK_KNIFE);
                        output.accept(ModItems.NETHERITE_KNIFE);

                        output.accept(ModItems.FIRE_METAL_SWORD);
                        output.accept(ModItems.FIRE_METAL_SHOVEL);
                        output.accept(ModItems.FIRE_METAL_PICKAXE);
                        output.accept(ModItems.FIRE_METAL_HOE);
                        output.accept(ModItems.FIRE_METAL_HAMMER);

                        output.accept(ModItems.FIRE_METAL_HELMET);
                        output.accept(ModItems.FIRE_METAL_CHESTPLATE);
                        output.accept(ModItems.FIRE_METAL_LEGGINGS);
                        output.accept(ModItems.FIRE_METAL_BOOTS);

                        output.accept(ModItems.IRON_HAMMER);
                        output.accept(ModItems.DIAMOND_HAMMER);
                    })

                    .build());

    public static final Supplier<CreativeModeTab> AZRAEIN_WORKSHOP_BLOCK_TAB = TABS.register("blocks_tab",
            () -> CreativeModeTab.builder()
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(AzraeinWorkshop.MOD_ID, "items_tab"))
                    .icon(() -> new ItemStack(ModBlocks.PEACOCK_ORE.get()))
                    .title(Component.translatable("creativetab." + AzraeinWorkshop.MOD_ID + ".blocks_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.PEACOCK_ORE);
                        output.accept(ModBlocks.DEEPSLATE_PEACOCK_ORE);
                        output.accept(ModBlocks.FIRE_METAL_ORE);
                        output.accept(ModBlocks.DEEPSLATE_FIRE_METAL_ORE);

                        output.accept(ModBlocks.PEACOCK_BLOCK);
                        output.accept(ModBlocks.RAW_FIRE_METAL_BLOCK);
                        output.accept(ModBlocks.FIRE_METAL_BLOCK);

                        output.accept(ModBlocks.SMASHING_ROCK);
                    })

                    .build());

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }

}
