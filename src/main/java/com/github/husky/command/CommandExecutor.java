package com.github.husky.command;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import com.github.husky.command.ping.Ping;
import com.github.husky.command.user.Users;
import com.github.husky.command.hello.Hello;

public class CommandExecutor{
    
    public static void execute(String name, MessageReceivedEvent event){
        Message msg = event.getMessage();
        MessageChannel channel = msg.getChannel();
        switch(name){
            case "ping": Ping.getPing(channel);
                         break;
            case "hello": Hello.sendHello(channel);
                         break;
            case "register": Users.registerUser(msg.getAuthor().getIdLong(), msg.getGuild().getIdLong(), channel);
                             break;
            default: channel.sendMessage("No such command exist");
        }
    
    }
    public static void execute(String name, SlashCommandInteractionEvent event){
        MessageChannel channel = event.getChannel();
        switch(name){
            case "ping": Ping.getPing(channel);
                         break;
            case "hello": Hello.sendHello(channel);
                         break;
            case "feed" : break;
            default: channel.sendMessage("No such command exist");
        }
    
    }

}
