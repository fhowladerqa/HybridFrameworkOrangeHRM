package com.HRM.testcases;



import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


import com.HRM.Base.BaseClass;
import com.HRM.PageObjects.HRMAddNewUser;

import com.HRM.PageObjects.HRMValidPage;
import com.HRM.Utility.NewExcelLibrary;





public class HRMAddNewUserTest extends BaseClass {
	
	HRMValidPage validlogin;
	HRMAddNewUser AddingNewUser;
	
	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(HRMAddNewUserTest.class);
	
	@Parameters({"browser", "URL"})
	@BeforeMethod
	public void setup(String browser, String url) {
		launchApp(browser, url);
		
	}
	
	@AfterMethod
	public void teardown() {
		getDriver().quit();
	}

	@Test(priority=6, enabled=false, dataProviderClass=NewExcelLibrary.class,dataProvider="bvttest")
	public void LoginTestData(String uname, String password) throws Throwable {
		
		AddingNewUser = new HRMAddNewUser();
		log.info("Browser is opening and navigates to OrangeHRMPage");
		AddingNewUser.login(uname, password);
		log.info("Valid Credentials are entered and navigates to HRM page!");
		AddingNewUser.Add_New_User_Module();
		boolean verNewEmpAdd = AddingNewUser.Veri_New_Emp_Page();
		log.info("New User's populate fields are displaying on page!");
		Thread.sleep(4000);
		Assert.assertTrue(verNewEmpAdd);
		AddingNewUser.Enter_New_Info(prop.getProperty("First_Name"), prop.getProperty("Middle_Name"),prop.getProperty("Last_Name"),
		prop.getProperty("Emp_Id"),prop.getProperty("JoinedDate"),prop.getProperty("New_UID"),prop.getProperty("New_PW"),prop.getProperty("Confirm_PW"));
		AddingNewUser.logout();
		log.info("New User is added in OrangeHRM website!");
		
}

}
 
	

	




