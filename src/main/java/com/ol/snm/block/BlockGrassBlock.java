package com.ol.snm.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockGrassBlock extends Block{
    public BlockGrassBlock() {
        super(Material.ground);
        this.setUnlocalizedName("grass_block");
        this.setHardness(0.5F);
        this.setStepSound(Block.soundTypeGrass);
        this.setResistance(666.0F);

    }

}
