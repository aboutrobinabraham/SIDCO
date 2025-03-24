
package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import utilities.ExtentReport;

public class BaseClass {

    public WebDriver driver;
    public Logger logger;
    public Properties prop;
    public  ExtentTest extentTest; 
    String screenshotPath;

    @BeforeClass
    @Parameters({"os", "browser"})
    public void setUp(String OS, String br) throws IOException {
        // Load config.properties
        FileReader reader = new FileReader(System.getProperty("user.dir") + "/src/test/resources/config.properties");
        prop = new Properties();
        prop.load(reader);

        // Initialize logger
        logger = LogManager.getLogger(this.getClass());

        // Browser setup
        switch (br.toLowerCase()) {
            case "chrome":  
                driver = new ChromeDriver(); 
                break;
            case "edge":  
                driver = new EdgeDriver(); 
                break;
            default:
                throw new IllegalArgumentException("Invalid browser: " + br);
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        
        driver.get(prop.getProperty("baseurl"));
        
        // Setup Extent Report
        ExtentReport.setupExtentReport();
        extentTest = ExtentReport.createTest("Test Execution");
    }

    /**
     * Captures a screenshot and attaches it to the Extent Report.
     */
    public String captureScreenshot(String testName) {
        try {
            // Take screenshot
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            
            // Define screenshot path
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String screenshotPath = System.getProperty("user.dir") + "/Screenshots/" + testName + "_" + timestamp + ".png";
            
            // Save screenshot
            File dest = new File(screenshotPath);
            src.renameTo(dest);
            
            return screenshotPath;
        } catch (Exception e) {
            logger.error("Screenshot capture failed: " + e.getMessage());
            return null;
        }
    }
    
    public void captureScreenShot2(String Message,ExtentTest extentTest)
    
    {
    	screenshotPath = captureScreenshot(Message);
        extentTest.info("Screenshot of "+Message,
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    	
    }

    /**
     * Takes a screenshot on test failure and logs it to Extent Report.
     */
    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = captureScreenshot(result.getName());
            if (screenshotPath != null) {
                extentTest.fail("Test Failed: " + result.getThrowable(),
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            }
            else 
            {
                extentTest.fail("Test Failed: " + result.getThrowable());
            	
            }
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        ExtentReport.flushReport();
    }
}

