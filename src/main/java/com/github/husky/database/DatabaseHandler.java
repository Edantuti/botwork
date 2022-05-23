package com.github.husky.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.github.husky.Constant;

public class DatabaseHandler {
    public static Connection makeConnection(){
        Properties prop = new Properties();
        Connection connection = null;
        try{
            Class.forName("org.postgresql.Driver");
            prop.setProperty("port", "5432");
            prop.setProperty("user", Constant.DB_USERNAME);
            prop.setProperty("password", Constant.DB_PASSWORD);
            connection = DriverManager.getConnection(Constant.DB_URL, prop);
            
        }catch(Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName()+" : "+e.getMessage());
            System.exit(0);
        }
        return connection;
    }
    public static void insertData(Connection connection, DataClass data){
        PreparedStatement statement;
        try{
            String sql = "INSERT INTO userTable(nameid, serverid) "+"VALUES(?,?)";
            statement = connection.prepareStatement(sql);
            statement.setLong(1, data.nameId);
            statement.setLong(2, data.serverId);
            statement.executeUpdate();
            statement.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void alterData(Connection connection, DataClass data){
        PreparedStatement statement;
        try{
            String sql = "UPDATE usertable SET responses=? WHERE nameid=? AND serverid=? ;";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, data.response);
            statement.setLong(2, data.nameId);
            statement.setLong(3, data.serverId);
            statement.executeUpdate();
            statement.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static boolean checkUser(Connection connection, DataClass data){
        PreparedStatement statement;
        ResultSet result;
        boolean check=false;
        try{
            if(!checkServer(connection, data)){
                String sql = "SELECT EXISTS(SELECT ? FROM USERTABLE WHERE SERVERID=?)";
                statement = connection.prepareStatement(sql);
                statement.setLong(1, data.nameId);
                statement.setLong(2, data.serverId);
                statement.execute();
                result = statement.getResultSet();
                check = result.next();
                statement.close();
            } 
        }catch(Exception e){
            e.printStackTrace();
        }
        return check;
        
    }
    public static boolean checkServer(Connection connection, DataClass data){
        PreparedStatement statement;
        ResultSet result;
        boolean check=false;
        try{
            String sql = "SELECT EXISTS(SELECT ? FROM USERTABLE WHERE SERVERID=?)";
            statement = connection.prepareStatement(sql);
            statement.setLong(1, data.nameId);
            statement.setLong(2, data.serverId);
            statement.execute();
            result = statement.getResultSet();
            check=result.next();
            statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return check;
    }
}
