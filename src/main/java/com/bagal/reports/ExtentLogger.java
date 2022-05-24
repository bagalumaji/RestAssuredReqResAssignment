package com.bagal.reports;

public final class ExtentLogger {
    private ExtentLogger(){}

    public static void pass(String message){
        ExtentManager.getExtentText().pass(message+" is passed");
    }

    public static void info(String message){
        ExtentManager.getExtentText().info(message);
    }
    public static void skip(String message){
        ExtentManager.getExtentText().skip(message+" is skipped");
    }
    public static void fail(String message){
        ExtentManager.getExtentText().pass(message+" is failed");
    }
}
