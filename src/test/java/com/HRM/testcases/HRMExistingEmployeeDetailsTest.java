package com.HRM.testcases;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Parameters;

import com.HRM.PageObjects.HRMExistingEmployeeDetails;
import com.HRM.Utility.NewExcelLibrary;

import com.HRM.Base.BaseClass;


public class HRMExistingEmployeeDetailsTest extends BaseClass {
	
	HRMExistingEmployeeDetails existingEmp;
	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(HRMExistingEmployeeDetailsTest.class);
	
	@Parameters({"browser", "URL"})
	@BeforeMethod
	public void setup(String browser, String url) {
		launchApp(browser, url);
		
	}
	
	@AfterMethod
	public void teardown() {
		getDriver().quit();
	}
	
	@Test(priority=4, enabled=true,dataProviderClass=NewExcelLibrary.class,dataProvider="bvttest")
	public void LoginTestData(String uname, String password) throws Throwable {
		
		existingEmp = new HRMExistingEmployeeDetails();
		log.info("Browser is opening and navigates to OrangeHRMPage");
		//existingEmp.loginCredentials(prop.getProperty("username"), prop.getProperty("password"));
		existingEmp.loginCredentials(uname, password);
		log.info("Valid Credentials are entered on page!!");
		existingEmp.EditExistingCustDetails();
		boolean verCustomerDetails = existingEmp.verContactDetails();
		Assert.assertTrue(verCustomerDetails);
		log.info("Existing Customer details are displaying on page!");
		existingEmp.Logout();
		log.info("Browser closes!");
	}
	

}
		
	



	
	


