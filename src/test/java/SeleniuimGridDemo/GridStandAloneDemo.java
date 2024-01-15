package SeleniuimGridDemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

//import pages.Registerpage;

public class GridStandAloneDemo {
	
	WebDriver driver;

	@Test
	public void GridDemo1() throws MalformedURLException {

		// Declare desired capabilities to the hub to start a session on the node

		ChromeOptions cap = new ChromeOptions();

		driver = new RemoteWebDriver(new URL("http://localhost:4449/wd/hub"), cap);

		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/register");
		String title = driver.getTitle();
		System.out.println(title);

	}

}


