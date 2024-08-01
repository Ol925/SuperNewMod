package com.ol.snm.item;

import com.ol.snm.crafting.CraftingLoader;
import com.ol.snm.creativetab.CreativeTabsLoader;

import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.common.util.EnumHelper;

public class ItemRedstonePickaxe extends ItemPickaxe
{
    public static final Item.ToolMaterial REDSTONE = EnumHelper.addToolMaterial("REDSTONE", 3, 16, 16.0F, 0.0F, 10);

    public ItemRedstonePickaxe()
    {
        super(REDSTONE);
        this.setUnlocalizedName("redstonePickaxe");
        this.setCreativeTab(CreativeTabsLoader.tabSnm);
    }
}
