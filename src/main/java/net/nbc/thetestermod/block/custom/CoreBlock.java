package net.nbc.thetestermod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;
import net.nbc.thetestermod.entity.ModEntities;
import net.nbc.thetestermod.entity.custom.ChairEntity;
import net.nbc.thetestermod.sound.ModSounds;

import java.util.List;

public class CoreBlock extends Block {
    private int cooldown = 0;

    public CoreBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (level == null || level.isClientSide()) return;

        level.scheduleTick(pos, this, 1);

        if (cooldown > 0) {
            cooldown--; // decrease cooldown each tick
            return;
        }

        // Random chance to play a sound
        if (level.random.nextFloat() < 0.01f) { // 1% chance per tick
            level.playSound(
                    null,
                    pos,
                    ModSounds.CORE_HUM.get(),
                    SoundSource.BLOCKS,
                    1.0f,
                    1.0f
            );
            cooldown = 400; // 20 second cooldown (20 ticks = 1 sec)
        }
        super.tick(state, level, pos, random);
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if (!level.isClientSide() && !state.is(newState.getBlock())) {
            BlockEntity be = level.getBlockEntity(pos);
            Player player = (level instanceof ServerLevel serverLevel) ? serverLevel.getNearestPlayer(pos.getX(), pos.getY(), pos.getZ(), 5, false) : null;

            // Only explode if it wasn’t harvested correctly
            if (player != null && !player.isCreative()) {
                boolean hasCorrectTool = player.getMainHandItem().isCorrectToolForDrops(state);

                if (!hasCorrectTool) {
                    level.explode(
                            null,
                            pos.getX() + 0.5,
                            pos.getY() + 0.5,
                            pos.getZ() + 0.5,
                            16.0f,
                            false,
                            Level.ExplosionInteraction.MOB
                    );
                }
            }
        }

        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        level.scheduleTick(pos, this, 1);
    }
}
