package net.richiesuper.homuhomu;

import net.fabricmc.api.ModInitializer;
import net.richiesuper.homuhomu.block.ModBlocks;
import net.richiesuper.homuhomu.effect.ModEffects;
import net.richiesuper.homuhomu.item.ModItems;
import net.richiesuper.homuhomu.painting.ModPaintings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomuHomu implements ModInitializer {
    public static final String MOD_ID = "homuhomu";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModEffects.registerEffects();
        ModPaintings.registerPaintings();
    }
}
