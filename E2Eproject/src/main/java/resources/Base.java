package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;



public class Base {

	public static WebDriver driver;
	public Properties prop;
	 
	
	public WebDriver initiatebrowser() throws Exception
	{
		
		
		 prop = new Properties();
		File src = new File("/Users/venkateshwarlu/Documents/workspace/E2Eproject/src/main/java/resources/OR.properties");
		FileInputStream fis = new FileInputStream(src);
		prop.load(fis);
		
		String browsername = prop.getProperty("browser");
		System.out.println(browsername);
		if(browsername.equalsIgnoreCase("firefox")){
			
			System.setProperty("webdriver.gecho.driver", "Users/venkateshwarlu/Documents/workspace/E2Eproject/geckodriver");
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("url"));
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
		
}
	
	public void getScreenshot(String result) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("/Users/venkateshwarlu/Documents/workspace/E2Eproject/screenshots/"+result+"screenshot.png"));
		
	}
	
	
	
	
	
}
