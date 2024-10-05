package io.azraein.azraeinworkshop.item;

import java.util.function.Supplier;

import io.azraein.azraeinworkshop.AzraeinWorkshop;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.Item.Properties;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

        public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AzraeinWorkshop.MOD_ID);

        // Feathers
        public static final DeferredItem<Item> RED_FEATHER = createGenericItem("red_feather");

        public static final DeferredItem<Item> BLUE_FEATHER = createGenericItem("blue_feather");

        public static final DeferredItem<Item> GREEN_FEATHER = createGenericItem("green_feather");

        public static final DeferredItem<Item> YELLOW_FEATHER = createGenericItem("yellow_feather");

        public static final DeferredItem<Item> PURPLE_FEATHER = createGenericItem("purple_feather");

        public static final DeferredItem<Item> XYLOTH_STAFF = ITEMS.register("xyloth_staff",
                        () -> new BakoraStaffItem());

        public static final DeferredItem<Item> WORKSHOP_MANUAL = ITEMS.register("workshop_manual",
                        () -> new WorkshopManualItem());
        // Foods

        public static final DeferredItem<Item> BAOBAB_FRUIT = createGenericItem("baobab_fruit",
                        new Properties().food(ModFoodProperties.BAOBAB_FRUIT));

        public static final DeferredItem<Item> GOURD = createGenericItem("gourd");

        public static final DeferredItem<Item> BAKED_GOURD = createGenericItem("baked_gourd",
                        new Properties().food(ModFoodProperties.BAKED_GOURD));

        public static final DeferredItem<Item> SMASHED_GOURD = createGenericItem("smashed_gourd",
                        new Properties().food(ModFoodProperties.SMASHED_GOURD));

        // Knives

        public static final DeferredItem<Item> WOOD_KNIFE = createCustomItem("wood_knife", () -> new KnifeItem(52));

        public static final DeferredItem<Item> COBBLE_KNIFE = createCustomItem("cobble_knife",
                        () -> new KnifeItem(104));

        public static final DeferredItem<Item> IRON_KNIFE = createCustomItem("iron_knife", () -> new KnifeItem(204));

        public static final DeferredItem<Item> FIRE_METAL_KNIFE = createCustomItem("fire_metal_knife",
                        () -> new KnifeItem(260));

        public static final DeferredItem<Item> GOLD_KNIFE = createCustomItem("gold_knife", () -> new KnifeItem(75));

        public static final DeferredItem<Item> DIAMOND_KNIFE = createCustomItem("diamond_knife",
                        () -> new KnifeItem(308));

        public static final DeferredItem<Item> NETHERITE_KNIFE = createCustomItem("netherite_knife",
                        () -> new KnifeItem(616));

        public static final DeferredItem<Item> PEACOCK_KNIFE = createCustomItem("peacock_knife",
                        () -> new KnifeItem(420));

        // Tools
        public static final DeferredItem<SwordItem> FIRE_METAL_SWORD = ITEMS.register("fire_metal_sword",
                        () -> new SwordItem(ModToolTiers.FIRE_METAL, new Item.Properties()
                                        .attributes(SwordItem.createAttributes(ModToolTiers.FIRE_METAL, 3, -2.4f))));

        public static final DeferredItem<PickaxeItem> FIRE_METAL_PICKAXE = ITEMS.register("fire_metal_pickaxe",
                        () -> new PickaxeItem(ModToolTiers.FIRE_METAL, new Item.Properties()
                                        .attributes(PickaxeItem.createAttributes(ModToolTiers.FIRE_METAL, 1.0f,
                                                        -2.8f))));

        public static final DeferredItem<ShovelItem> FIRE_METAL_SHOVEL = ITEMS.register("fire_metal_shovel",
                        () -> new ShovelItem(ModToolTiers.FIRE_METAL, new Item.Properties()
                                        .attributes(ShovelItem.createAttributes(ModToolTiers.FIRE_METAL, 1.5f, -3.0f))));

        public static final DeferredItem<AxeItem> FIRE_METAL_AXE = ITEMS.register("fire_metal_axe",
                        () -> new AxeItem(ModToolTiers.FIRE_METAL, new Item.Properties()
                                        .attributes(AxeItem.createAttributes(ModToolTiers.FIRE_METAL, 5, -3.2f))));

        public static final DeferredItem<HoeItem> FIRE_METAL_HOE = ITEMS.register("fire_metal_hoe",
                        () -> new HoeItem(ModToolTiers.FIRE_METAL, new Item.Properties()
                                        .attributes(HoeItem.createAttributes(ModToolTiers.FIRE_METAL, 0f, -3.0f))));

        // Music Discs
        
        // Armors

        // Mob Hides/Pelts
        public static final DeferredItem<Item> ZEBRA_HIDE = createGenericItem("zebra_hide");

        // Mob Horns

        // Chunks, Ingots, Dusts, and Gems
        public static final DeferredItem<Item> RAW_PEACOCK_CHUNK = createGenericItem("raw_peacock_chunk");
        public static final DeferredItem<Item> PEACOCK_GEM = createGenericItem("peacock_gem");

        public static final DeferredItem<Item> RAW_FIRE_METAL_CHUNK = createGenericItem("raw_fire_metal_chunk");
        public static final DeferredItem<Item> FIRE_METAL_INGOT = createGenericItem("fire_metal_ingot");
        public static final DeferredItem<Item> FIRE_METAL_NUGGET = createGenericItem("fire_metal_nugget");

        private static DeferredItem<Item> createMusicDiscItem(String itemId, Rarity rarity,
                        ResourceKey<JukeboxSong> song) {
                return ITEMS.register(itemId,
                                () -> new Item(new Properties().stacksTo(1).rarity(rarity)
                                                .jukeboxPlayable(song)));
        }

        private static DeferredItem<Item> createGenericItem(String itemId) {
                return createGenericItem(itemId, new Properties());
        }

        private static DeferredItem<Item> createGenericItem(String itemId, Item.Properties properties) {
                return ITEMS.register(itemId, () -> new Item(properties));
        }

        private static DeferredItem<Item> createCustomItem(String itemId, Supplier<? extends Item> item) {
                return ITEMS.register(itemId, item);
        }

        public static void register(IEventBus eventBus) {
                ITEMS.register(eventBus);
        }
}