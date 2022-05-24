package com.bagal.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.bagal.constants.ReqResConstants;

import java.util.Objects;

public final class ExtentReport {
    private ExtentReport(){}
    private static ExtentReports extentReports;
    public static void initReport(){
        if(Objects.isNull(extentReports)){
            extentReports = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(ReqResConstants.getExtentReportPath());
            spark.config().setDocumentTitle("ReqRes Assignment Test");
            spark.config().setReportName("Umaji Bagal - ReqRes Post Api Demo Test");
            spark.config().setTheme(Theme.DARK);
            extentReports.attachReporter(spark);
        }
    }
    public static void createExtentText(String testCaseName){
         ExtentManager.setExtentTest(extentReports.createTest(testCaseName));
    }
    public static void flushReport(){
        if (Objects.nonNull(extentReports)){
            extentReports.flush();
        }
    }
}
