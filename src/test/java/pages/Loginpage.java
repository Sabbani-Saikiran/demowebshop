package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	@FindBy(xpath ="//input[@class='email']")
	WebElement email;
	
	
	@FindBy(xpath = "//input[@class='password']")
	WebElement password;
	
	
	@FindBy(xpath = "//input[@id='RememberMe']")
	WebElement rememberme;
	
	
	@FindBy(xpath = "//input[@class='button-1 login-button']")
	WebElement login;
	
	
	
	public Loginpage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	
	public void LoginUser(String Email1, String Password1) {
		
		email.clear();
		email.sendKeys(Email1);
		
		password.clear();
		password.sendKeys(Password1);
		
		rememberme.click();
		
		login.click();
		
		
	}
	

}
