package io.azraein.azraeinworkshop.item;

import java.util.List;

import io.azraein.azraeinworkshop.AzraeinWorkshop;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import vazkii.patchouli.api.PatchouliAPI;

@SuppressWarnings("null")
public class WorkshopManualItem extends Item {

    public WorkshopManualItem() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack stack = player.getItemInHand(InteractionHand.MAIN_HAND);

        if (player instanceof ServerPlayer sPlayer) {
            PatchouliAPI.get().openBookGUI(sPlayer,
                    ResourceLocation.fromNamespaceAndPath(AzraeinWorkshop.MOD_ID, "workshop_manual"));
            level.playSound(sPlayer, sPlayer.position().x, sPlayer.position().y, sPlayer.position().z,
                    SoundEvents.BOOK_PAGE_TURN, SoundSource.PLAYERS);

        }

        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents,
            TooltipFlag tooltipFlag) {

        if (!Screen.hasShiftDown()) {
            tooltipComponents
                    .add(Component.translatable("tooltip." + AzraeinWorkshop.MOD_ID + ".workshop_manual.shift_down"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip." + AzraeinWorkshop.MOD_ID + ".workshop_manual.description"));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

}
