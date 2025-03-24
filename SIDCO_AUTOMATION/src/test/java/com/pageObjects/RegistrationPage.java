package com.pageObjects;
 
import java.util.Random;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.FindBy;
 
public class  RegistrationPage extends BasePage{

	public RegistrationPage(WebDriver driver) {

		super(driver);

		this.actions=new Actions(driver);

	}
 
	@FindBy(xpath="//span[@class=\"block\"]")

	WebElement loginpageNav;

	@FindBy(xpath="//li[@class=\"w-1/2 md:w-full\"][2]//a[text()=\"Register\"]")

	WebElement registerButton;
 
	@FindBy(xpath="//input[@name=\"name\"]")

	WebElement NameField;

	@FindBy(name="mobile")

	WebElement phoneField;

	@FindBy(xpath="//input[@name=\"email\" and @placeholder=\"Enter your email address\"]")

	WebElement registeremailField;

	@FindBy(xpath="//input[@name=\"password\"]")

	WebElement password;

	@FindBy(xpath="//input[@id=\"terms\"]")

	WebElement termsCheckbox;

	@FindBy(xpath="//button[@type=\"submit\" and text()=\"Register\"]")

	WebElement RegisterConfirmButton;

//	Action Methods

	Actions actions;

	public void loginpageNav() {

		loginpageNav.click();

	}
 
	public void registerButton() {

		registerButton.click();

	}
 
	public void NameField(String Name) {

		NameField.sendKeys(Name);

	}

	public void phoneField() {

		phoneField.sendKeys(generateMobileNumber());

	}

	public void regiseremailField(String emailId) {

		registeremailField.sendKeys(emailId);

	}

	public void password(String pass) {

		password.sendKeys(pass);

	}

	public void termsCheckbox()

	{

		actions.moveToElement(termsCheckbox).click().perform();

	}

	public void RegisterConfirmButton() {

		actions.moveToElement(RegisterConfirmButton).click().perform();

	}
	
	public static String generateMobileNumber() 
	{        
	 Random random = new Random();        
	 String mobileNumber = "9"; // Ensuring it starts with 9 (you can change this)
	for (int i = 0; i < 8; i++)
	 {            
	 mobileNumber += random.nextInt(10); // Generate random digits (0-9)
	 }
	 return mobileNumber; }

}

 