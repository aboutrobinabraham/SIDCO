package com.pageObjects;


//LoginPage.
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
 private WebDriver driver;

 // Selectors
 private By emailField = By.name("email");
 private By passwordField = By.name("password");
 private By loginButton = By.xpath("//button[@type='submit']");
 private By forgotPasswordLink = By.xpath("//a[text()='Forgot your password?']");
 private By googleButton = By.xpath("//button[contains(text(), 'Continue with Google')]");
 private By facebookButton = By.xpath("//button[contains(text(), 'Continue with Facebook')]");
 private By Username=By.xpath("//label[normalize-space()='User robin']");
 private By SignIn=By.xpath("//p[@class='block text-sm text-black font-bold -mt-1']");
 private By AccountButton=By.xpath("//p[contains(text(),'Account')]");
 private By logOutButton=By.xpath("//p[@class='flex items-center justify-start gap-3 text-slate-950 cursor-pointer']");
 private By logOutConfirmButton=By.xpath("//button[contains(text(),'Logout')]");
 
 
 public LoginPage(WebDriver driver)
 {
	 this.driver=driver;
 }
 
public void clickSignin(){
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(SignIn));
	 element.click();
	
	}
public void verifySignin(){
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
	 
	
	}
 public void enterEmail(String email) {
     driver.findElement(emailField).sendKeys(email);
 }

 public void enterPassword(String password) {
     driver.findElement(passwordField).sendKeys(password);
 }

 public void clickLoginButton() {
     driver.findElement(loginButton).click();
 }

 public void clickForgotPasswordLink() {
     driver.findElement(forgotPasswordLink).click();
 }

 public void clickGoogleButton() {
     driver.findElement(googleButton).click();
 }

 public void clickFacebookButton() {
     driver.findElement(facebookButton).click();
 }

 public boolean isLoginButtonEnabled() {
     return driver.findElement(loginButton).isEnabled();
 }

 public void clearEmail() {
     driver.findElement(emailField).clear();
 }

 public void clearPassword() {
     driver.findElement(passwordField).clear();
 }
 
 public boolean verifyLogin()
 {
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     
     WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Username));
	 if (element.getText().contains("User"))
	{
		 return true;
	 }
	 else
	 {
		 return false;
		 
		 
	 }
 }
 
 public void logOut()
 {
	 driver.findElement(AccountButton).click();
	 driver.findElement(logOutButton).click();
	 driver.findElement(logOutConfirmButton).click();	 
 }
}