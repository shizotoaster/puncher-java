package net.shizotoaster.puncher.event;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.Nullable;

public class AttackEntityHandler implements AttackEntityCallback {
    @Override
    public InteractionResult interact(Player player, Level world, InteractionHand hand, Entity entity, @Nullable EntityHitResult hitResult) {
        if (!world.isClientSide() && !player.isSpectator() && player.isCrouching()) {
            if (Boat.class.isAssignableFrom(entity.getClass()) || AbstractMinecart.class.isAssignableFrom(entity.getClass())) {
                entity.hurt(entity.damageSources().generic(), 100000000000000000F);
            }
        }

        return InteractionResult.PASS;
    }
}
