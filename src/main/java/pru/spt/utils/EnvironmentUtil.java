package pru.spt.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import pru.spt.misc.AppConstant;

public class EnvironmentUtil {
	
//	private static Properties properties = new Properties();
//	
//	
//	public static void loadEnvVariableFromPropertyFile(String env) {
//        String filePath = "src/test/resources/" + env.toLowerCase() + ".properties";
//        try (FileInputStream fis = new FileInputStream(filePath)) {
//            properties.load(fis);
//            System.out.println("Loaded configuration from: " + filePath);
//        } catch (IOException e) {
//            throw new RuntimeException("Unable to load properties file for env: " + env + " at path: " + filePath, e);
//        }
//    }
//	
//	
//	public static String getProperty(String key) {
//        String value = properties.getProperty(key);
//        if (value == null) {
//            throw new RuntimeException("❌ Property [" + key + "] not found in file");
//        }
//        return value;
//    }
//	
//	public static List<String> getAllUrls() {
//        List<String> urls = new ArrayList<>();
//        for (int i = 1; i <= 10; i++) {
//            String key = "url" + i;
//            String value = properties.getProperty(key);
//            if (value != null && !value.isEmpty()) {
//                urls.add(value);
//            }
//        }
//        return urls;
//    }
//	
//	public static List<String> getAllBrowsers() {
//        String browserList = properties.getProperty("browsers");
//        if (browserList == null) {
//            throw new RuntimeException("❌ No browsers found in config file");
//        }
//        String[] browsers = browserList.split(",");
//        List<String> list = new ArrayList<>();
//        for (String b : browsers) {
//            list.add(b.trim());
//        }
//        return list;
//    }

	
	
	
	public Properties loadEnvironmentVariablesFromPropertyFile(String propertyFilePath) {
	    Properties prop = new Properties();
	    try {
	        prop = readPropertiesFile(propertyFilePath);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return prop;
	}

	public Properties readPropertiesFile(String fileName) throws IOException {
	    FileInputStream fis = null;
	    File f = new File(fileName);
	    Properties prop = null;

	    if (f.exists() && !f.isDirectory()) {
	        try {
	            fis = new FileInputStream(fileName);
	            prop = new Properties();
	            prop.load(fis);
	            
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	            
	        }catch (IOException e) {
	            e.printStackTrace();
	            
	        } finally {
	            fis.close();
	        }
	    }
	    return prop;
	}
	
	
	public String getURLFromName(String name, String env, Properties prop) {
	    String urlPropertyKey = "";
	    String applicationUrl = "";
	    if (name.contains(AppConstant.ON01)) {
	        urlPropertyKey = "On01.url";
	    } else if (name.contains(AppConstant.ON02)) {
	        urlPropertyKey = "On02.url";
	    } else if (name.contains(AppConstant.ON03)) {
	        urlPropertyKey = "On03.url";
	    } else if (name.contains(AppConstant.ON04)) {
	        urlPropertyKey = "On04.url";
	    } else if (name.contains(AppConstant.ON05)) {
	        urlPropertyKey = "On05.url";
	    } else if (name.contains(AppConstant.ON06)) {
	        urlPropertyKey = "On06.url";
	    } else if (name.contains(AppConstant.ON07)) {
	        urlPropertyKey = "On07.url";
	    } else if (name.contains(AppConstant.ON08)) {
	        urlPropertyKey = "On08.url";
	    } else if (name.contains(AppConstant.ON09)) {
	        urlPropertyKey = "On09.url";
	    }    else if (name.contains(AppConstant.ON10)) {
	        urlPropertyKey = "On10.url";
	    }
	    applicationUrl = prop.getProperty(urlPropertyKey);
//	    if (StringUtils.isBlank(applicationUrl)) {
//	        applicationUrl = ApplicationProperty.APPLICATION_URL;
//	    }
	    return applicationUrl;
	}

	


	
	
}
