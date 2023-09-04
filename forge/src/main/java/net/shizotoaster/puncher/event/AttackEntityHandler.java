package net.shizotoaster.puncher.event;

import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "puncher")
public class AttackEntityHandler {
    @SubscribeEvent
    public static void onEntityAttacked(AttackEntityEvent event) {
        if (Boat.class.isAssignableFrom(event.getTarget().getClass()) || AbstractMinecart.class.isAssignableFrom(event.getTarget().getClass())) {
            event.getTarget().hurt(event.getTarget().damageSources().generic(), 100000000000000000F);
        }
    }
}
