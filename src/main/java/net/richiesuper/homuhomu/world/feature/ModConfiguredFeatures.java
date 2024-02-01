package net.richiesuper.homuhomu.world.feature;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.richiesuper.homuhomu.HomuHomu;

public class ModConfiguredFeatures {
    public static final RegistryKey<PlacedFeature> KYUUBEE_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(HomuHomu.MOD_ID,"ore_kyuubee"));
}
