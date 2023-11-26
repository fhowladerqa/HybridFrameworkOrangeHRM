package com.HRM.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.net.UrlChecker.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.Base.BaseClass;
import com.HRM.actiondriver.Action;

public class OrangeHRMEmployeeDetails extends BaseClass {

	@FindBy(xpath = "//input[@id='txtUsername']")
	WebElement Username;
	
	@FindBy(css = "input[id='txtPassword']")
	WebElement Password;
	
	@FindBy(xpath = "//button[text()='Login']")
	WebElement Login;
	
	@FindBy(xpath = "//a[normalize-space()='Employee List']")
	WebElement Employee_List;
	
	@FindBy(xpath = "//table[@id='employeeListTable']")
	WebElement VerifyEmpPage;
	
	@FindBy(xpath = "//span[text()='Log Out']")
	WebElement Logout;
	
	
	public OrangeHRMEmployeeDetails() {
		
		PageFactory.initElements(getDriver(), this);
	}
	
	public void loginCred(String Uid, String Pw) throws Throwable {
		Action.type(Username, Uid);
		Action.type(Password, Pw);
		Action.click(getDriver(), Login);
		
	}
	
	public void Emp_Details() throws TimeoutException, Exception {
		
		Action.click(getDriver(), Employee_List);
		Thread.sleep(10000);
		Action.isDisplayed(getDriver(), VerifyEmpPage);
		getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
	}
	
	public void Logout() throws Throwable {
		Action.click(getDriver(), Logout);
	}

}

