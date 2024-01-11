package com.HRM.testcases;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.HRM.Base.BaseClass;
import com.HRM.PageObjects.HRMSalaryDetails;
import com.HRM.Utility.NewExcelLibrary;

public class HRMSalaryDetailsTest extends BaseClass {
	
	HRMSalaryDetails salaryDetails;
	
public static org.apache.logging.log4j.Logger log = LogManager.getLogger(HRMSalaryDetailsTest.class);
	
	@Parameters({"browser", "URL"})
	@BeforeMethod
	public void setup(String browser, String url) {
		launchApp(browser, url);
		
	}
	
	@AfterMethod
	public void teardown() {
		getDriver().quit();
	}

	@Test(priority=7, enabled=false, dataProviderClass=NewExcelLibrary.class,dataProvider="bvttest")
	public void LoginTestData(String uname, String password) throws Throwable {
		
		salaryDetails = new HRMSalaryDetails();
		log.info("Browser is opening and navigates to OrangeHRMPage");
		salaryDetails.login(uname, password);
		log.info("Valid Credentials are entered and navigates to HRM page!");
		salaryDetails.SalaryInfo();
		log.info("Information for employee's salary dispaying on page!");
		salaryDetails.logout();

}
	
	


}