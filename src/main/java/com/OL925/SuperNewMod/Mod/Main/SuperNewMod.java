package com.ol925.supernewmod.mod.Main;

import com.ol925.supernewmod.mod.common.CommonProxy;
import net.minecraftforge.fml.common.SidedProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author OL925
 */
@Mod(modid = SuperNewMod.MODID, name = SuperNewMod.NAME, version = SuperNewMod.VERSION, acceptedMinecraftVersions = "1.8.9")
public class SuperNewMod
{
    public static final String MODID = "supernewmod";
    public static final String NAME = "SuperNewMod";
    public static final String VERSION = "1.0.0";

    @Instance(SuperNewMod.MODID)
    public static SuperNewMod instance;

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

    @SidedProxy(clientSide = "com/ol925/supernewmod/mod/client/ClientProxy.java",
            serverSide = "com/ol925/supernewmod/mod/common/CommonProxy.java")
    public static CommonProxy proxy;

}