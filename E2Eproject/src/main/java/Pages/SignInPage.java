package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	WebDriver driver;
	
	public SignInPage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="ap_email")
	WebElement email;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement continuebutton;
	
	@FindBy(xpath="//input[@id='ap_password']")
	WebElement password;
	
	@FindBy(id="signInSubmit")
	WebElement signin;
	
	public WebElement emailtextbox(){
		
		return email;
	}
	
	public WebElement continuebutton(){
		
		return continuebutton;
	}
	
public WebElement passwordtextbox(){
		
		return password;
	}
public WebElement signinbutton(){
	
	return signin;
}
}


