package pru.spt.misc;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pru.spt.page.eclient.BasePage;

public class Browserutil extends BasePage {

	public Browserutil(WebDriver driver) {
		super(driver);
	}
	
	
	//Reusable Methods
	public void isDisplayed(WebElement webElement, boolean scrollIntoView, Duration timeDuration) {
        WebDriverWait wait = new WebDriverWait(driver, timeDuration);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        if (scrollIntoView) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        }
        if (!webElement.isDisplayed()) {
            throw new AssertionError("Element is not displayed: " + webElement.toString());
        }
    }
	
	
	public void clickElement(WebElement webElement, Duration timeDuration) {
		
		webElement.click();
	}
	
	public void enterText(WebElement webElement, String text, Duration timeDuration) {
		
		webElement.sendKeys(text);
	}

}