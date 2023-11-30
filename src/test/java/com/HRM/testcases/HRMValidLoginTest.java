package com.HRM.testcases;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.HRM.Base.BaseClass;
import com.HRM.PageObjects.HRMValidPage;
import com.HRM.Utility.NewExcelLibrary;
import com.HRM.listeners.MyListeners;

///Valid Login Details...
@Listeners(MyListeners.class)
public class HRMValidLoginTest extends BaseClass{
	HRMValidPage validlogin;
	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(HRMValidLoginTest.class);
	
	@Parameters({"browser", "URL"})
	@BeforeMethod
	public void setup(String browser, String url) {
		launchApp(browser, url);
		
	}
	
	@AfterMethod
	public void teardown() {
		getDriver().quit();
	}
	
	@Test(priority=0,enabled=false,dataProviderClass=NewExcelLibrary.class,dataProvider="bvttest")
	public void LoginTestData(String uname, String password) throws Throwable {
		log.info("Browser is opening and navigates to OrangeHRMPage");
		validlogin = new HRMValidPage();
		boolean Logo = validlogin.validateLogo();
		Assert.assertTrue(Logo);
		log.info("Logo is displaying on page!");
		validlogin.login(uname,password);
		log.info("Valid Credentials are entered on page!!");
		log.info("Navigates to HRM page!! ");
		boolean verPage = validlogin.VerifyPage();
		Assert.assertTrue(verPage);
		log.info("Browser closes!");
		validlogin.Logout();
	}
	
	


}	 


	
