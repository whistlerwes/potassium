package com.potassium;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class PotassiumClient implements ClientModInitializer {
    public static final int MAX_FPS = 10;

    @Override
    public void onInitializeClient() {
        // Keep the vanilla "Max Framerate" option pinned to 10.
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            var limit = client.options.framerateLimit();
            if (limit.get() != MAX_FPS) {
                limit.set(MAX_FPS);
            }
        });
    }
}
