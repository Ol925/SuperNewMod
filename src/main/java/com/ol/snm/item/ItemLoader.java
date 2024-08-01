package com.ol.snm.item;

import net.minecraft.client.resources.model.ModelResourceLocation;//模型资源位置
import net.minecraftforge.client.model.ModelLoader;//模型加载器
import net.minecraftforge.fml.relauncher.Side;//标记代码位置
import net.minecraftforge.fml.relauncher.SideOnly;//用于模型加载

import net.minecraft.item.Item;//导入物品类
import net.minecraftforge.fml.common.registry.GameRegistry;//注册游戏物品
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;//预初始化事件



public class ItemLoader {
    public static Item goldenEgg = new ItemGoldenEgg();//此处的goldenEgg是注册的非本地化名称
    public static Item redstonePickaxe = new ItemRedstonePickaxe();

    public ItemLoader(FMLPreInitializationEvent event)
    {
        register(goldenEgg, "golden_egg");
        register(redstonePickaxe,"rP");
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders()
    {
        registerRender(goldenEgg);
        registerRender(redstonePickaxe);
    }




    private static void register(Item item, String name)
    {
        GameRegistry.registerItem(item.setRegistryName(name));
    }

    @SideOnly(Side.CLIENT)
    private static void registerRender(Item item)
    {
        ModelResourceLocation model = new ModelResourceLocation(item.getRegistryName(), "inventory");
        ModelLoader.setCustomModelResourceLocation(item, 0, model);
    }
}
