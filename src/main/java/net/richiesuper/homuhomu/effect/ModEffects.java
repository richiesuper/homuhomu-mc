package net.richiesuper.homuhomu.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.richiesuper.homuhomu.HomuHomu;

public class ModEffects {
    public static StatusEffect MAGICAL;
    public static StatusEffect TRANSFORMED;

    /*
    public static StatusEffect registerStatusEffect(String name) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(HomuHomu.MOD_ID, name), new MagicalEffect(StatusEffectCategory.BENEFICIAL, 0xffff00));
    }
     */

    public static void registerEffects() {
        /*
        MAGICAL = registerStatusEffect("magical");
        TRANSFORMED = registerStatusEffect("transformed");
         */
        MAGICAL = Registry.register(Registry.STATUS_EFFECT, new Identifier(HomuHomu.MOD_ID, "magical"),
                new MagicalEffect(StatusEffectCategory.BENEFICIAL, 0xffff00));
        TRANSFORMED = Registry.register(Registry.STATUS_EFFECT, new Identifier(HomuHomu.MOD_ID, "transformed"),
                new TransformedEffect(StatusEffectCategory.BENEFICIAL, 0xffff00));
    }
}
