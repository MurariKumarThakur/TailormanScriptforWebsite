package com.path.manager;

import com.file.reusable.ExcelReader;
import com.file.reusable.PropertiesFileReader;

public class pathManager {
	
	// driver path 
	public static String  chromeDriverPath = "./Driver.exe/chromedriver.exe";
	
	public static String  firfoxDriverPath = "./Driver.exe/geckodriver.exe";
	
	public static String  iEDriverPath = "./Driver.exe/IEDriverServer.exe";
	
	// screenShot path 
	
	 public static String screenShotpath = "/failureScreenShot/" ;
	 
	 // report path 
	 
	 public static  String reportPath = "/ExtantReport/report.html";
	 
	 
	 // excel file obj creasion
	 
	  static String excelDataPath = System.getProperty("user.dir")+"/src/test/java/com/testData/manager/TestData.xlsx"; 
	public static   ExcelReader storeData = new ExcelReader(excelDataPath);
	
	
	//propertyFileReader 
	
	static String configPath = System.getProperty("user.dir")+"/config.properties";
	
	public static PropertiesFileReader config = new PropertiesFileReader(configPath);

}
