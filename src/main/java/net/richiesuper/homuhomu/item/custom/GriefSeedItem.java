package net.richiesuper.homuhomu.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GriefSeedItem extends Item {
    public GriefSeedItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("Grief Seed is the product of Soul Gem corruption!").formatted(Formatting.DARK_RED));
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(stack.getMaxDamage() - stack.getDamage(), attacker, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        attacker.sendMessage(Text.literal(attacker.getEntityName() + " destroyed a Grief Seed and spawned a witch!"));
        return true;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        stack.damage(stack.getMaxDamage() - stack.getDamage(), miner, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        miner.sendMessage(Text.literal(miner.getEntityName() + " destroyed a Grief Seed and spawned a witch!"));
        return true;
    }
}
