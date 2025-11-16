package pru.spt.misc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Browser {
    public WebDriver launch(String browserName, String application_url, String seleniumHubUrl) {
        // For now, seleniumHubUrl is not used, but can be used for remote WebDriver in future
        WebDriver driver;
        switch (browserName.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
        driver.manage().window().maximize();
        driver.get(application_url);
        return driver;
    }
    
    public void close(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }
}