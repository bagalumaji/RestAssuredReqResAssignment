package com.bagal.reports;

import com.aventstack.extentreports.ExtentTest;

import java.util.Objects;

public final class ExtentManager {
    private ExtentManager(){}

    private static final ThreadLocal<ExtentTest> THREAD_LOCAL = new ThreadLocal<>();

    public static ExtentTest getExtentText(){
        return THREAD_LOCAL.get();
    }

    public static void setExtentTest(ExtentTest extentTest){
        if(Objects.nonNull(extentTest)){
            THREAD_LOCAL.set(extentTest);
        }
    }

    private static void unload(){
        THREAD_LOCAL.remove();
    }

}
