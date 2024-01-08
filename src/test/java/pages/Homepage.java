package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	
	@FindBy(linkText = "Log in")
	WebElement Loginbtn;
	
	
	@FindBy(linkText="Register")
	WebElement Registerbtn;
	
	@FindBy(linkText="Shopping cart")
	WebElement Shoppingcartbtn;
	
	
	@FindBy(linkText="Wishlist")
	WebElement Wishlistbtn;
	
	
	public Homepage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	
	public void clickonLogin() {

		Loginbtn.click();
	}

	public void clickonRegister() {

		Registerbtn.click();

	}

	public void clickOnShoppingCart() {

		Shoppingcartbtn.click();
	}

	public void clickOnWishList() {

		Wishlistbtn.click();
	}
	
	
	


}
