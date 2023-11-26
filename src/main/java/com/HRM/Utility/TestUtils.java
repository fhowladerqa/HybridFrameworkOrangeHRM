package com.HRM.Utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.HRM.Base.BaseClass;

public class TestUtils extends BaseClass {
	
	public void getScreenShot() throws IOException {
		
		Date currentdate = new Date();
		String screenshotfilename = currentdate.toString().replace(" ", "-").replace(":", "-");
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(screenshotFile, new File(".//screenshot//" + screenshotfilename + "error.png"));
		String destinationScreenShotPath = System.getProperty("user.dir")+"\\screenshot\\"+screenshotfilename+"testfail.png";
		try {
		FileHandler.copy(screenshotFile, new File(destinationScreenShotPath));
	} catch (IOException e) {
		e.printStackTrace();
	}

}
}