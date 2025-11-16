package pru.spt.test;

import org.testng.annotations.DataProvider;

public class BrowserDP {
    @DataProvider(name = "BrowserPropertyDP")
    public static Object[][] BrowserPropertyDP() {
        // Provide the file path(s) for eclientAppTestData
    	return new Object[][] {
    		{ "chrome", "test.json", "QA", "someProperties" }
    	};
    }
}
