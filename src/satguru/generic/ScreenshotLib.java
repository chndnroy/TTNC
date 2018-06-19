package satguru.generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ScreenshotLib {
	public void getScreenshot(WebDriver driver,String fileName)
	{
		EventFiringWebDriver efw=new EventFiringWebDriver(driver);
		File srcFile = efw.getScreenshotAs(OutputType.FILE);
		File destFile=new File("/home/ttuser10/workspace/portal/Screenshots/"+fileName+".png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}


