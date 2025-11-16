package pru.spt.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApplicationProperty {
	private static Properties properties = new Properties();
	
	static {
        try {
            // Load the default application properties file
            FileInputStream fileInputStream = new FileInputStream("F:\\Testing\\nopCommerce-latest\\appconfig.properties");
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println("Unable to load application.properties file: " + e.getMessage());
        }
    }
	
	/**
    * Get property value from system property first; if not present, fallback to file.
    */
   public static String getProperty(String key) {
       // 1. Check System property
       String systemValue = System.getProperty(key);
       if (systemValue != null && !systemValue.isEmpty()) {
           return systemValue;
       }

       // 2. Check properties file value
       String fileValue = properties.getProperty(key);
       if (fileValue != null) {
           return fileValue;
       }

       System.out.println("Property not found for key: " + key);
       return null;
   }
	
	

}
