package com.github.husky;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import com.github.husky.command.CommandHandler;

/**
 * Hello world!
 */
public class App{
    public static void main(String[] args) throws LoginException{
        JDA jda = JDABuilder.createLight(Constant.TOKEN, GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES)
                                        .addEventListeners(new CommandHandler())
                                        .setActivity(Activity.playing("hello world!"))
                                        .build();
        jda.upsertCommand("ping", "send Pong");
        jda.upsertCommand("hello", "Hello there!");
    }
}
