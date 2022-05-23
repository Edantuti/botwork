package com.github.husky.command.user;

import com.github.husky.database.DataClass;
import com.github.husky.database.DatabaseHandler;

import net.dv8tion.jda.api.entities.MessageChannel;

public class Users {
    public static void registerUser(long nameid, long serverid,MessageChannel channel){
        if(!checkUserData(nameid, serverid)){
            DataClass data = new DataClass(nameid, serverid);
            DatabaseHandler.insertData( DatabaseHandler.makeConnection(),data);
            channel.sendMessage("Registered").queue();
        }else{
            channel.sendMessage("Already Registered").queue(); 
        }
        
    }
    public static void alterUserData(long nameid, long serverid, int value)
    {
        if(checkUserData(nameid, serverid)){
            DataClass data = new DataClass(nameid, serverid, value);
            DatabaseHandler.alterData(DatabaseHandler.makeConnection(),data);
        }else{
            DataClass data = new DataClass(nameid, serverid, value);
            DatabaseHandler.makeConnection();
            DatabaseHandler.insertData(DatabaseHandler.makeConnection(),data);
        }
    }
    public static boolean checkUserData(long nameid, long serverid){
        DataClass data = new DataClass(nameid, serverid);
        DatabaseHandler.makeConnection();

        return DatabaseHandler.checkUser(DatabaseHandler.makeConnection(),data);
    }
}
