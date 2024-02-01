package net.richiesuper.homuhomu.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.richiesuper.homuhomu.HomuHomu;

public class ModEffects {
    public static StatusEffect MAGICAL;
    public static StatusEffect TRANSFORMED;

    /* currently unused */
    public static StatusEffect registerStatusEffect(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(HomuHomu.MOD_ID, name), new MagicalEffect(StatusEffectCategory.BENEFICIAL, 0xffff00));
    }

    public static void registerEffects() {
        /* former way to get register status effects
        MAGICAL = registerStatusEffect("magical");
        TRANSFORMED = registerStatusEffect("transformed");
         */
        MAGICAL = Registry.register(Registries.STATUS_EFFECT, new Identifier(HomuHomu.MOD_ID, "magical"),
                new MagicalEffect(StatusEffectCategory.BENEFICIAL, 0xffff00));
        TRANSFORMED = Registry.register(Registries.STATUS_EFFECT, new Identifier(HomuHomu.MOD_ID, "transformed"),
                new TransformedEffect(StatusEffectCategory.BENEFICIAL, 0xffff00));
    }
}
