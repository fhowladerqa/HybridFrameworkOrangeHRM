package com.HRM.testcases;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.HRM.Base.BaseClass;

import com.HRM.PageObjects.OrangeHRMEmployeeDetails;
import com.HRM.Utility.NewExcelLibrary;
import com.HRM.listeners.MyListeners;

@Listeners(MyListeners.class)
public class OrangeHRMEmpDetailsTest extends BaseClass{
	
	OrangeHRMEmployeeDetails empdetails;
	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(OrangeHRMEmpDetailsTest.class);
	
	@Parameters({"browser", "URL"})
	@BeforeMethod
	public void setup(String browser, String url) {
		launchApp(browser, url);
		
	}
	
	@AfterMethod
	public void teardown() {
		getDriver().quit();
	}
	
	@Test(priority=2, enabled=true, dataProviderClass=NewExcelLibrary.class,dataProvider="bvttest")
	public void LoginTestData(String uname, String password) throws Throwable {
		
		empdetails = new OrangeHRMEmployeeDetails();
		log.info("Browser is opening and navigates to OrangeHRMPage");
		
		empdetails.loginCred(uname, password);
		log.info("Valid Credentials are entered on page!!");
		//Action action = new Action();
		empdetails.Emp_Details();
		log.info("Customer's details are displaying on page!");
		log.info("Browser closes!");
		empdetails.Logout();
		
		
	}
}
