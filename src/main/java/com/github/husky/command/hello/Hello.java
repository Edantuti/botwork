package com.github.husky.command.hello;

import net.dv8tion.jda.api.entities.MessageChannel;

public class Hello {
    public static void sendHello(MessageChannel channel){
        channel.sendMessage("Hello there!").queue();
    }
}
