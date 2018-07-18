package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.Landingpage;
import Pages.SignInPage;
import resources.Base;


@Listeners(testcases.listeners.class)
public class SigninTest extends Base{
	
	@BeforeTest
	
	public void openbrowser() throws Exception{
		
		driver = initiatebrowser();
	}
	
	
	@Test
	public void verifysigninpageTitle() throws Exception
	{
	
		
	Landingpage lp = new Landingpage(driver);
	lp.accountlistmouseover().build().perform();	
	lp.Signinbutton().click();
	String actualtitle = driver.getTitle();
	Assert.assertEquals(actualtitle, "Amazon Sign In");
	
	
	driver.navigate().back();
	Thread.sleep(3000);
		
	}
	
	@Test
	public void signin() throws Exception{
		
		
		
		Landingpage lp = new Landingpage(driver);
		lp.accountlistmouseover().build().perform();	
		lp.Signinbutton().click();
		SignInPage sp= new SignInPage(driver);
		sp.emailtextbox().sendKeys(prop.getProperty("username"));
		sp.continuebutton().click();
		sp.passwordtextbox().sendKeys(prop.getProperty("password"));
		sp.signinbutton().click();
		
	}
	
	@AfterTest
	public void complete(){
		
		driver.quit();
	}

}
