package pru.spt.test;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;

import pru.spt.data.model.EclientAppData;
import pru.spt.misc.AppConstant;
import pru.spt.misc.Browser;
import pru.spt.page.eclient.Computer_Purchase_Desktop;
import pru.spt.page.eclient.HomePage;
import pru.spt.page.eclient.LoginPage;
import pru.spt.utils.ApplicationProperty;
import pru.spt.utils.EnvironmentUtil;
import pru.test.data.JsonValueReader;
@Test
public class EclientAppTest extends BrowserTest {
	
	//WebDriver driver;

//	@BeforeMethod
//	void setup() {
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("http://demo.nopcommerce.com/");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	}
//
//	@AfterMethod
//	void tearDown() {
//		if (driver != null) {
//			//driver.quit();
//		}
//	}

	
	
	String environment = "";
    String domain = "";
    Properties properties;
    String propertyFilePath = "";
    
    @BeforeTest
    public void deleteInterviewResultsFromDb() throws IOException {
        EnvironmentUtil environmentUtil = new EnvironmentUtil();
        domain = ApplicationProperty.getProperty(AppConstant.DOMAIN);
        domain = StringUtils.isBlank(domain) ? AppConstant.PLUS : domain;  // checks domain and if it is blank set default to PLUS
        environment = ApplicationProperty.getProperty(AppConstant.ENVIRONMENT);
        environment = StringUtils.isBlank(environment) ? AppConstant.QA1 : environment;// checks environment and if it is blank set default to qa1
        propertyFilePath = "./env/" + domain + "/" + environment + ".properties";
        
        properties = environmentUtil.loadEnvironmentVariablesFromPropertyFile(propertyFilePath);
        String on = "On";
        String application_url = "";
        //MongoClient client = MongoClients.create(mongodb_url);
        for (int i = 1; i <= 5; i++) {
            String name = "";
            if (i <= 9) {
                name = on + "0" + i;
            } else {
                name = on + i;
            }

            application_url = environmentUtil.getURLFromName(name, environment, properties);
        }
    }

    
    
    
//	@Parameters({"eclientAppDataFilePath"})
//	@Test(testName = "Validate Eclient App Test 01", dataProviderClass = BrowserDP.class, dataProvider = "BrowserPropertyDP", description = "Validate Eclient App Test 01")
//	public void validateEclientAppTest_01(final String eclientAppDataFilePath) {
//		EclientAppData eclientAppData = new EclientAppData(new JsonValueReader(eclientAppDataFilePath));
//		HomePage homePage = new HomePage(driver);
//		homePage.verifyHomepage(eclientAppData);
//	}
//	
//	@Parameters({"eclientAppDataFilePath"})
//	@Test(testName = "Validate Eclient App Test 02", dataProviderClass = BrowserDP.class, dataProvider = "BrowserPropertyDP", description = "Validate Eclient App Test 02")
//	public void validateEclientAppTest_02(final String eclientAppDataFilePath) {
//		EclientAppData eclientAppData = new EclientAppData(new JsonValueReader(eclientAppDataFilePath));
//		LoginPage loginPage = new LoginPage(driver);
//		loginPage.verifyLoginPage(eclientAppData);
//		
//		Computer_Purchase_Desktop computer_Purchase_Desktop = new Computer_Purchase_Desktop(driver);
//		computer_Purchase_Desktop.goToDesktops(eclientAppData);
//		
//	}
	
	
	
    @Parameters({"eclientAppTestData"})
	@Test(testName = "Validate Eclient App Test 01", dataProviderClass = BrowserDP.class, dataProvider = "BrowserPropertyDP", description = "Validate Eclient App Test 01")
	public void validateEclientAppTest_01(final String browserName, final String eclientAppDataFilePath) throws IOException {
    	
    	String testName = "testEclientAppTest_01";
    	WebDriver driver = launchBrowser(browserName,testName, environment, properties);
		EclientAppData eclientAppData = new EclientAppData(new JsonValueReader(eclientAppDataFilePath));
		HomePage homePage = new HomePage(driver);
		homePage.verifyHomepage(eclientAppData);
		Browser browser = new Browser();
		browser.close(driver);
	}
	
	@Parameters({"eclientAppDataFilePath"})
	@Test(testName = "Validate Eclient App Test 02", dataProviderClass = BrowserDP.class, dataProvider = "BrowserPropertyDP", description = "Validate Eclient App Test 02")
	public void validateEclientAppTest_02(final String browserName, final String eclientAppDataFilePath) throws IOException {
		
		String testName = "testEclientAppTest_02";
    	WebDriver driver = launchBrowser(browserName,testName, environment, properties);
    	
		EclientAppData eclientAppData = new EclientAppData(new JsonValueReader(eclientAppDataFilePath));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.verifyLoginPage(eclientAppData);
		
		Computer_Purchase_Desktop computer_Purchase_Desktop = new Computer_Purchase_Desktop(driver);
		computer_Purchase_Desktop.goToDesktops(eclientAppData);
		
		Browser browser = new Browser();
		browser.close(driver);
		
	}
	
	
	
	
	
	// Add this public getter for WebDriver so listeners can access it
//	public WebDriver getDriver() {
//		return this.driver;
//	}
	
	
	
}