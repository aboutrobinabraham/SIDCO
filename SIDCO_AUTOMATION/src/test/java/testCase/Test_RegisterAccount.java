package testCase;

import org.testng.annotations.Test;

import com.pageObjects.RegistrationPage;

import testBase.BaseClass;
import com.aventstack.extentreports.MediaEntityBuilder;


public class Test_RegisterAccount extends BaseClass {
	
	@Test
    public void login() throws InterruptedException {
		
		
        extentTest.info("Starting login test");
 
        RegistrationPage log = new RegistrationPage(driver);
        log.loginpageNav();
        extentTest.info("Navigated to login page");
        Thread.sleep(3000);
        log.registerButton();
        extentTest.info("Clicked Register Button");
 
        log.NameField("User 1");
        extentTest.info("Entered Name");
 
        log.phoneField();
        extentTest.info("Entered Phone Number");
 
        log.regiseremailField("user1@ytu.xid");
        extentTest.info("Entered Email");
 
        log.password("Qwerty@1234");
        extentTest.info("Entered Password");
 
        log.termsCheckbox();
        extentTest.info("Checked Terms & Conditions");
 
        log.RegisterConfirmButton();
        extentTest.pass("Registration successful");
        String screenshotPath = captureScreenshot("CheckoutClicked");
        
        extentTest.info("Screenshot after clicking Checkout",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        
        Thread.sleep(3000);
        
        
    }

}
