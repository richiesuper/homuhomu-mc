package net.richiesuper.homuhomu.effect;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.random.Random;
import net.richiesuper.homuhomu.item.ModItems;

public class TransformedEffect extends StatusEffect {
    private static final int normalSoulGemDecay = 1;
    private static final int soulGemDeathPenalty = 3000;
    private static final float playerHealthThreshold = 8f;
    private static final int invSlotCount = 54;

    public TransformedEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {

        if (!entity.world.isClient() && entity instanceof PlayerEntity player) {
            ItemStack itemStack = player.getStackInHand(Hand.MAIN_HAND);
            if (player.getInventory().contains(new ItemStack(ModItems.SOUL_GEM))) {
                for (int i = 0; i < invSlotCount; ++i) {
                    itemStack = player.getInventory().getStack(i);
                    if (itemStack.getItem() == ModItems.SOUL_GEM) {
                        break;
                    }
                }
                itemStack.damage(normalSoulGemDecay, Random.createLocal(), (ServerPlayerEntity) player);

                if (player.getHealth() <= playerHealthThreshold && player.isAlive()) {
                    player.setHealth(player.getMaxHealth());
                    if (itemStack.getDamage() + soulGemDeathPenalty >= itemStack.getMaxDamage()) {
                        itemStack.damage(itemStack.getMaxDamage() - itemStack.getDamage(), Random.createLocal(), (ServerPlayerEntity) player);
                    } else {
                        itemStack.damage(soulGemDeathPenalty, Random.createLocal(), (ServerPlayerEntity) player);
                    }
                }

                if (itemStack.getDamage() >= itemStack.getMaxDamage() && player.isAlive()) {
                    itemStack.damage(1, Random.createLocal(), (ServerPlayerEntity) player);
                    player.dropItem(ModItems.GRIEF_SEED);
                    player.kill();
                }
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
