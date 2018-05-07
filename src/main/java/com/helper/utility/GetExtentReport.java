package com.helper.utility;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.base.engine.DriverEngine;
import com.path.manager.pathManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GetExtentReport extends DriverEngine {

	public static ExtentReports report;
	public static ExtentTest logger;
	public static String reportUrl;

	static {

		reportUrl = System.getProperty("user.dir") + pathManager.reportPath;

		report = new ExtentReports(reportUrl);
	}
   
    
	public static  void intializeExtentest(ITestResult result) {

		logger = report.startTest(result.getName());

		logger.log(LogStatus.INFO, result.getName() + " Test case Execution  Started ");
	}
       public static void getFailureTestCaseImage(String imageName){
    	   
       String imagePath =  GetScreenShot.takeScreenShot(imageName) ;
       
       String reportPath =    logger.addScreenCapture(imagePath);
       
        logger.log(LogStatus.FAIL, reportPath);
    	   
       }
      
       
	public static void getStatus(ITestResult result) {
		
		  intializeExtentest(result);
		
		if(result.getStatus()==ITestResult.SUCCESS){
			
			logger.log(LogStatus.PASS, result.getName()+" TestCase Pass ");
			
		}else if(result.getStatus()==ITestResult.SKIP){
			
			logger.log(LogStatus.SKIP, result.getName()+ " TestCase Skip "+result.getThrowable());
		}else if(result.getStatus()==ITestResult.FAILURE){
			   getFailureTestCaseImage(result.getName());
			 logger.log(LogStatus.FAIL,result.getName()+" TestCase Fail"+result.getThrowable() );
			
		}
		
		

	}
       
     
        public static void endReport(){
        	
        	report.endTest(logger);
        	report.flush();
        	
        	
        	
        }

}
