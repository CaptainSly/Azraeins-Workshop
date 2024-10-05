package io.azraein.azraeinworkshop.block;

import io.azraein.azraeinworkshop.item.ModItems;
import io.azraein.azraeinworkshop.sounds.ModSoundEvents;
import io.azraein.azraeinworkshop.tags.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

// TODO: Change to TileEntity, needs custom model. 

public class SmashingRockBlock extends SlabBlock {
    public SmashingRockBlock(Properties properties) {
        super(properties);

    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
            Player player, InteractionHand hand, BlockHitResult hitResult) {

        if (isSmashableGourd(stack)) {
            int stackCount = stack.getCount() - 1;

            stack.setCount(stackCount);
            player.addItem(new ItemStack(ModItems.SMASHED_GOURD.get(), 1));
            level.playSound(player, pos, ModSoundEvents.SMASHING_ROCK_GOURD_SMASH.get(), SoundSource.BLOCKS, 1f, 1f);
        }

        return ItemInteractionResult.sidedSuccess(level.isClientSide());
    }

    private boolean isSmashableGourd(ItemStack stack) {
        return stack.is(ModTags.Items.SMASHABLE_GOURD);
    }

}
