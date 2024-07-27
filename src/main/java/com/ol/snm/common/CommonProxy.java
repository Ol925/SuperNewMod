package com.ol.snm.common;

import com.ol.snm.block.BlockLoader;
import com.ol.snm.crafting.CraftingLoader;
import com.ol.snm.creativetab.CreativeTabsLoader;
import com.ol.snm.item.ItemLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event)
    {
        new ConfigLoader(event);
        new EventLoader();
        new CreativeTabsLoader(event);
        new ItemLoader(event);
        new BlockLoader(event);

    }

    public void init(FMLInitializationEvent event)
    {
        new CraftingLoader();
    }

    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
