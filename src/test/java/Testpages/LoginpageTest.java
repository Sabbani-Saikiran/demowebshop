package Testpages;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.basepage;
import Utilities.Xls_DataProvider2;
import pages.Homepage;
import pages.Loginpage;

@Listeners(ItestListenerClass.class)

public class LoginpageTest extends basepage{
	
	
	Homepage hp;
	Loginpage lp;
	
	@BeforeMethod
	public void openApplication() {

		openBrowser("Chrome");

		hp = new Homepage(driver);
		lp = new Loginpage(driver);
	}

	@Test(priority = '1', dataProvider = "testdata")
	public void LoginUser(String Email1, String Password1) {

		
		hp.clickonLogin();
		lp.LoginUser(Email1, Password1);
		

	}

	@DataProvider(name = "testdata")
	public Object[][] datasupplier() throws IOException {

		Object[][] input = Xls_DataProvider2.getTestData("Sheet1");
		return input;
	}
	

}
