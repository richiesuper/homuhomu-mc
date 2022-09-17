package net.richiesuper.homuhomu.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.chunk.WorldChunk;
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class KyuubeeBlock extends Block {
    public KyuubeeBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.literal("Kyuubee Block(s) can spawn Incubator into the world!").formatted(Formatting.LIGHT_PURPLE));
    }

    public void onSteppedOnPrank1(World world, BlockPos pos, BlockState state, Entity entity) {
        if (!world.isClient()) {
            if (entity instanceof PlayerEntity playerEntity) {
                playerEntity.teleport(pos.getX(), pos.getY() + 127, pos.getZ());
            }
        }
    }

    public void onPlacedPrank1(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (!world.isClient()) {
            world.createExplosion(null, placer.getX(), placer.getY(), placer.getZ(), 16f, true, Explosion.DestructionType.DESTROY);
        }
    }

    public void onPlacedPrank2(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (!world.isClient()) {
            world.setMobSpawnOptions(false, false);

            BlockPos playerPos = placer.getBlockPos();
            for (int y = playerPos.getY(); y >= world.getBottomY(); y--) {
                world.breakBlock(playerPos, false);
                world.breakBlock(playerPos.add(1, 0, 0), false);
                world.breakBlock(playerPos.add(1, 0, 1), false);
                world.breakBlock(playerPos.add(1, 0, -1), false);
                world.breakBlock(playerPos.add(-1, 0, 0), false);
                world.breakBlock(playerPos.add(-1, 0, 1), false);
                world.breakBlock(playerPos.add(-1, 0, -1), false);
                world.breakBlock(playerPos.add(0, 0, 1), false);
                world.breakBlock(playerPos.add(0, 0, -1), false);

                playerPos = playerPos.down();
            }
        }
    }
}
