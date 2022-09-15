package net.richiesuper.homuhomu.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.math.random.Random;
import net.richiesuper.homuhomu.item.ModItems;

public class MagicalEffect extends StatusEffect {
	public MagicalEffect(StatusEffectCategory statusEffectCategory, int color) {
		super(statusEffectCategory, color);
	}

	@Override
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		final int safetyOffset = 5; // prevents negative durability, may or may not be present in release
		final int normalSoulGemDecay = 1;
		final int soulGemDeathPenalty = 3000;
		final float playerHealthThreshold = 8f;
		final int invSlotCount = 54;

		if (!entity.world.isClient() && entity instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) entity;
			ItemStack itemStack = player.getStackInHand(Hand.MAIN_HAND);
			if (player.getInventory().contains(new ItemStack(ModItems.SOUL_GEM))) {
				for (int i = 0; i < invSlotCount; ++i) {
					itemStack = player.getInventory().getStack(i);
					if (itemStack.getItem() == ModItems.SOUL_GEM) {
						break;
					}
				}
				itemStack.damage(normalSoulGemDecay, Random.createLocal(), (ServerPlayerEntity) player);
				if (itemStack.getDamage() >= itemStack.getMaxDamage() && !player.isDead()) {
					player.sendMessage(Text.literal(player.getEntityName() + " had witched out and died!"));
					player.kill();
					player.dropItem(ModItems.GRIEF_SEED);
				}

				if (player.getHealth() <= playerHealthThreshold && player.isAlive()) {
					player.setHealth(player.getMaxHealth());
					if (itemStack.getItem() == ModItems.SOUL_GEM) {
						if (itemStack.getDamage() + soulGemDeathPenalty >= itemStack.getMaxDamage()) {
							itemStack.damage(itemStack.getMaxDamage() - itemStack.getDamage() - safetyOffset, Random.createLocal(), (ServerPlayerEntity) player);
						} else {
							itemStack.damage(soulGemDeathPenalty, Random.createLocal(), (ServerPlayerEntity) player);
						}
					}
				}
			} else {
				player.kill();
			}
		}

		super.applyUpdateEffect(entity, amplifier);
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return true;
	}
}
