package com.HRM.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.net.UrlChecker.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.Base.BaseClass;
import com.HRM.actiondriver.Action;

public class HRMExistingEmployeeDetails extends BaseClass {
	
	@FindBy(xpath = "//input[@id='txtUsername']")
	WebElement Username;
	
	@FindBy(css = "input[id='txtPassword']")
	WebElement Password;
	
	@FindBy(xpath = "//button[text()='Login']")
	WebElement Login;
	
	@FindBy(xpath = "//a[normalize-space()='Employee List']")
	WebElement EmpList;
	
	@FindBy(xpath = "//td[@class='cursor-pointer'][contains(text(),'Odis')]")
	WebElement custPointer;
	
	@FindBy(xpath = "//a[normalize-space()='Personal Details']")
	WebElement Personal_Details;
	
	@FindBy(xpath = "//h4[normalize-space()='Personal Details']")
	WebElement verContactDetails;
	
	@FindBy(xpath = "//span[text()='Log Out']")
	WebElement Logout;
	
	public HRMExistingEmployeeDetails() {
		
		PageFactory.initElements(getDriver(), this);
	}
	
	public void loginCredentials(String Uid, String Pw) throws Throwable {
		Action.type(Username, Uid);
		Action.type(Password, Pw);
		Action.click(getDriver(), Login);
		Action.ExplicitWait(6000);
		
	}
	
	public void EditExistingCustDetails() throws TimeoutException, InterruptedException {
		
		Action.click(getDriver(), EmpList);
		Thread.sleep(4000);
		Action.click(getDriver(), custPointer);
		Thread.sleep(4000);
		Action.click(getDriver(), Personal_Details);
		
	}
	
	public boolean verContactDetails() throws Exception {
		Thread.sleep(4000);
		return Action.isDisplayed(getDriver(), verContactDetails);
		
		
	}	
	
	public void Logout() throws TimeoutException {
		
		Action.click(getDriver(), Logout);
	}

}


