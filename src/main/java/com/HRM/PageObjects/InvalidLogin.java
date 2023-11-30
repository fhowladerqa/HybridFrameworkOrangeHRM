/**
 * 
 */
package com.HRM.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.net.UrlChecker.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.Base.BaseClass;
import com.HRM.actiondriver.Action;

/*Faris*
 * 
 */
public class InvalidLogin extends BaseClass{
	
	@FindBy(xpath = "//div[@class='organization-logo shadow']//img")
	WebElement OrangeHRM_Logo;
	
	@FindBy(xpath = "//input[@id='txtUsername']")
	WebElement Username;
	
	@FindBy(css = "input[id='txtPassword']")
	WebElement Password;
	
	@FindBy(xpath = "//button[text()='Login']")
	WebElement Login;
	
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement CredentialsWarning;
	
	@FindBy (xpath = "//span[text()='You have been restricted from accessing OrangeHRM temporarily.']")
	WebElement Restricted_Acct;
	
	
	public InvalidLogin() {
		
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateLogo() throws Exception {
		return Action.isDisplayed(getDriver(), OrangeHRM_Logo);
		
	}
	
	public void InvalidLoginCred(String Uid, String Pw) throws Throwable {
		Action.type(Username, Uid);
		Action.type(Password, Pw);
		Action.click(getDriver(), Login);
		
	}
	
	public boolean negativeCredentials() throws TimeoutException, InterruptedException {
		Thread.sleep(3000);
		try {
		return Action.isDisplayed(getDriver(), CredentialsWarning);
	} catch(Exception e) {
		return Action.isDisplayed(getDriver(), Restricted_Acct);
		
	}

}
}