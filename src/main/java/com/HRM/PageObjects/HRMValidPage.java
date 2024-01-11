package com.HRM.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.Base.BaseClass;
import com.HRM.actiondriver.Action;

public class HRMValidPage extends BaseClass {
	
	@FindBy(xpath = "//img[@alt='company-branding']")
	WebElement OrangeHRM_Logo;
	
	@FindBy(xpath = "//input[@name='username']//parent::div")
	WebElement Username;
	
	@FindBy(xpath = "//input[@type='password']//parent::div")
	WebElement Password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement Login;
	
	@FindBy(xpath = "//img[@alt='client brand banner']")
	WebElement VerifyHRM;
	
	@FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	WebElement Logout;
	
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement Logout2;
	
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
		Action.click(getDriver(), Logout2);
	}

	
		
	}

	

