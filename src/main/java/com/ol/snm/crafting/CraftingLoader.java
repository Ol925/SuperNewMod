package com.ol.snm.crafting;

import com.ol.snm.block.BlockLoader;
import com.ol.snm.item.ItemLoader;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CraftingLoader {
    public CraftingLoader() {
        registerRecipe();
        registerSmelting();
        registerFuel();
    }
    private static void registerRecipe()
    {
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.goldenEgg), new Object[]
                {
                        "###", "#*#", "###", '#', Items.gold_ingot, '*', Items.egg
                });
        GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.grassBlock), new Object[]
                {
                        "##", "##", '#', Blocks.vine
                });
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.vine, 4), BlockLoader.grassBlock);
    }

    private static void registerSmelting()
    {
        GameRegistry.addSmelting(BlockLoader.grassBlock, new ItemStack(Items.coal), 1.0f);
    }

    private static void registerFuel()
    {
        GameRegistry.registerFuelHandler(new IFuelHandler()
        {
            @Override
            public int getBurnTime(ItemStack fuel)
            {
                return Items.diamond != fuel.getItem() ? 0 : 114514;
            }
        });

        GameRegistry.registerFuelHandler(new IFuelHandler()
        {
            @Override
            public int getBurnTime(ItemStack fuel)
            {
                return Items.wheat != fuel.getItem() ? 0 : 114514;
            }
        });
    }
}
