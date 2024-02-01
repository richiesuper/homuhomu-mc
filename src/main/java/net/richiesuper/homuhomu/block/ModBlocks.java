package net.richiesuper.homuhomu.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.richiesuper.homuhomu.HomuHomu;
import net.richiesuper.homuhomu.block.custom.KyuubeeBlock;
import net.richiesuper.homuhomu.item.ModItemGroup;

public class ModBlocks {
    public static final Block KYUUBEE_ORE = registerBlock("kyuubee_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(255f, 255f).requiresTool().luminance(127),
                    UniformIntProvider.create(16, 69)), ModItemGroup.PMMM);
    public static final Block KYUUBEE_BLOCK = registerBlock("kyuubee_block",
            new KyuubeeBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).strength(255f, 255f).requiresTool().luminance(255)), ModItemGroup.PMMM);

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(HomuHomu.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registries.ITEM, new Identifier(HomuHomu.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        HomuHomu.LOGGER.info("Registering Mod Blocks for " + HomuHomu.MOD_ID);
    }
}
