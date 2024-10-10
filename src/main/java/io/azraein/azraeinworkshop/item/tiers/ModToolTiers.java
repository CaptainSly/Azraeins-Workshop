package io.azraein.azraeinworkshop.item.tiers;

import io.azraein.azraeinworkshop.item.ModItems;
import io.azraein.azraeinworkshop.tags.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {

    public static final Tier FIRE_METAL = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_FIRE_METAL_TOOL,
            430, 4f, 3f, 28, () -> Ingredient.of(ModItems.FIRE_METAL_INGOT));

}
