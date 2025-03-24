package testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pageObjects.LoginPage;

import testBase.BaseClass;

public class Test_Login extends BaseClass  {
    @Test
    public void testValidLogin() throws InterruptedException {
    	
    	LoginPage loginPage = new LoginPage(driver);
    	String email="robinab@gmail.com";
    	String password="Robin11$";
    	
		loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        Thread.sleep(3000);
        extentTest.info("Starting logging test");

        loginPage.clickSignin();
        extentTest.info("clicked sign in");
       
        loginPage.clickLoginButton();
        extentTest.info("clicked login");
        
       
        Assert.assertTrue(loginPage.verifyLogin(),"failed to login the user " + email );
        
        captureScreenShot2("After Login",extentTest);

        
    }
}
    
   

    
