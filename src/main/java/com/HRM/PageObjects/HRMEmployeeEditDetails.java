package com.HRM.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.net.UrlChecker.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.Base.BaseClass;
import com.HRM.actiondriver.Action;

public class HRMEmployeeEditDetails extends BaseClass{
	
	@FindBy(xpath = "//input[@id='txtUsername']")
	WebElement Username;
	
	@FindBy(css = "input[id='txtPassword']")
	WebElement Password;
	
	@FindBy(xpath = "//button[text()='Login']")
	WebElement Login;
	
	@FindBy(xpath = "//a[normalize-space()='My Info']")
	WebElement MyInfobtn;
	
	@FindBy(xpath = "//a[normalize-space()='Contact Details']")
	WebElement CustDetails;
	
	@FindBy(xpath = "//form[@name='contact.contactDetailsForm']")
	WebElement verContactDetails;
	
	@FindBy(xpath = "//span[text()='Log Out']")
	WebElement Logout;
	
	public HRMEmployeeEditDetails() {
		
		PageFactory.initElements(getDriver(), this);
	}
	
	public void loginCred(String Uid, String Pw) throws Throwable {
		Action.type(Username, Uid);
		Action.type(Password, Pw);
		Action.click(getDriver(), Login);
		Action.ExplicitWait(6000);
		
	}
	
	public void EditCustomerDetails() throws TimeoutException, InterruptedException {
		
		Action.click(getDriver(), MyInfobtn);
		Thread.sleep(4000);
		Action.click(getDriver(), CustDetails);
		Thread.sleep(4000);
		Action.isDisplayed(getDriver(), verContactDetails);
		Action.ExplicitWait(4000);
		Action.click(getDriver(), Logout);
		
		
	}
}
