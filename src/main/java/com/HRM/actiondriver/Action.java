package com.HRM.actiondriver;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.net.UrlChecker.TimeoutException;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.HRM.Base.BaseClass;

public class Action extends BaseClass {
	
	private static final long TIMEOUT = 0;
	public static void scrollByVisibilityofElements(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}
	
	public static void click(WebDriver ldriver, WebElement locatorname) throws TimeoutException{
		
		Actions act = new Actions(ldriver);
		act.moveToElement(locatorname).click().build().perform();
		
	}

	public static boolean findElement(WebDriver ldriver, WebElement ele) throws TimeoutException {
		boolean flag = false;
		try {
			ele.isDisplayed();
			flag = true;
		}  catch (Exception e) {
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Successfully Found element at");
			
			} else {
				System.out.println("Unable to find Locate Element");
			}
		}
		return flag;
	}
	
	public static boolean isDisplayed(WebDriver ldriver, WebElement ele) throws TimeoutException {
		boolean flag= false;
		flag = findElement(ldriver, ele);
		if (flag) {
			flag = ele.isDisplayed();
			if (flag) {
				System.out.println("The element is displayed");
			} else {
				System.out.println("The element is not displayed");
			}
		} else {
			System.out.println("Not displayed");
		}
		return flag;
	}
	
	public static boolean isSelected(WebDriver ldriver, WebElement ele) throws TimeoutException {
		boolean flag = false;
		flag = findElement(ldriver, ele);
		if (flag) {
			flag = ele.isSelected();
			if (flag) {
				System.out.println("The element is selected");
			} else {
				System.out.println("Not selected");
			}
		} else {
			System.out.println("Not selected");
		}
		return flag;
	}
	
	public static boolean isEnabled(WebDriver ldriver, WebElement ele) throws Throwable {
		boolean flag = false;
		flag = findElement(ldriver, ele);
		if (flag) {
			flag = ele.isEnabled();
			if (flag) {
				System.out.println("The element is Enabled");
			} else {
				System.out.println("The element is not Enabled");
			}
		} else {
			System.out.println("Not Enabled");
		}
		return flag;
	}
	
	public static boolean type(WebElement ele, String text) throws Throwable{
		boolean flag = false;
		try {
			flag = ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
			flag = true;
		}  catch (Exception e)  {
			System.out.println("Location Not found");
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Successfully entered value");
			}  else {
				System.out.println("Unable to enter value");
			}
		}
		return flag;
	}
	
	public static boolean selectByIndex(WebElement element, int index) throws Throwable{
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByIndex(index);
			flag = true;
			return true;
		}  catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by Index");
			} else {
				System.out.println("Option Not selected by Index");
			}
		}
	}
	
	public boolean selectByVisibleText(String visibletext, WebElement ele) throws Throwable {
		boolean flag = false;
		try {
			Select s = new Select(ele);
			s.selectByVisibleText(visibletext);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}  finally {
			if (flag) {
				System.out.println("Visible Text selected by Index");
			} else {
				System.out.println("Visible Not selected by Index");
			}
		}
	}
	
	public static boolean selectBySendKeys(WebElement ele, String value) throws Throwable {
		boolean flag = false;
		try {
			ele.sendKeys(value);
			flag = true;
			return true;
		}  catch (Exception e) {
			
			return false;
		} finally {
			if (flag) {
				System.out.println("Select value from the dropdown");
			} else {
				System.out.println("Not Selected value from the dropdown");
				// throw new ElementNotFoundException("", "", "")
			}
		}
	}
	
	public static boolean JSClick(WebDriver driver, WebElement ele) throws Throwable {
		boolean flag= false; 
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);
		
		flag = true;
		
		if (flag) {
	 			System.out.println("Click Action is performed");
	 		} else if (!flag) {
	 			System.out.println("Click Action is Not performed");
	 		}
	 	
	 		return flag;
	}

	public static boolean mouseHoverByJavaScript(WebElement locator) throws Throwable {
		boolean flag = false;
		try {
			WebElement mo = locator;
			String javaScript = "var ecobj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', \r\n"
					+ "evobj.initMouseEvent(\"mouseover\",true,false,window;}\""
					+ "true, false); arguments[0].dispatchEvent(evObj);} "
					+ "arguments[0].dispatchEvent(evobj);";
					
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(javaScript, mo);
			flag = true;
			return true;
		}
	
		catch (Exception e) {
			
			return false;
		} finally {
			if (flag) {
				System.out.println("MouseOver Action is performed");
			} else {
				System.out.println("MouseOver Action is Not performed");
			}
		}
	
	}
	public static boolean ExplicitWait(int i) {
		boolean flag = false;
		try {
			int mo = i;
			WebDriverWait wait = new WebDriverWait((getDriver()), Duration.ofSeconds(30));
			flag = true;
			return true;
		}
		catch (Exception e) {
			
			return false;
		} finally {
			if (flag) {
				System.out.println("Explicit wait is performed before coming to the locator field!");
			} else {
				System.out.println("Explicit wait is not performed!");
			}
		}
	}
	
	public static boolean ImplicitWait(int i) {
		boolean flag = false;
		try {
			int mo =  i;
			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			flag = true;
			return true;
		}
		catch (Exception e) {
			
			return false;
		} finally {
			if (flag) {
				System.out.println("Implicit Wait is performed before launcing the application!");
			} else {
				System.out.println("Implicit wait is not performed!");
			}
		}
	}
}

