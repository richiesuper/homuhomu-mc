package net.richiesuper.homuhomu.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.richiesuper.homuhomu.HomuHomu;

public class ModItems {
    public static final Item GRIEF_SEED = registerItem("grief_seed",
            new Item(new FabricItemSettings().group(ModItemGroup.PMMM)));
    public static final Item SOUL_GEM = registerItem("soul_gem",
            new Item(new FabricItemSettings().group(ModItemGroup.PMMM)));
    public static final Item RAW_KYUUBEE = registerItem("raw_kyuubee",
            new Item(new FabricItemSettings().group(ModItemGroup.PMMM)));
    public static final Item KYUUBEE_INGOT = registerItem("kyuubee_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.PMMM)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(HomuHomu.MOD_ID, name), item);
    }

    public static void registerModItems() {
        HomuHomu.LOGGER.info("Registering Mod Items for " + HomuHomu.MOD_ID);
    }
}
