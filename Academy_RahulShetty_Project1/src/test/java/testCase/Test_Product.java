package testCase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pageObjects.LoginPage;
import com.pageObjects.ProductPage;

import testBase.BaseClass;
import utilities.ExtentReport;

public class Test_Product extends BaseClass {
	private ProductPage pg;
	private String product="Chicken";
	private String email="robinab@gmail.com";
	String screenshotPath;
	
	
	@BeforeClass
	public void login() throws InterruptedException
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail("robinab@gmail.com");
        loginPage.enterPassword("Robin11$");
        Thread.sleep(3000);
        extentTest.info("Starting logging test");

        loginPage.clickSignin();
        extentTest.info("clicked sign in");
       
        loginPage.clickLoginButton();
        extentTest.info("clicked login");
        
       
        Assert.assertTrue(loginPage.verifyLogin(),"failed to login the user " + email );
        
        captureScreenShot2("After Login",extentTest);

        pg = new ProductPage(driver);
	}
	
	@Test(priority = 1)
	public void testSearch() throws InterruptedException
	{
		extentTest=ExtentReport.createTest("Test Search Product");
		Thread.sleep(3000);
		pg.SearchProduct(product);
		
		extentTest.info("clicked Search for product");
		Thread.sleep(3000); 
		
		captureScreenShot2("SearchClicked",extentTest);
		
		boolean result=pg.VerifySearch(product);
		
		extentTest.info("Verifying Search");
	    Thread.sleep(3000);
	    
	    captureScreenShot2("Verifying Search",extentTest);

		Assert.assertTrue(result, "Search verification failed for product: " + product);
		
		
	}
	

	@Test(priority=3 ,dependsOnMethods = "testSearch")
	public void brandNameVerification() throws InterruptedException {
		
		extentTest=ExtentReport.createTest("Test Product and Details");
		
		//pg.SearchProduct(product);
		extentTest.info("clicked Search for product");
		captureScreenShot2(product, extentTest);
		
		pg.brandsFilter();
		String ExpectedBrandName=pg.firstBrandName();
		pg.clickfirstBrandName();
		extentTest.info("clicked brands filter");
		captureScreenShot2("Brand name", extentTest);
		
		String ExpectedProductName=pg.firstProductName();
		pg.firstProductDetailsPage();
		extentTest.info("Moved to products details Page");
		captureScreenShot2("Details Page", extentTest);
		
		String ActualBrandName=pg.brandNameinDetailsPageVerify();
		String ActualProductName=pg.productNameinDetailsPageVerify();
		
		Assert.assertEquals(ActualBrandName,ExpectedBrandName , "Brand is different");
		Assert.assertEquals(ActualProductName,ExpectedProductName , "Product is different");
		extentTest.info("Verified product and brand name");
		
	}
	
	@Test(priority=2,dependsOnMethods = "testSearch")
	public void testFilter() throws InterruptedException
	{
		Thread.sleep(3000);
		extentTest=ExtentReport.createTest("Test Filter");
		
		
		Thread.sleep(3000); 
		
		String Filter=pg.ClickFilter();
		extentTest.info("clicked Filter for product");
		captureScreenShot2("Filter Applied",extentTest);
		
		Assert.assertTrue(pg.Verifyfilter(), "Search verification failed for product: " + Filter);
		extentTest.info("Verified  Filter for product");
		captureScreenShot2("Verified  Filter by resetting filter",extentTest);
		
		
	}
	
	@Test(dependsOnMethods = "testFilter")
	public void testAddtoCart() throws InterruptedException
	{
		
		pg.EmptyCart();
		extentTest=ExtentReport.createTest("Test Add to cart");
		extentTest.info("Cart Emptied");
		captureScreenShot2("Cart Emptied", extentTest);
        Thread.sleep(3000);
        
        
		String AddedProduct=pg.AddToCart(driver);
		extentTest.info("Products added");
		captureScreenShot2("Products Added", extentTest);

		
		Assert.assertEquals(pg.VerifyCart(),AddedProduct,"Product not added to Cart: " + AddedProduct );
		extentTest.info("Verified cart");
		captureScreenShot2("Verified cart",extentTest);
		
	}
	
	
	@Test(dependsOnMethods = "testAddtoCart")
	public void testCheckOut() throws InterruptedException
	{
		Thread.sleep(3000);
		extentTest=ExtentReport.createTest("Test CheckOut");
		
		pg.Checkout();
		extentTest.info("Clicked checkout");
		captureScreenShot2("Clicked checkout",extentTest);
		

		
		pg.clickPayment();
		extentTest.info("Clicked Payment");
		captureScreenShot2("Clicked Payment",extentTest);
		
		Assert.assertEquals(pg.verifyPayment(),"Pay Now","Proceed to payment online failed" );
		
		extentTest.info("Verified  Payment");
		captureScreenShot2("Verified Payment",extentTest);
		
		
	}
	
	@AfterClass
	public void LogOut()
	{	
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.logOut();		
		
	}
	

}
