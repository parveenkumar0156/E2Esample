package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.Base;

public class Landingpage extends Base {
	WebDriver driver;
	Actions  act;
	
public Landingpage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	act=new Actions(driver); 
}


By signin = By.linkText("Sign in");

@FindBy(css="a#nav-link-accountList")
WebElement mouseover;

@FindBy(xpath=".//*[@id='nav-link-shopall']/span[@class='nav-line-2']")
WebElement departments;

@FindBy(xpath="//span[text()='Sports & Outdoors']")
WebElement sportsoutdoor;

By athleticlothing = By.xpath("//span[text()='Athletic Clothing']");
public WebElement Signinbutton(){
	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.invisibilityOfElementLocated(signin));
	return driver.findElement(signin);
}

public Actions accountlistmouseover(){
	return act.moveToElement(mouseover);
}

public Actions departmentsmoveover(){
	return act.moveToElement(departments);
}

public Actions sportsoutdoormoveover(){
	return act.moveToElement(sportsoutdoor);
}

public WebElement athleticlothingmoveover(){
	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(athleticlothing));
	return driver.findElement(athleticlothing);
}




}
