package com.ol.snm.common;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class EventLoader {
    public EventLoader()
    {
        MinecraftForge.EVENT_BUS.register(this);//在forge总线中注册所有
        EventLoader.EVENT_BUS.register(this);//在自己的总线里面注册
    }

    @SubscribeEvent
    public void onPlayerItemPickup(PlayerEvent.ItemPickupEvent event)
    {
        if (event.player.isServerWorld())
        {
            String info = String.format("%s picks up: %s", event.player.getName(), event.pickedUp.getEntityItem());
            ConfigLoader.logger().info(info);
        }
    }

    @SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent event)
    {
        if (!event.world.isRemote)
        {
            String info = String.format("%s interacts with: %s", event.entityPlayer.getName(), event.pos);
            ConfigLoader.logger().info(info);
        }
    }
    //@SubscribeEvent注解的作用是Forge在你注册这个类的时候，会扫描所有具有该注解的方法，然后挂钩。 Forge会根据方法的参数类型来区分不同的事件。比如，这里的onPlayerItemPickup方法挂钩的就是物品即将被捡起的时候触发的事件PlayerEvent.ItemPickupEvent，而onPlayerInteract方法挂钩的就是玩家在和物品或方块互动的时候触发的事件PlayerInteractEvent
    @Cancelable
    public static class PlayerRightClickGrassBlockEvent extends net.minecraftforge.event.entity.player.PlayerEvent
    {
        public final BlockPos pos;
        public final World world;

        public PlayerRightClickGrassBlockEvent(EntityPlayer player, BlockPos pos, World world)
        {
            super(player);
            this.pos = pos;
            this.world = world;

        }
    }
    //@Cancelable注解的作用是 该事件可被取消,这里是写一个新的事件类，和玩家右键方块有关
    public static final EventBus EVENT_BUS = new EventBus();//创建一个自己的事件总线

    @SubscribeEvent
    public void onPlayerClickGrassBlock(PlayerRightClickGrassBlockEvent event)
    {
        if (!event.world.isRemote)
        {
            BlockPos pos = event.pos;
            Entity tnt = new EntityTNTPrimed(event.world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, null);
            event.world.spawnEntityInWorld(tnt);
        }
    }
    //玩家右键草块的时候在世界里放置一个点燃的TNT
}


