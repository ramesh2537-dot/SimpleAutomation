package pru.spt.page.eclient;

import java.time.Duration;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import pru.spt.data.model.EclientAppData;
import pru.spt.misc.AppConstant;
import pru.spt.misc.Browserutil;
//import pru.spt.utils.ExtentReportManager;

public class LoginPage extends Browserutil {
	
	//Constructor
	
	public LoginPage(WebDriver driver){
		super(driver);
	}
	
	//Locators
	
	@FindBy(xpath="//img[@alt='nopCommerce demo store']")
	WebElement nopCommercelogo;
	
	@FindBy(linkText="Log in")
	WebElement loginBtn;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement Password;
	
	@FindBy(className="login-button")
	WebElement loginBtn2;
	
	//Action Methods
	
	public void verifyLoginPage(final EclientAppData eclientAppData) {
			
			//loginBtn.click();
		
			
			clickElement(loginBtn, Duration.ofSeconds(20));
			//ExtentReportManager.getTest().log(Status.INFO, "click on Login button");
			isDisplayed(nopCommercelogo, true, Duration.ofSeconds(20));
			String expectedTitle = AppConstant.LOGINPAGE_TITLE;
			String actualTitle = driver.getTitle();
			
			if(actualTitle.equalsIgnoreCase(expectedTitle)){
				
				LoginPage loginpage = new LoginPage(driver);
				loginpage.enterlogindetails(eclientAppData);
				//ExtentReportManager.getTest().log(Status.PASS, "LoginPage Title matched");
				
			}else {
				
				Assert.fail("LoginPage Title NOT matched");
				//ExtentReportManager.getTest().log(Status.FAIL, "LoginPage Title NOT matched");
			}
			
			
		}

	public void enterlogindetails(final EclientAppData eclientAppData) {
		//ExtentReportManager.getTest().log(Status.INFO, "Enter Login details");
		isDisplayed(nopCommercelogo, true, Duration.ofSeconds(20));
		
		if(!StringUtils.isBlank(eclientAppData.getEmail())) {
			//email.sendKeys(eclientAppData.getEmail());
			enterText(email, eclientAppData.getEmail(), Duration.ofSeconds(20));
			
		}
		if(!StringUtils.isBlank(eclientAppData.getPassword())) {
			//Password.sendKeys(eclientAppData.getPassword());
			enterText(Password, eclientAppData.getPassword(), Duration.ofSeconds(20));
			
		}
		//loginBtn2.click();
		clickElement(loginBtn2, Duration.ofSeconds(20));
		//ExtentReportManager.getTest().log(Status.INFO, "Click on login button");
		
		
	}
	

		
}