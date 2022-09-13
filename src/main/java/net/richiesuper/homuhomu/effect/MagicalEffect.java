package net.richiesuper.homuhomu.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.text.Text;

public class MagicalEffect extends StatusEffect {
	public MagicalEffect(StatusEffectCategory statusEffectCategory, int color) {
		super(statusEffectCategory, color);
	}

	@Override
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		if (!entity.world.isClient()) {
			entity.setMovementSpeed(1.125f);
			entity.setHealth(40f);
			entity.heal(20f);
			entity.setAbsorptionAmount(20f);
			entity.setGlowing(true);
			entity.setCustomNameVisible(true);
			entity.setCustomName(Text.literal("<Magical> " + entity.getName()));
		}

		super.applyUpdateEffect(entity, amplifier);
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return true;
	}
}
