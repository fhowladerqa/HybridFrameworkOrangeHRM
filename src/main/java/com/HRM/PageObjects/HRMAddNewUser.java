package com.HRM.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.net.UrlChecker.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.Base.BaseClass;
import com.HRM.actiondriver.Action;

public class HRMAddNewUser extends BaseClass {
	
	@FindBy(xpath = "//input[@id='txtUsername']")
	WebElement Username;
	
	@FindBy(css = "input[id='txtPassword']")
	WebElement Password;
	
	@FindBy(xpath = "//button[text()='Login']")
	WebElement Login;

	@FindBy (css = "div[id='top_level_menu_item_menu_item_37']")
	WebElement Emp_List;
	
	@FindBy (xpath = "//a[@id='addEmployeeButton']")
	WebElement Add_Emp;
	
	@FindBy (xpath = "//h5[text()='Add Employee']")
	WebElement Ver_New_Emp;
	
	@FindBy (xpath = "//input[@id='first-name-box']")
	WebElement First_Name;
	
	@FindBy (css = "input[id='middle-name-box']")
	WebElement Middle_Name;
	
	@FindBy (css = "input[id='last-name-box']")
	WebElement Last_Name;
	
	@FindBy (xpath = "//input[@id='autoGenerateEmployeeId']")
	WebElement Auto_Gen_Off;
	
	@FindBy (xpath = "//input[@id='employeeId']")
	WebElement Emp_Id;
	
	@FindBy (xpath = "//button[@ng-click='vm.cancel()']")
	WebElement Cancel_Btn;
	
	@FindBy (xpath = "//input[@id='joinedDate']")
	WebElement Date_Range;
	
	@FindBy (xpath = "//i[@class='selected-item-icon material-icons']//parent::button[@class='btn']")
	WebElement material_icons;
	
	@FindBy (xpath = "//span[@class='text']//following::a[@id='bs-select-1-22']")
	WebElement Location;
	
	@FindBy (xpath = "//input[@id='hasLoginDetails']")
	WebElement Auto_Gen_off2;
	
	@FindBy (xpath = "//input[@id='username']")
	WebElement New_Username;
	
	@FindBy (xpath = "//input[@id='password']")
	WebElement New_Password;
	
	@FindBy (xpath = "//input[@id='confirmPassword']")
	WebElement Confirm_password;
	
	@FindBy (xpath = "//div[text()='Default ESS']")
	WebElement ESS;
	
	@FindBy (xpath = "//div[text()='Default Supervisor']")
	WebElement supervisor;
	
	@FindBy (xpath = "//button[@data-id='adminRoleId']")
	WebElement Admin_Role;
	
	@FindBy (xpath = "//span[text()='Regional HR Admin']")
	WebElement new_admin;
	
	@FindBy (xpath = "//button[text()='Next']")
	WebElement next_btn;
	
	@FindBy(xpath = "//span[text()='Log Out']")
	WebElement Logout;
	
	public HRMAddNewUser()  {
		
		PageFactory.initElements(getDriver(), this);
	}
	
	public void login (String uname, String pswd) throws Throwable {
		Action.type(Username, uname);
		Action.type(Password, pswd);
		Action.click(getDriver(), Login);
		
	}

	public void Add_New_User_Module() throws TimeoutException, InterruptedException {
		
		Action.click(getDriver(), Emp_List);
		Thread.sleep(15000);
		Action.click(getDriver(), Add_Emp);
		Action.ImplicitWait(8000);
	}
	
	public boolean Veri_New_Emp_Page() throws Exception, TimeoutException{
		
		
		return Action.isDisplayed(getDriver(), Ver_New_Emp);
		
	}
	
	public void Enter_New_Info(String fname, String mname, String Lname, String emp_id, String join_date, String new_uid, String new_pw, String confrm_pw) throws Throwable {
		
		Action.type(First_Name, fname); 
		 Action.type(Middle_Name, mname);
		 Action.type(Last_Name, Lname);
		 Thread.sleep(3000);
		 Action.click(getDriver(), Auto_Gen_Off);
		 Action.type(Emp_Id, emp_id);
		 Thread.sleep(3000);
		 Action.type(Date_Range, join_date);
		 Thread.sleep(3000);
		 Action.click(getDriver(), material_icons);
		 Action.ExplicitWait(10000);
		 Action.click(getDriver(), Location);
		 Action.click(getDriver(), Auto_Gen_off2);
		 Thread.sleep(5000);
		 Action.type(New_Username, new_uid);
		 Action.type(New_Password, new_pw);
		 Action.type(Confirm_password, confrm_pw);
		 Thread.sleep(5000);
		 Action.click(getDriver(), ESS);
		 Action.click(getDriver(), supervisor);
		 Action.click(getDriver(), Admin_Role);
		 Action.click(getDriver(), new_admin);
		 Thread.sleep(4000);
		 Action.click(getDriver(), next_btn);
		
	}

	public void logout() throws TimeoutException, InterruptedException {
		Thread.sleep(5000);
		Action.click(getDriver(), Logout);

}
}
