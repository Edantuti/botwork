package com.github.husky.command;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import com.github.husky.Constant;

public class CommandHandler extends ListenerAdapter{
    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        if(event.getMessage().getContentRaw().substring(0,1).equals(Constant.PREFIX)){
            CommandExecutor.execute(getCommandName(event.getMessage().getContentRaw()), event);
        }
    }

    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){
        CommandExecutor.execute(event.getName(), event);
        
    }

    public String getCommandName(String msg){
        return msg.substring(1);
    }
    
}
