package Testpages;

import java.net.MalformedURLException;
//import java.net.URL;

//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.basepage;
import pages.Homepage;



@Listeners(ItestListenerClass.class)

public class Homepagetest extends basepage{
	
	Homepage hp;
	
	
	
	@BeforeClass
	public void OpenApp() throws MalformedURLException {

		openBrowser("Chrome");
		hp = new Homepage(driver);
	}
	
	
	


	@Test(priority = '1')
	public void clickOnRegisterPage() throws InterruptedException {

		
		
		Thread.sleep(2000);
		hp.clickonRegister();
		Thread.sleep(2000);

	}

	@Test(priority = '2')
	public void clickOnLogin() throws InterruptedException {

		
		Thread.sleep(2000);
		hp.clickonLogin();
		Thread.sleep(2000);

	}

	@AfterClass
	public void CloseApp() {

		driver.quit();
	}
	
	

}
