package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class sportsnclothingpage {

	WebDriver driver;
	
	public sportsnclothingpage(WebDriver driver) 

	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//span[text()='WOMEN']")
	WebElement womensection;

	@FindBy(xpath="//span[text()='Shirts'][@class='a-color-link a-text-bold']")
	WebElement shirts;
	
	@FindBy(xpath="//span[text()='T-Shirts'][@class='a-color-link a-text-bold']")
	WebElement tshirts;
	
	By requiredclothing = By.xpath("//div[@id='anonCarousel1']/ol/li/a");
	By selectsizebutton = By.xpath(".//*[@id='dropdown_selected_size_name']/span/span");
	By dresssizes = By.xpath(".//*[@id='native_dropdown_selected_size_name_1']");
	By addtocart = By.cssSelector("input[id='add-to-cart-button']");
	
	public WebElement womenssection(){
		
		  return womensection;
	}
	public WebElement shirtslink(){
		
		return shirts;
		
	}
public WebElement tshirtslink(){
		
		return tshirts;
		
	}
	
	
	
	public void selectrequiredclothing(String text)
	{
		
		List<WebElement> dresses = driver.findElements(requiredclothing);
		
		for(int i=0;i<dresses.size();i++)
		{
			
			String dresstext = dresses.get(i).getText();
			if(dresstext.contains(text))
			{
				
				
				dresses.get(i).click();
				break;
				
			}
		
		}
		
	
	}
	
	public void selectsize(String size) throws Exception
	{
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectsizebutton));
		js.executeScript("document.getElementByClass('a-button-text a-declarative').click();");
		Thread.sleep(3000);
		List<WebElement> allsizes = driver.findElements(dresssizes);
		 for(int i=0;i<allsizes.size();i++)
		 {
			 
			 String idname = allsizes.get(i).getAttribute("id");
			 Thread.sleep(3000);
			 if(idname.contains(size))
			 
			 {
				 
				 allsizes.get(i).click();
				 break;
			 }
		 }
		
	}
	
	public WebElement addtocartbutton()
	{
		
		return driver.findElement(addtocart);
	}
		
	}

