package com.HRM.listeners;


import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.HRM.Utility.TestUtils;



public class MyListeners extends TestUtils implements ITestListener {
	

	
	public void onTestStart(ITestResult result) {
		System.out.println("Test case is starting");
		
	}
	
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Test case has passed!");
		
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed - screenshot captured");
		try {
			getScreenShot();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedWithSuccessPercentage(ITestResult result) {
		
		System.out.println("For those tests that have failed - screenshot captured");
		try {
			getScreenShot();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	public void onStart(ITestContext context) {
		
		System.out.println("Any of the Browsers are opening for test execution!");
		
	}


}


