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

public class RegistrationPage extends Browserutil {
	
	//Constructor
	
	public RegistrationPage(WebDriver driver){
		super(driver);
	}
	
	//Locators
	
	@FindBy(xpath="//img[@alt='nopCommerce demo store']")
	WebElement nopCommercelogo;
	
	@FindBy(xpath="//input[@id='gender-male']")
	WebElement genderMale_loc;
	
	@FindBy(xpath="//input[@id='gender-female']")
	WebElement genderFemale_loc;
	
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement firstname_loc;

	@FindBy(xpath = "//input[@id='LastName']")
	WebElement latname_loc;

	@FindBy(xpath = "//input[@id='Email']")
	WebElement email_loc;

	@FindBy(xpath = "//input[@id='Company']")
	WebElement companyName_loc;
	
	@FindBy(xpath = "//input[@id='Newsletter']")
	WebElement newsLetter_loc;


	@FindBy(xpath = "//input[@id='Password']")
	WebElement Password_loc;

	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	WebElement ConfirmPassword_loc;

	@FindBy(xpath = "//button[@id='register-button']")
	WebElement RegisterBtn_loc;

	@FindBy(xpath = "//*[@id='main']/div/div/div/div[2]/div[1]")
	WebElement msgConfirmation_loc;

	@FindBy(className = "register-continue-button")
	WebElement continueBtn_loc;

	@FindBy(linkText = "Log out")
	WebElement logoutBtn_loc;
	
	
	//Action Methods
	
	public void enterregistrationdetails(final EclientAppData eclientAppData) {
		//ExtentReportManager.getTest().log(Status.INFO, "Enter Registration details");
		
		isDisplayed(nopCommercelogo, true, Duration.ofSeconds(20));
		
		if (AppConstant.MALE.equals(eclientAppData.getGender())) {
			//genderMale_loc.click();
			clickElement(genderMale_loc, Duration.ofSeconds(20));
		}
		if (AppConstant.FEMALE.equals(eclientAppData.getGender())) {
			//genderFemale_loc.click();
			clickElement(genderFemale_loc, Duration.ofSeconds(20));
		}
		if (!StringUtils.isBlank(eclientAppData.getFirstName())) {
			//firstname_loc.sendKeys(eclientAppData.getFirstName());
			enterText(firstname_loc, eclientAppData.getFirstName(), Duration.ofSeconds(20));
		}
		if (!StringUtils.isBlank(eclientAppData.getLastName())) {
			//latname_loc.sendKeys(eclientAppData.getLastName());
			enterText(latname_loc, eclientAppData.getLastName(), Duration.ofSeconds(20));
		}
		if (!StringUtils.isBlank(eclientAppData.getEmail())) {
			//email_loc.sendKeys(eclientAppData.getEmail());
			enterText(email_loc, eclientAppData.getEmail(), Duration.ofSeconds(20));
		}
		if (!StringUtils.isBlank(eclientAppData.getCompanyName())) {
			//companyName_loc.sendKeys(eclientAppData.getCompanyName());
			enterText(companyName_loc, eclientAppData.getCompanyName(), Duration.ofSeconds(20));
		}
		if (AppConstant.NO.equals(eclientAppData.getnewLetter())) {
			//newsLetter_loc.click();
			clickElement(newsLetter_loc, Duration.ofSeconds(20));
		}
		if (!StringUtils.isBlank(eclientAppData.getPassword())) {
			//Password_loc.sendKeys(eclientAppData.getPassword());
			enterText(Password_loc, eclientAppData.getPassword(), Duration.ofSeconds(20));
		}
		if (!StringUtils.isBlank(eclientAppData.getConfirmPassword())) {
			//ConfirmPassword_loc.sendKeys(eclientAppData.getConfirmPassword());
			enterText(ConfirmPassword_loc, eclientAppData.getConfirmPassword(), Duration.ofSeconds(20));
		}
		//RegisterBtn_loc.click();
		clickElement(RegisterBtn_loc, Duration.ofSeconds(20));
		//ExtentReportManager.getTest().log(Status.INFO, "click on Register Button");
		isDisplayed(nopCommercelogo, true, Duration.ofSeconds(20));
		verifyHomepage2();
	}
	
	public void verifyHomepage2() {
		//continueBtn_loc.click();
		clickElement(continueBtn_loc, Duration.ofSeconds(20));
		//logoutBtn_loc.click();
		clickElement(logoutBtn_loc, Duration.ofSeconds(20));
		//ExtentReportManager.getTest().log(Status.INFO, "click on logout button");
		
		String expectedTitle = AppConstant.HOME_TITLE;
		String actualTitle = driver.getTitle();
		if(actualTitle.equalsIgnoreCase(expectedTitle)){
			System.out.println("We are on the home page");
		}else {
			Assert.fail("HomePage Title NOT matched");
		}
	}
}