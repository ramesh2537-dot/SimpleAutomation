package pru.spt.page.eclient;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
//import pru.spt.utils.ExtentReportManager;

import pru.spt.data.model.EclientAppData;
import pru.spt.misc.AppConstant;
import pru.spt.misc.Browserutil;

public class HomePage extends Browserutil {
	
	//Constructor
		public HomePage(WebDriver driver){
			
			super(driver);
		}
		
		//Locators

			@FindBy(xpath="//img[@alt='nopCommerce demo store']")
			WebElement nopCommercelogo;
			
			@FindBy(linkText="Register")
			WebElement registerlink;

		
			
		
		
		//Action Methods
		
		public void verifyHomepage(final EclientAppData eclientAppData) {
			//ExtentReportManager.getTest().log(Status.INFO, "Verifying Home Page title");
			String expectedTitle = AppConstant.HOME_TITLE;
			isDisplayed(nopCommercelogo, true, Duration.ofSeconds(20));
			String actualTitle = driver.getTitle();
			if(actualTitle.equalsIgnoreCase(expectedTitle)){
				//ExtentReportManager.getTest().log(Status.PASS, "Home Page title matched");
				navigatetoRegistrationPage(eclientAppData);
			} else {
				//ExtentReportManager.getTest().log(Status.FAIL, "Home Page title NOT matched");
				Assert.fail("Home Page title NOT matched");
			}
		}
		
		public void navigatetoRegistrationPage(final EclientAppData eclientAppData) {
			//ExtentReportManager.getTest().log(Status.INFO, "Clicking Register link");
			clickElement(registerlink, Duration.ofSeconds(20));
		
			//registerlink.click();
			String expectedTitle = AppConstant.REGISTER_TITLE;
			isDisplayed(nopCommercelogo, true, Duration.ofSeconds(20));
			String actualTitle = driver.getTitle();
			if(actualTitle.equalsIgnoreCase(expectedTitle)){
				//ExtentReportManager.getTest().log(Status.PASS, "Registration Page title matched");
				RegistrationPage registrationpage = new RegistrationPage(driver);
				registrationpage.enterregistrationdetails(eclientAppData);
			} else {
				//ExtentReportManager.getTest().log(Status.FAIL, "RegistrationPage Title NOT matched");
				Assert.fail("RegistrationPage Title NOT matched");
			}
		}
		
		
		

}