package utilities;
 
import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
 
public class ExtentReport {

    private static ExtentReports extent;

    private static ExtentTest test;
 
    public static void setupExtentReport() {

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("ExtentReport.html");

        extent = new ExtentReports();

        extent.attachReporter(sparkReporter);

    }
 
    public static ExtentTest createTest(String testName) {

        test = extent.createTest(testName);

        return test;

    }
 
    public static void flushReport() {

        extent.flush();

    }

}

 
