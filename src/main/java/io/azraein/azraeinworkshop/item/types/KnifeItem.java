package io.azraein.azraeinworkshop.item.types;

import net.minecraft.world.item.Item;

public class KnifeItem extends Item {

    // Knife, weapon and useable item.

    public KnifeItem(int maxDurability) {
        super(new Properties().stacksTo(1).durability(maxDurability));
    }

}
