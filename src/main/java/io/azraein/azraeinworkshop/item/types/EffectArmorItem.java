package io.azraein.azraeinworkshop.item.types;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EffectArmorItem extends ArmorItem {

    protected Map<Holder<ArmorMaterial>, List<MobEffectInstance>> materialEffectMap;

    public EffectArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties,
            Map<Holder<ArmorMaterial>, List<MobEffectInstance>> materialEffectMap) {
        super(material, type, properties);
        this.materialEffectMap = materialEffectMap;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        super.inventoryTick(stack, level, entity, slotId, isSelected);

        if (entity instanceof Player player && !level.isClientSide() && hasFullSuitOfArmorOn(player)) {
            evaluteArmorEffects(player);
        }

    }

    private void evaluteArmorEffects(Player player) {
        for (Entry<Holder<ArmorMaterial>, List<MobEffectInstance>> entry : materialEffectMap.entrySet()) {
            Holder<ArmorMaterial> armorMaterial = entry.getKey();
            List<MobEffectInstance> effect = entry.getValue();

            if (hasPlayerCorrectArmorOn(armorMaterial, player))
                addEffectToPlayer(player, effect);
        }
    }

    private void addEffectToPlayer(Player player, List<MobEffectInstance> mobEffect) {
        boolean hasPlayerEffect = mobEffect.stream().allMatch(effect -> player.hasEffect(effect.getEffect()));

        if (!hasPlayerEffect) {
            for (MobEffectInstance effect : mobEffect) {
                player.addEffect(new MobEffectInstance(effect.getEffect(), effect.getDuration(), effect.getAmplifier(),
                        effect.isAmbient(), effect.isVisible()));
            }
        }
    }

    private boolean hasPlayerCorrectArmorOn(Holder<ArmorMaterial> armorMaterial, Player player) {
        for (ItemStack armorStack : player.getArmorSlots()) {
            if (!(armorStack.getItem() instanceof ArmorItem))
                return false;
        }

        ArmorItem boots = ((ArmorItem) player.getInventory().getArmor(0).getItem());
        ArmorItem legs = ((ArmorItem) player.getInventory().getArmor(1).getItem());
        ArmorItem chest = ((ArmorItem) player.getInventory().getArmor(2).getItem());
        ArmorItem head = ((ArmorItem) player.getInventory().getArmor(3).getItem());

        return boots.getMaterial() == armorMaterial && legs.getMaterial() == armorMaterial
                && chest.getMaterial() == armorMaterial && head.getMaterial() == armorMaterial;
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack headPiece = player.getInventory().getArmor(3);
        ItemStack chestPiece = player.getInventory().getArmor(2);
        ItemStack legPiece = player.getInventory().getArmor(1);
        ItemStack footPiece = player.getInventory().getArmor(0);

        return !headPiece.isEmpty() && !chestPiece.isEmpty() && !legPiece.isEmpty() && !footPiece.isEmpty();
    }

}
