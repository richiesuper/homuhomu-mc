package net.richiesuper.homuhomu.painting;

import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.richiesuper.homuhomu.HomuHomu;

public class ModPaintings {
    public static final PaintingVariant HOMURA = registerPainting("homura", new PaintingVariant(94, 122));
    public static final PaintingVariant MADOKA = registerPainting("madoka", new PaintingVariant(79, 105));
    public static final PaintingVariant SAYAKA = registerPainting("sayaka", new PaintingVariant(117, 126));
    public static final PaintingVariant KYOKO = registerPainting("kyoko", new PaintingVariant(205, 132));
    public static final PaintingVariant MAMI = registerPainting("mami", new PaintingVariant(99, 127));
    public static final PaintingVariant KYUUBEE = registerPainting("kyuubee", new PaintingVariant(92, 74));

    public static PaintingVariant registerPainting(String name, PaintingVariant paintingVariant) {
        return Registry.register(Registries.PAINTING_VARIANT, new Identifier(HomuHomu.MOD_ID, name), paintingVariant);
    }

    public static void registerPaintings() {
        HomuHomu.LOGGER.info("Registering Mod Paintings for " + HomuHomu.MOD_ID);
    }
}
