package io.azraein.azraeinworkshop.datagen;

import io.azraein.azraeinworkshop.AzraeinWorkshop;
import io.azraein.azraeinworkshop.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AzraeinWorkshop.MOD_ID, existingFileHelper);
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

        handheldItem(ModItems.XYLOTH_STAFF);

        basicItem(ModItems.BLUE_FEATHER.get());
        basicItem(ModItems.GREEN_FEATHER.get());
        basicItem(ModItems.RED_FEATHER.get());
        basicItem(ModItems.YELLOW_FEATHER.get());
        basicItem(ModItems.PURPLE_FEATHER.get());

        basicItem(ModItems.WORKSHOP_MANUAL.get());

        basicItem(ModItems.FIRE_METAL_INGOT.get());
        basicItem(ModItems.RAW_FIRE_METAL_CHUNK.get());
        basicItem(ModItems.FIRE_METAL_NUGGET.get());

        basicItem(ModItems.RAW_PEACOCK_CHUNK.get());
        basicItem(ModItems.PEACOCK_GEM.get());

        basicItem(ModItems.ZEBRA_HIDE.get());

        basicItem(ModItems.BAOBAB_FRUIT.get());

    }

    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(), ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(AzraeinWorkshop.MOD_ID, "item/" + item.getId().getPath()));
    }

}