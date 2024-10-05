package io.azraein.azraeinworkshop.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {

        public static final FoodProperties SMASHED_GOURD = new FoodProperties.Builder().nutrition(6)
                        .saturationModifier(0.55f).build();

        public static final FoodProperties BAKED_GOURD = new FoodProperties.Builder().nutrition(4)
                        .saturationModifier(0.25f)
                        .build();

        public static final FoodProperties BAOBAB_FRUIT = new FoodProperties.Builder().nutrition(3)
                        .saturationModifier(0.35f).build();

}
