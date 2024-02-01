package net.richiesuper.homuhomu.world.feature;

import com.mojang.serialization.Lifecycle;
import net.minecraft.block.Blocks;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.richiesuper.homuhomu.HomuHomu;
import net.richiesuper.homuhomu.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<PlacedFeature> KYUUBEE_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(HomuHomu.MOD_ID,"ore_kyuubee"));

//    public static final List<OreFeatureConfig.Target> OVERWORLD_KYUUBEE_ORES = List.of(
//            OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.STONE), ModBlocks.KYUUBEE_ORE.getDefaultState()),
//            OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.DEEPSLATE), ModBlocks.KYUUBEE_ORE.getDefaultState()));
//
//    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> KYUUBEE_ORE =
////            ConfiguredFeatures.register("kyuubee_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_KYUUBEE_ORES, 2));
//            ConfiguredFeatures.register(new Registerable<ConfiguredFeature<?, ?>>() {
//                @Override
//                public RegistryEntry.Reference<ConfiguredFeature<?, ?>> register(RegistryKey<ConfiguredFeature<?, ?>> key, ConfiguredFeature<?, ?> value, Lifecycle lifecycle) {
//                    return null;
//                }
//
//                @Override
//                public <S> RegistryEntryLookup<S> getRegistryLookup(RegistryKey<? extends Registry<? extends S>> registryRef) {
//                    return null;
//                }
//            }, Feature.ORE, new OreFeatureConfig(OVERWORLD_KYUUBEE_ORES, 2));
//            ConfiguredFeatures.register(featureRegisterable, ORE_IRON, Feature.ORE, new OreFeatureConfig(list, 9));
//
//
//    public static void registerModConfiguredFeatures() {
//        HomuHomu.LOGGER.info("Registering Mod Configured Features for " + HomuHomu.MOD_ID);
//    }
}
