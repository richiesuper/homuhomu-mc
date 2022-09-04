package net.richiesuper.homuhomu.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.richiesuper.homuhomu.HomuHomu;

public class ModItemGroup {
    public static final ItemGroup PMMM = FabricItemGroupBuilder.build(new Identifier(HomuHomu.MOD_ID, "pmmm"),
            () -> new ItemStack(ModItems.SOUL_GEM));
}
