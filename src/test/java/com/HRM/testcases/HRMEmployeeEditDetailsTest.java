package com.HRM.testcases;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.HRM.Base.BaseClass;
import com.HRM.PageObjects.HRMEmployeeEditDetails;
import com.HRM.Utility.NewExcelLibrary;


///EmployeeDetails
//@Listeners(MyListeners.class)
public class HRMEmployeeEditDetailsTest extends BaseClass {
	
	HRMEmployeeEditDetails empdetails;
	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(HRMEmployeeEditDetailsTest.class);
	
	@Parameters({"browser", "URL"})
	@BeforeMethod
	public void setup(String browser, String url) {
		launchApp(browser, url);
		
	}
	
	@AfterMethod
	public void teardown() {
		getDriver().quit();
	}
	
	@Test(priority=3, enabled=true, dataProviderClass=NewExcelLibrary.class,dataProvider="bvttest")
	public void LoginTestData(String uname, String password) throws Throwable {
		
		log.info("Browser is opening and navigates to OrangeHRMPage");
		empdetails = new HRMEmployeeEditDetails();
		//empdetails.loginCred(prop.getProperty("username"), prop.getProperty("password"));
		empdetails.loginCred(uname, password);
		log.info("Valid Credentials are entered on page!!");
		empdetails.EditCustomerDetails();
		log.info("Customer's details are displaying on page!");
		log.info("Browser closes!");
		
		
	}

}
