package com.HRM.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.net.UrlChecker.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.Base.BaseClass;
import com.HRM.actiondriver.Action;

public class HRMSalaryDetails extends BaseClass {
	
	@FindBy(xpath = "//input[@id='txtUsername']")
	WebElement Username;
	
	@FindBy(css = "input[id='txtPassword']")
	WebElement Password;
	
	@FindBy(xpath = "//button[text()='Login']")
	WebElement Login;
	
	@FindBy(xpath = "//a[normalize-space()='My Info']")
	WebElement MyInfobtn;
	
	@FindBy (xpath = "//a[normalize-space()='Salary']")
	WebElement Salary_Btn;
	
	@FindBy (xpath = "//span[@class='nav-item-title card-title-text'][normalize-space()='Salary History']")
	WebElement Salary_History;
	
	@FindBy (xpath = "//span[text()='(5) Salary History Records Found']")
	WebElement Ver_Salary;
	
	@FindBy(xpath = "//span[text()='Log Out']")
	WebElement Logout;
	
	public HRMSalaryDetails()  {
		
		PageFactory.initElements(getDriver(), this);
	}
	
	public void login (String uname, String pswd) throws Throwable {
		Action.type(Username, uname);
		Action.type(Password, pswd);
		Action.click(getDriver(), Login);
		
	}
	
	public void SalaryInfo() throws TimeoutException, InterruptedException {
		
		Action.click(getDriver(), MyInfobtn);
		Thread.sleep(3000);
		Action.click(getDriver(), Salary_Btn);
		Action.ImplicitWait(4000);
		Action.click(getDriver(), Salary_History);
		Action.isDisplayed(getDriver(), Ver_Salary);
	}
	
	public void logout() throws TimeoutException, InterruptedException {
		Thread.sleep(5000);
		Action.click(getDriver(), Logout);
}
}