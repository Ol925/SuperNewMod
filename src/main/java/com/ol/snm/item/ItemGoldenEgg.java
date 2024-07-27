package com.ol.snm.item;

import net.minecraft.item.Item;

import com.ol.snm.creativetab.CreativeTabsLoader;//用于讲物品注册到创造模式物品栏


public class ItemGoldenEgg extends Item{
    public ItemGoldenEgg()
    {
        super();
        this.setUnlocalizedName("goldenEgg");//注册非本地化名称
        this.setCreativeTab(CreativeTabsLoader.tabSnm);//创造模式物品栏里面注册

    }

}
