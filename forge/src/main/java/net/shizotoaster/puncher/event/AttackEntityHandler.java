package net.shizotoaster.puncher.event;


import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "puncher")
public class AttackEntityHandler {
    @SubscribeEvent
    public static void onEntityAttacked(AttackEntityEvent event) {
        PlayerEntity player = event.getEntity();
        Entity target = event.getTarget();
        if (player.getWorld() instanceof ServerWorld serverWorld && !player.isSpectator() && player.isSneaking()) {
            if (BoatEntity.class.isAssignableFrom(target.getClass()) ||
                AbstractMinecartEntity.class.isAssignableFrom(target.getClass())) {
                target.damage(target.getDamageSources().generic(), Float.MAX_VALUE);
            }
        }
    }
}
