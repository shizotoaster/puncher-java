package net.shizotoaster.puncher.event;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
//? if >=1.21.2
import net.minecraft.entity.vehicle.AbstractBoatEntity;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
//? if <1.21.2
/*import net.minecraft.entity.vehicle.BoatEntity;*/
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class AttackEntityHandler implements AttackEntityCallback {
    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, Entity entity, @Nullable EntityHitResult hitResult) {
        if (world instanceof ServerWorld serverWorld && !player.isSpectator() && player.isSneaking()) {
            if (/*? if <1.21.2 {*//*BoatEntity*//*?} else {*/AbstractBoatEntity/*?}*/.class.isAssignableFrom(entity.getClass()) ||
                AbstractMinecartEntity.class.isAssignableFrom(entity.getClass())) {
                //? if <1.21.2 {
                /*entity.damage(entity.getDamageSources().generic(), Float.MAX_VALUE);
                *///?} else {
                entity.damage(serverWorld, entity.getDamageSources().generic(), Float.MAX_VALUE);
                //?}
            }
        }

        return ActionResult.PASS;
    }
}
