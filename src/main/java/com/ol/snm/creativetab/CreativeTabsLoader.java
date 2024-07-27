package com.ol.snm.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CreativeTabsLoader
{
    public static CreativeTabs tabSnm;

    public CreativeTabsLoader(FMLPreInitializationEvent event)
    {
        tabSnm = new CreativeTab();
    }
}