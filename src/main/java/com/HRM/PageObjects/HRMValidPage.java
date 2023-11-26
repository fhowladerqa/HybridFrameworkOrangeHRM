package com.HRM.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.Base.BaseClass;
import com.HRM.actiondriver.Action;

public class HRMValidPage extends BaseClass {
	
	@FindBy(xpath = "//div[@class='organization-logo shadow']//img")
	WebElement OrangeHRM_Logo;
	
	@FindBy(xpath = "//input[@id='txtUsername']")
	WebElement Username;
	
	@FindBy(css = "input[id='txtPassword']")
	WebElement Password;
	
	@FindBy(xpath = "//button[text()='Login']")
	WebElement Login;
	
	@FindBy(xpath = "//div[@id='ohrm-small-logo']//div")
	WebElement VerifyHRM;
	
	@FindBy(xpath = "//span[text()='Log Out']")
	WebElement Logout;
	
	public HRMValidPage() {
		
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateLogo() throws Exception {
		return Action.isDisplayed(getDriver(), OrangeHRM_Logo);
		
	}
	
	public void login (String uname, String pswd) throws Throwable {
		Action.type(Username, uname);
		Action.type(Password, pswd);
		Action.click(getDriver(), Login);
		
	}
	
	public boolean VerifyPage() throws Exception {
		
		Action.ExplicitWait(6000);
		return Action.isDisplayed(getDriver(), VerifyHRM);
	}
	
	public void Logout() throws Throwable {
		Action.click(getDriver(), Logout);
	}

	
		
	}

	

