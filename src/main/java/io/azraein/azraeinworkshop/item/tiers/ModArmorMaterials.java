package io.azraein.azraeinworkshop.item.tiers;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

import io.azraein.azraeinworkshop.AzraeinWorkshop;
import io.azraein.azraeinworkshop.item.ModItems;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

public class ModArmorMaterials {

    public static final Holder<ArmorMaterial> FIRE_METAL_ARMOR_MATERIAL = register("fire_metal",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(Type.BOOTS, 5);
                attribute.put(Type.LEGGINGS, 7);
                attribute.put(Type.CHESTPLATE, 9);
                attribute.put(Type.HELMET, 5);
                attribute.put(Type.BODY, 11);
            }), SoundEvents.ARMOR_EQUIP_IRON, 16, 2f, 0.3f, () -> ModItems.FIRE_METAL_INGOT.get());

    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> typeProtection,
            Holder<SoundEvent> equipSound, int enchantability, float toughness, float knockbackResistance,
            Supplier<Item> ingredientItem) {
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(AzraeinWorkshop.MOD_ID, name);
        Supplier<Ingredient> ingredient = () -> Ingredient.of(ingredientItem.get());
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(location));

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location,
                new ArmorMaterial(typeProtection, enchantability, equipSound, ingredient, layers, toughness,
                        knockbackResistance));
    }

}
