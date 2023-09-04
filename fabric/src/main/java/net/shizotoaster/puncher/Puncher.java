package net.shizotoaster.puncher;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.shizotoaster.puncher.event.AttackEntityHandler;

public class Puncher implements ModInitializer {
    @Override
    public void onInitialize() {
        AttackEntityCallback.EVENT.register(new AttackEntityHandler());
    }
}
