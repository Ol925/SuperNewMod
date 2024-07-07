package com.ol.snm.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockLoader {
    public static Block grassBlock = new BlockGrassBlock();

    public BlockLoader(FMLPreInitializationEvent event) {
        register(grassBlock, "grass_block");
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders()
    {
        registerRender(grassBlock);
    }

    public static void register(Block block, String name) {
        GameRegistry.registerBlock(block.setRegistryName(name));
    }

    @SideOnly(Side.CLIENT)
    public static void registerRender(Block block){
        ModelResourceLocation model = new ModelResourceLocation(block.getRegistryName(), "inventory");
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, model);
    }
}
