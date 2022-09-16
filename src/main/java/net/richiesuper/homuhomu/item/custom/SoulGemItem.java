package net.richiesuper.homuhomu.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.richiesuper.homuhomu.effect.ModEffects;

public class SoulGemItem extends Item {
    private static final int BASE_COOLDOWN = 4800;
    private static final int BASE_EFFECT_DURATION = 2400;

    private static int usageTickCount = 0;

    public SoulGemItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(stack.getMaxDamage() - stack.getDamage(), attacker, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        attacker.kill();
        return true;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        stack.damage(stack.getMaxDamage() - stack.getDamage(), miner, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        miner.kill();
        return true;
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        usageTickCount++;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (!world.isClient()) {
            PlayerEntity player = (PlayerEntity) user;

            int multiplier = usageTickCount / 20;
            int duration = BASE_EFFECT_DURATION * multiplier;
            int cooldown = BASE_COOLDOWN * multiplier;

            user.addStatusEffect(new StatusEffectInstance(ModEffects.TRANSFORMED, duration, 0, true, true, true));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, duration, 2, true, true, true));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, duration, 2, true, true, true));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, duration, 1, true, true, true));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, duration, 2, true, true, true));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, duration, 0, true, true, true));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, duration, 0, true, true, true));

            declareMagical(player);
            player.getItemCooldownManager().set(this, cooldown);
        }

        usageTickCount = 0;
        return stack;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    private void declareMagical(PlayerEntity player) {
        player.sendMessage(Text.literal(player.getEntityName() + " is now a magical entity! Witches begone!"));
    }
}
