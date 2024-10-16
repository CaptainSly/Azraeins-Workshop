package io.azraein.azraeinworkshop.datagen;

import java.util.LinkedHashMap;

import io.azraein.azraeinworkshop.AzraeinWorkshop;
import io.azraein.azraeinworkshop.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AzraeinWorkshop.MOD_ID, existingFileHelper);
    }

    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();

    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1f);
        trimMaterials.put(TrimMaterials.IRON, 0.2f);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3f);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4f);
        trimMaterials.put(TrimMaterials.COPPER, 0.5f);
        trimMaterials.put(TrimMaterials.GOLD, 0.6f);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7f);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8f);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9f);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0f);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.BAKED_GOURD.get());
        basicItem(ModItems.SMASHED_GOURD.get());
        basicItem(ModItems.GOURD.get());

        handheldItem(ModItems.WOOD_KNIFE);
        handheldItem(ModItems.COBBLE_KNIFE);
        handheldItem(ModItems.IRON_KNIFE);
        handheldItem(ModItems.FIRE_METAL_KNIFE);
        handheldItem(ModItems.GOLD_KNIFE);
        handheldItem(ModItems.DIAMOND_KNIFE);
        handheldItem(ModItems.PEACOCK_KNIFE);
        handheldItem(ModItems.NETHERITE_KNIFE);

        handheldItem(ModItems.FIRE_METAL_SWORD);
        handheldItem(ModItems.FIRE_METAL_PICKAXE);
        handheldItem(ModItems.FIRE_METAL_SHOVEL);
        handheldItem(ModItems.FIRE_METAL_AXE);
        handheldItem(ModItems.FIRE_METAL_HOE);
        handheldItem(ModItems.FIRE_METAL_HAMMER);

        handheldItem(ModItems.IRON_HAMMER);
        handheldItem(ModItems.DIAMOND_HAMMER);

        handheldItem(ModItems.XYLOTH_STAFF);

        trimmedArmorItem(ModItems.FIRE_METAL_HELMET);
        trimmedArmorItem(ModItems.FIRE_METAL_CHESTPLATE);
        trimmedArmorItem(ModItems.FIRE_METAL_LEGGINGS);
        trimmedArmorItem(ModItems.FIRE_METAL_BOOTS);

        basicItem(ModItems.FIRE_METAL_HORSE_ARMOR.get());

        basicItem(ModItems.BLUE_FEATHER.get());
        basicItem(ModItems.GREEN_FEATHER.get());
        basicItem(ModItems.RED_FEATHER.get());
        basicItem(ModItems.YELLOW_FEATHER.get());
        basicItem(ModItems.PURPLE_FEATHER.get());

        basicItem(ModItems.WORKSHOP_MANUAL.get());

        basicItem(ModItems.FIRE_METAL_INGOT.get());
        basicItem(ModItems.RAW_FIRE_METAL_CHUNK.get());
        basicItem(ModItems.FIRE_METAL_NUGGET.get());

        basicItem(ModItems.PEACOCK_GEM.get());

        basicItem(ModItems.ZEBRA_HIDE.get());

        basicItem(ModItems.BAOBAB_FRUIT.get());

    }

    private void trimmedArmorItem(DeferredItem<ArmorItem> itemDeferredItem) {
        final String MOD_ID = AzraeinWorkshop.MOD_ID;

        if (itemDeferredItem.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {
                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = armorItem.toString();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture
                // exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemDeferredItem.getId().getPath(),
                        mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(
                                trimNameResLoc.getNamespace() + ":item/" + trimNameResLoc.getPath()))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                        "item/" + itemDeferredItem.getId().getPath()));
            });
        }
    }

    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(), ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(AzraeinWorkshop.MOD_ID, "item/" + item.getId().getPath()));
    }

}