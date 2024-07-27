package com.ol.snm.creativetab;

import com.ol.snm.item.ItemLoader;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTab extends CreativeTabs
{
    public CreativeTab()
    {
        super("snm");
    }

    @Override
    public Item getTabIconItem()
    {
        return ItemLoader.goldenEgg;
    }
}