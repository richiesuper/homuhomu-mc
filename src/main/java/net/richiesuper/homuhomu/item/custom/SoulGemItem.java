package net.richiesuper.homuhomu.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.richiesuper.homuhomu.effect.ModEffects;

public class SoulGemItem extends Item {
    public SoulGemItem(Settings settings) {
        super(settings);
    }

	// TODO:
	// Make it so that when player uses soul gem / grief seed to attack mobs / destroy blocks,
	// the soul gem / grief seed immediately break. Keyword here is BREAK.
	// Soul Gem breakage just kills the player and does NOT spawn a grief seed.
	// Grief Seed breakage spawns a witch in the vicinity.

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {
			user.addStatusEffect(new StatusEffectInstance(ModEffects.MAGICAL, 2400, 0, true, true, true));
			user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 2, true, true, true));
			user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 2400, 2, true, true, true));
			user.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 2400, 1, true, true, true));
			user.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 2400, 2, true, true, true));
			user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 2400, 0, true, true, true));
			user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 2400, 0, true, true, true));

			declareMagical(user);
			user.getItemCooldownManager().set(this, 4800);
        }

		return super.use(world, user, hand);
    }

	private void declareMagical(PlayerEntity player) {
		player.sendMessage(Text.literal(player.getEntityName() + " is now a magical entity! Witches begone!"));
	}
}
