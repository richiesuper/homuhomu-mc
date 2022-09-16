package net.richiesuper.homuhomu.effect;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
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
                itemStack.setDamage(itemStack.getDamage() + normalSoulGemDecay);

                if (player.getHealth() <= playerHealthThreshold && player.isAlive()) {
                    player.setHealth(player.getMaxHealth());
                    if (itemStack.getDamage() + soulGemDeathPenalty >= itemStack.getMaxDamage()) {
                        itemStack.setDamage(itemStack.getMaxDamage());
                    } else {
                        itemStack.setDamage(itemStack.getDamage() + soulGemDeathPenalty);
                    }
                }

                if (itemStack.getDamage() >= itemStack.getMaxDamage()) {
                    itemStack.damage(0, entity, e -> e.sendEquipmentBreakStatus(EquipmentSlot.byName("Soul Gem")));
                }

            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
