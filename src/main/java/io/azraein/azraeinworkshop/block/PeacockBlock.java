package io.azraein.azraeinworkshop.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class PeacockBlock extends Block {

    public PeacockBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player,
            BlockHitResult hitResult) {

        level.playSound(player, pos, SoundEvents.AMETHYST_BLOCK_STEP, SoundSource.BLOCKS, 1f, 1f);

        return super.useWithoutItem(state, level, pos, player, hitResult);
    }

}
