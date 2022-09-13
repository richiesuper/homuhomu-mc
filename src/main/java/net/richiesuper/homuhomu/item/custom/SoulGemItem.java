package net.richiesuper.homuhomu.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
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

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient() && hand == Hand.MAIN_HAND) {
			user.addStatusEffect(new StatusEffectInstance(ModEffects.MAGICAL, 2400, 0, true, true, true));
			declareMagical(user);
			user.getItemCooldownManager().set(this, 4800);
        }

		return super.use(world, user, hand);
    }

	private void declareMagical(PlayerEntity player) {
		player.sendMessage(Text.literal(player.getEntityName() + " is now a magical entity! Witches begone!"));
	}
}
