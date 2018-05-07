package com.helper.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;


import com.base.engine.DriverEngine;
import com.path.manager.pathManager;

public class GetScreenShot extends DriverEngine {
	static String screenShotPath ;
	
public static String  takeScreenShot(String screenShotName){
	
	
	  TakesScreenshot tc = (TakesScreenshot) driver ;
	  
	     File file = tc.getScreenshotAs(OutputType.FILE);
	     
	        try {
	        	screenShotPath = System.getProperty("user.dir")+pathManager.screenShotpath+screenShotName+".jpeg" ;
				FileUtils.copyFile(file, new File(screenShotPath),true);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			return screenShotPath;
	
}

}
