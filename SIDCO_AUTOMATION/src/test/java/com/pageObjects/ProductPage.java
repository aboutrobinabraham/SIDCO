package com.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPage extends BasePage  {
	
	Actions actions;
	
	public ProductPage(WebDriver driver) 
	{
		super(driver);
		this.actions=new Actions(driver); 
		this.driver=driver;
	}
	
	@FindBy(xpath="//input[@placeholder='Search for any delicious product']")
	WebElement SearchBar;
	
	@FindBy(tagName="h5")
	WebElement products;
	
	@FindBy(xpath="//button[normalize-space()='Clear']")
		WebElement ClearButton;
	
	@FindBy(xpath="//div[@class=\"col-span-4 lg:col-span-3 self-center gap-2 flex items-center\"]//div//h5//span")
		WebElement ResultCount;
	
	@FindBy(xpath = "//*[contains(@class, 'flex justify-start items-center')]")
	List<WebElement> ItemsFilter;
	
	@FindBy(xpath = "(//button[contains(text(),'Add to cart')])")
	List<WebElement> Items;
	
	@FindBy(xpath="//a[@class='relative text-3xl ']")
	WebElement Cart;
	
	@FindBy(xpath = "//h5[@class='text-base font-medium text-[#282828]']")
	List<WebElement> CartItems;
	
	@FindBy(xpath = "//h5[@class='text-[#4D4851] font-semibold text-sm md:text-base md:mb-1 line-clamp-2 w-full h-10 md:h-12']")
	List<WebElement> Products;
	
	@FindBy(xpath="//img[@alt='delete']")
	List<WebElement> DeleteButtons;
	
	@FindBy(xpath="//button[contains(text(),'Place Order')]")
	List<WebElement> placeOrder;
	
	@FindBy(xpath="//a[normalize-space()='Continue to Checkout']")
	WebElement CheckOutButton;
	
	@FindBy(xpath="//button[@class='text-lg font-medium text-[var(--primary)]'][2]")
	WebElement IncreaseProductCount;
	
	@FindBy(css="//a[normalize-space()='Continue to Checkout']")
	WebElement deliveryButton;
	
	@FindBy(id="fullNameInput")
	WebElement fullNameInput;
	
	
	@FindBy(id="mobile")
	WebElement phoneNumberInput;
	

	@FindBy(id="firstlane")
	WebElement apartmentInput;
	
	@FindBy(id="area")
	WebElement streetAddressInput;
	
	@FindBy(id = "landmark")
    WebElement landmarkInput;

    @FindBy(xpath = "//button[contains(text(),'United Arab Emirates')]")
    WebElement countryButton;

    @FindBy(xpath = "//button[contains(text(),'Select a state')]")
    WebElement emiratesButton;

    @FindBy(xpath = "//button[contains(text(),'Select Area')]")
    WebElement areaButton;

    @FindBy(xpath = "//button[contains(text(),'Save Address')]")
    WebElement saveAddressButton;

    @FindBy(id = "shippingNote")
    WebElement shippingNoteTextarea;
    
    @FindBy(xpath="//a[normalize-space()='Continue Shopping']")
    WebElement ContinueShopping;
    
    @FindBy(xpath="//div[text()='Please add items worth at least AED 70.00 to proceed']")
    WebElement MinValue;
    
    @FindBy(xpath="//button[normalize-space()='Select a state']")
    WebElement Emirates;
    
    @FindBy(xpath="//div[@class=\"overflow-hidden p-1 text-foreground [&_[cmdk-group-heading]]:px-2 [&_[cmdk-group-heading]]:py-1.5 [&_[cmdk-group-heading]]:text-xs [&_[cmdk-group-heading]]:font-medium [&_[cmdk-group-heading]]:text-muted-foreground\"]//div//div[1]")
    WebElement Emirate;
    
    
    @FindBy(xpath="//div[@class=\"overflow-hidden p-1 text-foreground [&_[cmdk-group-heading]]:px-2 [&_[cmdk-group-heading]]:py-1.5 [&_[cmdk-group-heading]]:text-xs [&_[cmdk-group-heading]]:font-medium [&_[cmdk-group-heading]]:text-muted-foreground\"]//div//div[1]")
    WebElement Area;
    
    @FindBy(id="radix-:ras:")
    WebElement Country;
    
    @FindBy(xpath="//h5[normalize-space()='How Do You Want to Pay?']")
    WebElement choosePayment;
    
    @FindBy(xpath="//div[contains(text(),'Pay Online')]")
     WebElement payOnline;	
    
    @FindBy(xpath="//h5[contains(text(),'Delivery')]")
    WebElement deliveryButton1;
    
    @FindBy(xpath="//button[normalize-space()='Add New Address']")
    WebElement addNewAddressButton;
    
    @FindBy(xpath="//button[contains(text( ),'Pay Now')]")
    WebElement paymentPage;
    
    @FindBy(xpath = "//button[@type=\"button\" and text()=\"Brands\"]")
	WebElement brandsFilter;
 
	@FindBy(xpath = "//ul[@class=\"grid gap-y-4 max-h-80 overflow-y-scroll overflow-x-hidden custom-scrollbar\"]//li[1]")
	WebElement firstBrandName;
 
	@FindBy(xpath="//div[@class=\"grid grid-cols-2 sm:grid-cols-3 lg:grid-cols-4 gap-2 lg:gap-4\"]//div[1]//div[@class=\"bg-white p-2 md:px-3 md:py-4\"]//h5")
	WebElement firstProductName;
	@FindBy(xpath = "//div[@class=\"grid grid-cols-2 sm:grid-cols-3 lg:grid-cols-4 gap-2 lg:gap-4\"]//div[1]//div//a//img[1]")
	WebElement firstProductDetailsPage;
	@FindBy(xpath="//h1[@class=\"text-[#1A1A1A] font-semibold text-xl md:text-3xl max-w-9/12 w-full flex justify-start flex-wrap items-center gap-2\"]//span[1]")
	WebElement productNameinDetailsPage;
	@FindBy(xpath = "//a[@class=\"text-[var(--primary)] font-normal\"]")
	WebElement brandNameinDetailsPage;
	
	String Push="pushed";

    
	private int AllCount,SearchCount,AllCountAfterClear,AllCountWithFilter,AllCountWithoutFilter;

	public void SearchProduct(String Product) throws InterruptedException
	{
	
		
		SearchBar.sendKeys(Product);
		SearchBar.sendKeys(Keys.ENTER);
		 Thread.sleep(5000);
		 AllCount=Integer.parseInt(ResultCount.getText());
	}
	
	public boolean VerifySearch(String Product) throws InterruptedException
	{
		try {
			
		 SearchCount=Integer.parseInt(ResultCount.getText());
		 Thread.sleep(3000);
		 ClearButton.click();
		 Thread.sleep(3000);
		 AllCountAfterClear=Integer.parseInt(ResultCount.getText());
		 
		 //if all counts are similar after click , the search didnot work
		 if (AllCount==SearchCount && AllCount==AllCountAfterClear)
		 {
			 return false;
		 }
		 
		 return true;
		}
		catch (NumberFormatException e) {
		    System.out.println("Error: Result count is not a number.");
		    return false;
		}
		 
		 
		
	}
	
	public String ClickFilter() throws InterruptedException
	{
		SearchCount=Integer.parseInt(ResultCount.getText());
        String Filter= ItemsFilter.get(0).getText();
		 ItemsFilter.get(0).click();
		 Thread.sleep(3000);
		 return Filter;
	}
	
	public boolean Verifyfilter() throws InterruptedException
	{
		AllCountWithFilter=Integer.parseInt(ResultCount.getText());
		ItemsFilter.get(0).click();
		Thread.sleep(3000);
		AllCountWithoutFilter=Integer.parseInt(ResultCount.getText());
		if (AllCountWithFilter!=AllCountWithoutFilter)
		{
			
			return true;
		}
		return false;
		
	}
	
	public void brandsFilter() throws InterruptedException {
		actions.moveToElement(brandsFilter).click().perform();
		Thread.sleep(3000);
	}
 
	public void clickfirstBrandName() throws InterruptedException {
		actions.moveToElement(firstBrandName).click().perform();
		Thread.sleep(3000);
	}
 
	public String firstBrandName() throws InterruptedException { /* returns name of the first brand name in the list */
		return firstBrandName.getText();
	}
 
	public String firstProductName() {
		return firstProductName.getText();		
	}
	public void firstProductDetailsPage() throws InterruptedException {
		actions.moveToElement(firstProductDetailsPage).click().perform();
		Thread.sleep(3000);
	}
 
	public String brandNameinDetailsPageVerify() throws InterruptedException {
		String ActualBrandName=brandNameinDetailsPage.getText();
		return ActualBrandName;
	}
 
	public String productNameinDetailsPageVerify() {
		String ActualProductName=productNameinDetailsPage.getText();
		driver.navigate().back();
		return ActualProductName;
		
		
	}

	
	public String AddToCart(WebDriver driver) throws InterruptedException
	{
		 
		 Actions actions = new Actions(driver);
		 Thread.sleep(2000);
		 actions.moveToElement( Items.get(0)).click().perform();
		 //Items.get(0).click();
		 Thread.sleep(3000);
		 String ItemInCart=Products.get(0).getText();
		 return ItemInCart;
	}
	
	
	public String VerifyCart() throws InterruptedException
	{
		 Thread.sleep(3000);
		 Cart.click();
		 Thread.sleep(3000);
		 String AddedToCart=CartItems.get(0).getText();
		 return AddedToCart;
	}
	
	public void EmptyCart() throws InterruptedException
	{
		 Cart.click();
		 Thread.sleep(3000);
		 
		int length=DeleteButtons.size();
		
		if (length>0)
		{
			while (length>0)
			{
				DeleteButtons.get(length-1).click();
				Thread.sleep(2000);
				length--;
				
			}
		
		}
		ContinueShopping.click();
		Thread.sleep(2000);

		
		
	}
	
	
	public void Checkout() throws InterruptedException
	{
		try 
		{

			CheckOutButton.click();
		}
		
		catch (Exception e) 
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        if (isMinValuePresent())
	        {
	            System.out.println("Checkout button is not clickable. Increasing product count...");
	            int attempts = 0;
	            while (isMinValuePresent() && attempts < 5) 
		            {
		                IncreaseProductCount.click();
		                attempts++;
		                Thread.sleep(2000);
		               
		            }
	            }
	 
	        
				CheckOutButton.click();
				Thread.sleep(2000);
		}
			
        try
        {    
        	fillAddressDetails("12B-Continental","al- jazeera road","near burj al arab","deliver to security-incase");
        }	
        catch (Exception e)
        {
        	deliveryButton1.click();
            Thread.sleep(2000);
            moveToElement(addNewAddressButton);
        	addNewAddressButton.click();
        	fillAddressDetails("12B-Continental","al- jazeera road","near burj al arab","deliver to security-incase");
        	
        }
	        	
		
	}
	
	
	  public void enterApartment(String apartment) {
	        apartmentInput.clear();
	        apartmentInput.sendKeys(apartment);
	    }

	    // Method to enter street address
	    public void enterStreetAddress(String streetAddress) {
	        streetAddressInput.clear();
	        streetAddressInput.sendKeys(streetAddress);
	    }

	    // Method to enter landmark
	    public void enterLandmark(String landmark) {
	        landmarkInput.clear();
	        landmarkInput.sendKeys(landmark);
	    }

	    // Method to select country
	    public void selectCountry() throws InterruptedException {
	        countryButton.click();
	        Thread.sleep(3000);
	    }

	    // Method to select emirate
	    public void selectEmirate() throws InterruptedException {
	        emiratesButton.click();
	        Thread.sleep(3000);

	        actions.moveToElement(Emirate).click().perform();
	    }

	    // Method to select area
	    public void selectArea() {
	        areaButton.click();
	        Area.click();
	    }

	    // Method to enter shipping note
	    public void enterShippingNote(String note) {
	        shippingNoteTextarea.clear();
	        shippingNoteTextarea.sendKeys(note);
	    }

	    // Method to click Save Address button
	    public void clickSaveAddress() {
	        saveAddressButton.click();
	    }

	    // Method to fill all address details
	    public void fillAddressDetails(String apartment, String street, String landmark, String note) throws InterruptedException {
	        enterApartment(apartment);
	        enterStreetAddress(street);
	        enterLandmark(landmark);
	        selectCountry();
	        selectEmirate();
	        selectArea();        
	        clickSaveAddress();
	        Thread.sleep(2000);
	        enterShippingNote(note);
	    }
	    
	    public boolean isMinValuePresent() {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            wait.until(ExpectedConditions.elementToBeClickable(MinValue));
	            return true; // If it doesn't throw an exception, the button is clickable
	        } catch (Exception e) {
	            return false; // If timeout occurs, button is not clickable
	        }
	    }
	    
	    public void clickPayment() throws InterruptedException
	    {
	    	Thread.sleep(2000);
	    	//actions.moveToElement(payOnline).click().perform();
	    	moveToElement(choosePayment);
		    choosePayment.click();
		    Thread.sleep(2000);
	    	payOnline.click();
		    Thread.sleep(2000);
	    	placeOrder.get(1).click();
	    	
	    	
	    }
	    
	    public String  verifyPayment()
	    {
	    	 String paymenttext=paymentPage.getText();
	    	 driver.navigate().back();
	    	 return paymenttext;
	    	 
	    }
	    
	    
	    public void moveToElement(WebElement element) throws InterruptedException
	    {
	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
	    	Thread.sleep(3000);
	    }
	}
	

  		
