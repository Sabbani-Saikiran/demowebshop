package Testpages;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.basepage;
import Utilities.Xls_DataProvider;
import pages.Homepage;
import pages.Registerpage;



@Listeners(ItestListenerClass.class)


public class RegisterpageTest extends basepage {
	
	
	Homepage hp;
	Registerpage rp;
	
	
	@BeforeMethod
	public void openApplication() {

		openBrowser("Chrome");

		hp = new Homepage(driver);
		rp = new Registerpage(driver);
	}

	@Test(priority = '1', dataProvider = "testdata")
	public void RegisterUser(String first_name, String last_name, String emailid_1,String password_1,
			String confirmpassword_1) {

		
		hp.clickonRegister();
		rp.RegisterUser(first_name, last_name, emailid_1, password_1, confirmpassword_1 );
		

	}

	@DataProvider(name = "testdata")
	public Object[][] datasupplier() throws IOException {

		Object[][] input = Xls_DataProvider.getTestData("Sheet1");
		return input;
	}
	
	
	
	

}
