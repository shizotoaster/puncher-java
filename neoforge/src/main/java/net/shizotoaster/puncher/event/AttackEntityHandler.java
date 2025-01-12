package net.shizotoaster.puncher.event;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
//? if >=1.21.2
import net.minecraft.entity.vehicle.AbstractBoatEntity;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
//? if <1.21.2
/*import net.minecraft.entity.vehicle.BoatEntity;*/
import net.minecraft.server.world.ServerWorld;
import net.neoforged.bus.api.SubscribeEvent;
//? if >=1.20.5
import net.neoforged.fml.common.EventBusSubscriber;
//? if <1.20.5
/*import net.neoforged.fml.common.Mod;*/
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;

//? if <1.20.5 {
/*@Mod.EventBusSubscriber(modid = "puncher")
*///?} else {
@EventBusSubscriber(modid = "puncher")
//?}
public class AttackEntityHandler {
    @SubscribeEvent
    public static void onEntityAttacked(AttackEntityEvent event) {
        PlayerEntity player = event.getEntity();
        Entity target = event.getTarget();
        if (player.getWorld() instanceof ServerWorld serverWorld && !player.isSpectator() && player.isSneaking()) {
            if (/*? if <1.21.2 {*//*BoatEntity*//*?} else {*/AbstractBoatEntity/*?}*/.class.isAssignableFrom(target.getClass()) ||
                AbstractMinecartEntity.class.isAssignableFrom(target.getClass())) {
                //? if <1.21.2 {
                /*target.damage(target.getDamageSources().generic(), Float.MAX_VALUE);
                *///?} else {
                target.damage(serverWorld, target.getDamageSources().generic(), Float.MAX_VALUE);
                //?}
            }
        }
    }
}
