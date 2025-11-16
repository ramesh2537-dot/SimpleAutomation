package pru.spt.test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import pru.spt.misc.AppConstant;
import pru.spt.misc.Browser;
import pru.spt.utils.EnvironmentUtil;
import pru.spt.utils.FormatUtil;

public class BrowserTest extends Browser {

	public WebDriver launchBrowser(final String browserName, final String name, final String environment, final Properties properties) throws IOException {

	    String env = FormatUtil.getTrimmedString(environment);
	    if (env.length() == 0) {
	        env = AppConstant.QA1;
	    }

	    EnvironmentUtil environmentUtil = new EnvironmentUtil();
	    String application_url = environmentUtil.getURLFromName(name, env, properties);

	    String seleniumHubUrl = properties.getProperty("selenium.hub.url");
	    Browser browser = new Browser();
	    WebDriver driver = browser.launch(browserName, application_url, seleniumHubUrl);

	    return driver;
	}
	
}