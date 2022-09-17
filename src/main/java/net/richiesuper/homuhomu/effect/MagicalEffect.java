package net.richiesuper.homuhomu.effect;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.richiesuper.homuhomu.item.ModItems;

public class MagicalEffect extends StatusEffect {
    public static final int GRIEF_SEED_DAMAGE = 1;
    public static final int SOUL_GEM_REPAIR = 1;
    public MagicalEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {

        if (!entity.world.isClient() && entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            if (!player.getInventory().contains(new ItemStack(ModItems.SOUL_GEM)) && player.isAlive()) {
                player.sendMessage(Text.literal(player.getEntityName() + " lost their Soul Gem and died!"));
                player.kill();
            }

            ItemStack itemStackMH = player.getMainHandStack();
            ItemStack itemStackOH = player.getOffHandStack();
            if (itemStackMH.getItem() == ModItems.SOUL_GEM && itemStackOH.getItem() == ModItems.GRIEF_SEED ||
                    itemStackMH.getItem() == ModItems.GRIEF_SEED && itemStackOH.getItem() == ModItems.SOUL_GEM) {
                if (itemStackMH.getItem() == ModItems.SOUL_GEM && itemStackMH.getDamage() > 0) {
                    if (itemStackOH.getDamage() + GRIEF_SEED_DAMAGE >= itemStackOH.getMaxDamage()) {
                        player.sendMessage(Text.literal(player.getEntityName() + " overloaded a Grief Seed and spawned a witch!"));
                    }
                    itemStackOH.damage(GRIEF_SEED_DAMAGE, player, e -> e.sendEquipmentBreakStatus(EquipmentSlot.OFFHAND));
                    itemStackMH.setDamage(itemStackMH.getDamage() - SOUL_GEM_REPAIR);
                } else if (itemStackOH.getItem() == ModItems.SOUL_GEM && itemStackOH.getDamage() > 0) {
                    if (itemStackMH.getDamage() + GRIEF_SEED_DAMAGE >= itemStackMH.getMaxDamage()) {
                        player.sendMessage(Text.literal(player.getEntityName() + " overloaded a Grief Seed and spawned a witch!"));
                    }
                    itemStackMH.damage(GRIEF_SEED_DAMAGE, player, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
                    itemStackOH.setDamage(itemStackOH.getDamage() - SOUL_GEM_REPAIR);
                }
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
