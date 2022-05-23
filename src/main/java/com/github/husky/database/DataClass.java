package com.github.husky.database;

public class DataClass {
    long nameId;
    int response;
    long serverId;

    public DataClass(long nameId, long serverId, int response){
        this.nameId = nameId;
        this.response = response;
        this.serverId = serverId;
    }
    public DataClass(long nameId, long serverId){
        this.nameId = nameId;
        this.serverId = serverId;
    }
}
