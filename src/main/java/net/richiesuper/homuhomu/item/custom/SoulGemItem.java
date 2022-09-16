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
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.richiesuper.homuhomu.effect.ModEffects;

public class SoulGemItem extends Item {
    private static final int BASE_COOLDOWN = 600;
    private static final int BASE_EFFECT_DURATION = 300;

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
    public int getMaxUseTime(ItemStack stack) {
        return 1200; // 1 minute
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);
        return TypedActionResult.success(user.getStackInHand(hand), false);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (!world.isClient() && user.hasStatusEffect(ModEffects.MAGICAL)) {
            PlayerEntity player = (PlayerEntity) user;

            int multiplier = (getMaxUseTime(stack) - remainingUseTicks) / 20;
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
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (!world.isClient() && user.hasStatusEffect(ModEffects.MAGICAL)) {
            PlayerEntity player = (PlayerEntity) user;

            int multiplier = getMaxUseTime(stack);
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
