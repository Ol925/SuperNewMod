package com.ol.snm.client;

import com.ol.snm.block.BlockLoader;
import com.ol.snm.item.ItemLoader;

public class ItemRenderLoader {
    public ItemRenderLoader()
    {
        ItemLoader.registerRenders();
        BlockLoader.registerRenders();
    }
}
