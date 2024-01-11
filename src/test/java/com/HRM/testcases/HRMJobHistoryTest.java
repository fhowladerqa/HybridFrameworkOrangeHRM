package com.HRM.testcases;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.HRM.Base.BaseClass;

import com.HRM.PageObjects.HRMJobHistory;
import com.HRM.PageObjects.HRMValidPage;
import com.HRM.Utility.NewExcelLibrary;




public class HRMJobHistoryTest extends BaseClass {
	
	HRMValidPage validlogin;
	HRMJobHistory job_history;
	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(HRMJobHistoryTest.class);
	
	@Parameters({"browser", "URL"})
	@BeforeMethod
	public void setup(String browser, String url) {
		launchApp(browser, url);
		
	}
	
	@AfterMethod
	public void teardown() {
		getDriver().quit();
	}
	
	
	@Test(priority=5, enabled=false, dataProviderClass=NewExcelLibrary.class,dataProvider="bvttest")
	public void LoginTestData(String uname, String password) throws Throwable {
		
		validlogin = new HRMValidPage();
		job_history = new HRMJobHistory();
		log.info("Browser is opening and navigates to OrangeHRMPage");
		validlogin.login(uname, password);
		log.info("Valid Credentials are entered and navigates to HRM page!");
		job_history.VerJobHistory();
		boolean verJobHist = job_history.VerifyJobhistory();
		Assert.assertTrue(verJobHist);
		log.info("Job history page is being displayed");
		job_history.logout();
		log.info("Browser closes!");
		
		
	}
	
}