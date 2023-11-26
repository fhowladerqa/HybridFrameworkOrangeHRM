package com.HRM.Base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.HRM.actiondriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	//public static WebDriver driver;
	//Declare ThreadLocal Driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	

	 public static WebDriver getDriver() {
		//Get Driver from threadLocalmap
		return driver.get();
	}
	@BeforeTest
	public void loadConfig() {
		
		try { 
			prop = new Properties();
			System.out.println("super constructor invoked");
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("driver: " + driver);
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (@SuppressWarnings("hiding") IOException e) {
			e.printStackTrace();
		}
	}
	@Parameters({"browser", "URL"})
	public static void launchApp(String browsername, String url) {
			
			//String browsername = prop.getProperty("browser");
			if(browsername.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				//ChromeOptions options = new ChromeOptions();
				//options.setBinary("C:\\Users\\faris\\Downloads\\chrome-win64 (1)\\chrome-win64\\chrome.exe");
				//driver = new ChromeDriver(options);
				//Set Browser to ThreadLocalMap
				driver.set(new ChromeDriver());
			} else if (browsername.equalsIgnoreCase("FireFox")) {
				WebDriverManager.firefoxdriver().setup();
				//Set Browser to ThreadLocalMap
				driver.set(new FirefoxDriver());
			} else if (browsername.equalsIgnoreCase("Edge")) {
				WebDriverManager.edgedriver().setup();
				//Set Browser to ThreadLocalMap
				driver.set(new EdgeDriver());
			}
			
			getDriver().manage().window().maximize();
			Action.ImplicitWait(20);
			getDriver().manage ().timeouts ().pageLoadTimeout (30, TimeUnit.SECONDS);
			//getDriver().get(prop.getProperty("url"));
			getDriver().get(url);
		}
	
	
	
}