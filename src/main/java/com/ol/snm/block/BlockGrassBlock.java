package com.ol.snm.block;

import com.ol.snm.common.EventLoader;
import com.ol.snm.creativetab.CreativeTabsLoader;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockGrassBlock extends Block{
    public BlockGrassBlock() {
        super(Material.ground);
        this.setUnlocalizedName("grass_block");
        this.setHardness(0.5F);
        this.setStepSound(Block.soundTypeGrass);
        this.setResistance(666.0F);
        this.setCreativeTab(CreativeTabsLoader.tabSnm);
    }
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
                                    EnumFacing side, float hitX, float hitY, float hitZ)
    {
        EventLoader.PlayerRightClickGrassBlockEvent event;
        event = new EventLoader.PlayerRightClickGrassBlockEvent(playerIn, pos, worldIn);
        EventLoader.EVENT_BUS.post(event);//post是发布事件的方法，即让事件上车
        //上面三句用于在该方块使用事件
        if (!event.isCanceled() && !worldIn.isRemote)//!worldIn.isRemote意思是  不是客户端 客户端是服务端的远程
        {
            worldIn.setBlockToAir(pos);
            return true;
        }
        return false;
    }
}
