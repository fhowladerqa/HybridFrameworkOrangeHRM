package com.HRM.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.net.UrlChecker.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.Base.BaseClass;
import com.HRM.actiondriver.Action;

public class HRMJobHistory extends BaseClass {
	
	@FindBy(xpath = "//a[normalize-space()='My Info']")
	WebElement MyInfobtn;
	
	@FindBy(xpath = "//a[normalize-space()='Job']")
	WebElement Job;
	
	@FindBy(xpath = "//span[@class='nav-item-title card-title-text'][normalize-space()='Job History']")
	WebElement Job_History;
	
	@FindBy(xpath = "//span[text()='(13) Job History Records Found']")
	WebElement JB_Records;
	
	@FindBy(xpath = "//span[text()='Log Out']")
	WebElement Logout;
	
	public HRMJobHistory() {
		
		PageFactory.initElements(getDriver(), this);
	}
	
	public void VerJobHistory() throws InterruptedException, TimeoutException {
		
		Thread.sleep(2000);
		try {
			Action.click(getDriver(), MyInfobtn);
		} catch (TimeoutException e) {
			
			e.printStackTrace();
		}
		Thread.sleep(7000);
		Action.click(getDriver(), Job);
		Thread.sleep(7000);
		Action.click(getDriver(), Job_History);
		Thread.sleep(8000);
		
	}
	
	public boolean VerifyJobhistory() throws Exception {
		
		Action.ExplicitWait(8000);
		return Action.isDisplayed(getDriver(), JB_Records);
		
	}
	
	public void logout() throws TimeoutException {
		Action.click(getDriver(), Logout);
		
	}
}
