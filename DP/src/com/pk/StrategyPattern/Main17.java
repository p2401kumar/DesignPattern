package com.samsung.StrategyPattern;

interface LoggerInterface {
    void logException(Exception e);
    void logMessage(String message);
}

class LocalFileLogger implements LoggerInterface {
    @Override
    public void logException(Exception e) {

    }

    @Override
    public void logMessage(String message) {

    }
}

class RemoteFileLogger implements LoggerInterface {
    @Override
    public void logException(Exception e) {

    }

    @Override
    public void logMessage(String message) {

    }
}

class Logger {
    LoggerInterface li;
    public void setogger(LoggerInterface li){
        this.li = li;
    }

    public void logException(Exception e){
        this.li.logException(e);
    }

    public void logMessage(String message){
        this.li.logMessage(message);
    }
}

public class Main17 {
    public static void main(String[] args) {
        
    }
}
