package pru.spt.page.eclient;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import pru.spt.data.model.EclientAppData;
import pru.spt.misc.AppConstant;
import pru.spt.misc.Browserutil;
//import pru.spt.utils.ExtentReportManager;

import static org.testng.Assert.fail;

import java.time.Duration;

public class Computer_Purchase_Desktop extends Browserutil {
	
	//private final int TIMEOUT_SECONDS = 10;
	
	//constructor
	public Computer_Purchase_Desktop(WebDriver driver){
		super(driver);
	}
	
	//locators
	//@FindBy()
	
	// Locate "Computers" menu
	@FindBy(linkText = "Computers")
	WebElement computersMenu;

    @FindBy(linkText = "Desktops")
    WebElement desktopsLink;
	
	
	//Dell Product
    @FindBy(xpath = "//h2[@class='product-title']/a[text()='Build your own computer']" +
            "/ancestor::div[@class='product-item']" +
            "//button[contains(@class,'product-box-add-to-cart-button')]")
	WebElement addtoCartDellBtn_loc;
	
    @FindBy(xpath = "//h2[@class='product-title']/a[text()='Build your own computer']" +
            "/ancestor::div[@class='product-item']" +
            "//button[contains(@class,'add-to-compare-list-button')]")
	WebElement addtoComparelistDellBtn_loc;
	
    @FindBy(xpath = "//h2[@class='product-title']/a[text()='Build your own computer']" +
            "/ancestor::div[@class='product-item']" +
            "//button[contains(@class,'add-to-wishlist-button')]")
	WebElement addtoWishlistDellBtn_loc;
	
	
	//Vanquish Product
    @FindBy(xpath = "//h2[@class='product-title']/a[text()='Digital Storm VANQUISH Custom Performance PC']" +
            "/ancestor::div[@class='product-item']" +
            "//button[contains(@class,'product-box-add-to-cart-button')]")
	WebElement addToCartVanquishBtn_loc;
	
    @FindBy(xpath = "//h2[@class='product-title']/a[text()='Digital Storm VANQUISH Custom Performance PC']" +
            "/ancestor::div[@class='product-item']" +
            "//button[contains(@class,'add-to-compare-list-button')]")
	WebElement addToComparelistVanquishBtn_loc;
	
    @FindBy(xpath = "//h2[@class='product-title']/a[text()='Digital Storm VANQUISH Custom Performance PC']" +
            "/ancestor::div[@class='product-item']" +
            "//button[contains(@class,'add-to-wishlist-button')]")
	WebElement addToWishlistVanquishBtn_loc;
	
	
	//Lenovo Product
    @FindBy(xpath = "//h2[@class='product-title']/a[text()='Lenovo IdeaCentre']" +
            "/ancestor::div[@class='product-item']" +
            "//button[contains(@class,'product-box-add-to-cart-button')]")
	WebElement addToCartLenovoBtn_loc;
	
    @FindBy(xpath = "//h2[@class='product-title']/a[text()='Lenovo IdeaCentre']" +
            "/ancestor::div[@class='product-item']" +
            "//button[contains(@class,'add-to-compare-list-button')]")
	WebElement addToComparelistLenovoBtn_loc;
	
    @FindBy(xpath = "//h2[@class='product-title']/a[text()='Lenovo IdeaCentre']" +
            "/ancestor::div[@class='product-item']" +
            "//button[contains(@class,'add-to-wishlist-button')]")
	WebElement addToWishlistLenovoBtn_loc;
	
	
	
	
	//action methods
	public void goToDesktops(final EclientAppData eclientAppData) {
		
        try {
            // Wait for Computers menu to be visible
        	isDisplayed(computersMenu, true, Duration.ofSeconds(20));
            Actions Action = new Actions(driver);
            // Hover on Computers
            Action.moveToElement(computersMenu).perform();
        } catch (Exception e) {
            System.out.println("Could not find or interact with Computers menu: " + e.getMessage());
            throw e;
        }
        try {
            // Wait until Desktops link is clickable
            //wait.until(ExpectedConditions.elementToBeClickable(desktopsLink));
            isDisplayed(desktopsLink, true, Duration.ofSeconds(20));
            // Click Desktops
            //desktopsLink.click();
            clickElement(desktopsLink, Duration.ofSeconds(20));
            //ExtentReportManager.getTest().log(Status.INFO, "Click on Desktop link");
        } catch (Exception e) {
            System.out.println("Could not find or click Desktops link: " + e.getMessage());
            throw e;
        }
        verifyDesktopPage(eclientAppData);
    }
	
	public void verifyDesktopPage(final EclientAppData eclientAppData) {
		//ExtentReportManager.getTest().log(Status.INFO, "Verifying Desktop Page title");
		String expectedTitle = AppConstant.DESKTOPPAGE_TITLE;
		String actualTitle = driver.getTitle();
		
		if(actualTitle.equalsIgnoreCase(expectedTitle)){
			//ExtentReportManager.getTest().log(Status.PASS, "Desktop Page title matched");
			enterDesktopPage(eclientAppData);
		}else {
			Assert.fail("Desktop Page title NOT matched");
			//ExtentReportManager.getTest().log(Status.FAIL, "Desktop Page title NOT matched");
		}
	}
	
	public void enterDesktopPage(final EclientAppData eclientAppData) {
	    String[] productArray = eclientAppData.optionsArray;
	    for (String option : productArray) {
	        switch (option) {
	            case AppConstant.DELL:
	                if (AppConstant.YES.equals(eclientAppData.getDellAddToCart())) {
	                    //addtoCartDellBtn_loc.click();
	                    clickElement(addtoCartDellBtn_loc, Duration.ofSeconds(20));
	                    //ExtentReportManager.getTest().log(Status.PASS, "Click on Add to Cart - Dell");
	                }
	                if (AppConstant.YES.equals(eclientAppData.getDellAddToCompareList())) {
	                    //addtoComparelistDellBtn_loc.click();
	                    clickElement(addtoComparelistDellBtn_loc, Duration.ofSeconds(20));
	                    //ExtentReportManager.getTest().log(Status.PASS, "Click on Comparelist - Dell");
	                }
	                if (AppConstant.YES.equals(eclientAppData.getDellAddToWishList())) {
	                    //addtoWishlistDellBtn_loc.click();
	                    clickElement(addtoWishlistDellBtn_loc, Duration.ofSeconds(20));
	                    //ExtentReportManager.getTest().log(Status.PASS, "Click on Wishlist - Dell");
	                }
	                break;
	            case AppConstant.VANQUISH:
	                if (AppConstant.YES.equals(eclientAppData.getvanquishAddToCart())) {
	                    //addToCartVanquishBtn_loc.click();
	                    clickElement(addToCartVanquishBtn_loc, Duration.ofSeconds(20));
	                    //ExtentReportManager.getTest().log(Status.PASS, "Click on Add to Cart - Vanquish");
	                    
	                }
	                if (AppConstant.YES.equals(eclientAppData.getvanquishAddToCompareList())) {
	                    //addToComparelistVanquishBtn_loc.click();
	                    clickElement(addToComparelistVanquishBtn_loc, Duration.ofSeconds(20));
	                    //ExtentReportManager.getTest().log(Status.PASS, "Click on Comparelist - Vanquish");
	                }
	                if (AppConstant.YES.equals(eclientAppData.getvanquishAddToWishList())) {
	                    //addToWishlistVanquishBtn_loc.click();
	                    clickElement(addToWishlistVanquishBtn_loc, Duration.ofSeconds(20));
	                    //ExtentReportManager.getTest().log(Status.PASS, "Click on Wishlist - Vanquish");
	                }
	                break;
	            case AppConstant.LENOVO:
	                if (AppConstant.YES.equals(eclientAppData.getlenovoAddToCart())) {
	                    //addToCartLenovoBtn_loc.click();
	                    clickElement(addToCartLenovoBtn_loc, Duration.ofSeconds(20));
	                    //ExtentReportManager.getTest().log(Status.PASS, "Click on Add to cart - lenovo");
	                }
	                if (AppConstant.YES.equals(eclientAppData.getlenovoAddToCompareList())) {
	                    //addToComparelistLenovoBtn_loc.click();
	                    clickElement(addToComparelistLenovoBtn_loc, Duration.ofSeconds(20));
	                    //ExtentReportManager.getTest().log(Status.PASS, "Click on Comparelist - lenovo");
	                }
	                if (AppConstant.YES.equals(eclientAppData.getlenovoAddToWishList())) {
	                    //addToWishlistLenovoBtn_loc.click();
	                    clickElement(addToWishlistLenovoBtn_loc, Duration.ofSeconds(20));
	                    //ExtentReportManager.getTest().log(Status.PASS, "Click on Wishlist - lenovo");
	                }
	                break;
	            default:
	                System.out.println("Unknown product option: '" + option + "'");
	                break;
	        }
	    }
	}
}
