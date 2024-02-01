package net.richiesuper.homuhomu.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.richiesuper.homuhomu.HomuHomu;
import net.richiesuper.homuhomu.item.custom.GriefSeedItem;
import net.richiesuper.homuhomu.item.custom.SoulGemItem;

public class ModItems {
    public static final Item GRIEF_SEED = registerItem("grief_seed",
            new GriefSeedItem(new FabricItemSettings().maxDamage(54000).rarity(Rarity.EPIC).fireproof()));
    public static final Item SOUL_GEM = registerItem("soul_gem",
            new SoulGemItem(new FabricItemSettings().maxDamage(54000).rarity(Rarity.EPIC).fireproof()));
    public static final Item RAW_KYUUBEE = registerItem("raw_kyuubee",
            new Item(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item KYUUBEE_INGOT = registerItem("kyuubee_ingot",
            new Item(new FabricItemSettings().rarity(Rarity.RARE)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(HomuHomu.MOD_ID, name), item);
    }

    public static void registerModItems() {
        HomuHomu.LOGGER.info("Registering Mod Items for " + HomuHomu.MOD_ID);
    }
}
