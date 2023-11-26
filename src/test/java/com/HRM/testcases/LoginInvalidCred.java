package com.HRM.testcases;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.HRM.Base.BaseClass;
import com.HRM.PageObjects.InvalidLogin;
import com.HRM.Utility.NewExcelLibrary;
import com.HRM.listeners.MyListeners;

@Listeners(MyListeners.class)
public class LoginInvalidCred extends BaseClass {
	
	InvalidLogin negativeTestcase;
	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(LoginInvalidCred.class);
	
	@Parameters({"browser", "URL"})
	@BeforeMethod
	public void setup(String browser, String url) {
		launchApp(browser, url);
		
	}
	
	@AfterMethod
	public void teardown() {
		getDriver().quit();
	}
	
	@Test(priority=1, enabled=true,dataProviderClass=NewExcelLibrary.class,dataProvider="bvttest")
	public void InvalidData(String uname, String password) throws Exception {
		
	negativeTestcase = new InvalidLogin();
	log.info("Browser is opening and navigates to OrangeHRMPage");
	boolean Logo = negativeTestcase.validateLogo();
	Assert.assertTrue(Logo);
	try {
		negativeTestcase.InvalidLoginCred(uname, password);
		log.info("Invalid Credentials are entered on page!!");
	} catch (Throwable e) {
		
		e.printStackTrace();
	}
		boolean warning = negativeTestcase.negativeCredentials();
		Assert.assertTrue(warning);
		log.info("Invalid Credentials message is displaying page after login with invalid credentials");
		log.info("Browser closes!");

	}

	
}