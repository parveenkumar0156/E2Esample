package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.Landingpage;
import Pages.sportsnclothingpage;
import resources.Base;

@Listeners(testcases.listeners.class)
public class addtocartTest extends Base {
	
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void openbrowser() throws Exception{
		
		driver = initiatebrowser();
	}
	@Test
	public void additemtocart() throws Exception
	{
	
	
	log.info("initializing the browser");
	
	
	Landingpage lp = new Landingpage(driver);
	lp.departmentsmoveover().build().perform();
	lp.sportsoutdoormoveover().build().perform();
	lp.athleticlothingmoveover().click();
	sportsnclothingpage sp = new sportsnclothingpage(driver);
	sp.womenssection().click();
	sp.shirtslink().click();
	sp.tshirtslink().click();
	sp.selectrequiredclothing("Ultimate Short Sleeve V-Neck Tee");
	sp.selectsize("_3");
	//Thread.sleep(3000);
	sp.addtocartbutton().click();
	
	
	
	}
	
	
	
	@AfterTest
	public void complete(){
		
		driver.quit();
	}


}
