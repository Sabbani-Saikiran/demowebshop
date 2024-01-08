package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registerpage {
	
	@FindBy(xpath = "//input[@id='gender-male']")
	WebElement malebtn;
	
	
	@FindBy(xpath = "//input[@id='gender-female']")
	WebElement femalebtn;

	
	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement firstname;
	
	@FindBy(xpath = "//input[@id='LastName']")
	WebElement lastname;
	
	@FindBy(xpath = "//input[@id='Email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='Password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	WebElement confirmpassword;
	
	@FindBy(xpath = "//input[@id='register-button']")
	WebElement registerbtn;
	
	@FindBy(xpath = "//input[@class='button-1 register-continue-button']")
	WebElement continuebtn;
	
	
	
	
	public Registerpage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	
	
	// Actions

		public void RegisterUser(String first_name, String last_name, String emailid_1, String password_1,
				String confirmpassword_1) {

			
			
			malebtn.click();
			
			
			firstname.clear();
			firstname.sendKeys(first_name);

			lastname.clear();
			lastname.sendKeys(last_name);

			email.clear();
			email.sendKeys(emailid_1);

			

			password.clear();
			password.sendKeys(password_1);

			confirmpassword.clear();
			confirmpassword.sendKeys(confirmpassword_1);

			
			registerbtn.click();
			
			continuebtn.click();

		}
	
	
	
	
}
