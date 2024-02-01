package net.richiesuper.homuhomu.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.richiesuper.homuhomu.HomuHomu;
import net.richiesuper.homuhomu.block.ModBlocks;

public class ModItemGroup {
//    public static final ItemGroup PMMM = FabricItemGroupBuilder.build(new Identifier(HomuHomu.MOD_ID, "pmmm"),
//            () -> new ItemStack(ModItems.SOUL_GEM));

    public static final ItemGroup PMMM = Registry.register(Registries.ITEM_GROUP,
            new Identifier(HomuHomu.MOD_ID, "pmmm"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.pmmm"))
                    .icon(() -> new ItemStack(ModItems.SOUL_GEM)).entries((displayContext, entries) -> {
                        entries.add(ModItems.GRIEF_SEED);
                        entries.add(ModItems.SOUL_GEM);
                        entries.add(ModItems.RAW_KYUUBEE);
                        entries.add(ModItems.KYUUBEE_INGOT);
                        entries.add(ModBlocks.KYUUBEE_ORE);
                        entries.add(ModBlocks.KYUUBEE_BLOCK);
                    }).build());
}
