package com.github.husky.command.ping;

import net.dv8tion.jda.api.entities.MessageChannel;

public class Ping {
    public static void getPing(MessageChannel channel){
        long time = System.currentTimeMillis();
        channel.sendMessage("Pong!")
        .queue(response -> {
            response.editMessageFormat("Pong!, %d ms", System.currentTimeMillis()-time);
        });
    }
}
