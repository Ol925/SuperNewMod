package com.ol.snm;

import com.ol.snm.common.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author OL925
 */
@Mod(modid = SNM.MODID, name = SNM.NAME, version = SNM.VERSION, acceptedMinecraftVersions = "1.8.9")
public class SNM {
    public static final String MODID = "snm";
    public static final String NAME = "SuperNewMod";
    public static final String VERSION = "1.0.0";

    @Instance(SNM.MODID)
    public static SNM instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }

    @SidedProxy(clientSide = "com.ol.snm.client.ClientProxy",
            serverSide = "com.ol.snm.common.CommonProxy")
    public static CommonProxy proxy;
}
