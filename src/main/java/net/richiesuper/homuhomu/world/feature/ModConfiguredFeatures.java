package net.richiesuper.homuhomu.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.richiesuper.homuhomu.HomuHomu;
import net.richiesuper.homuhomu.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final List<OreFeatureConfig.Target> OVERWORLD_KYUUBEE_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.KYUUBEE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.KYUUBEE_ORE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> KYUUBEE_ORE =
            ConfiguredFeatures.register("kyuubee_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_KYUUBEE_ORES, 2));

    public static void registerModConfiguredFeatures() {
        HomuHomu.LOGGER.info("Registering Mod Configured Features for " + HomuHomu.MOD_ID);
    }
}
