package com.pageObjects;

import org.openqa.selenium.WebDriver;
import java.util.UUID;

import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
WebDriver driver;

public BasePage(WebDriver driver) {
	
	PageFactory.initElements(driver, this);
    //this.driver=driver;
	
	
	
}

public static String generateRandomEmail() {
    return "user" + UUID.randomUUID().toString().substring(0, 8) + "@test.com";
}


}
