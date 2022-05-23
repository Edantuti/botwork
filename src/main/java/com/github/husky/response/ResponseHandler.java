package com.github.husky.response;

public class ResponseHandler {
    private int responses;
    private int timeout;
    private int totalResponses;

    public int getResponses(){
        return responses;
    }

    public int getTotalResponses(){
        return totalResponses;
    }

    public void setTimeout(int timeout){
        this.timeout = timeout;
    }
}
