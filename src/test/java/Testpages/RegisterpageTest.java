package Testpages;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
//import java.net.URL;

import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Base.basepage;
import Utilities.Xls_DataProvider;
import pages.Homepage;
import pages.Registerpage;



@Listeners(ItestListenerClass.class)


public class RegisterpageTest extends basepage {
	
	
	Homepage hp;
	Registerpage rp;
	
	
	@BeforeMethod
	public void openApplication() throws MalformedURLException {

		openBrowser("Chrome");
		
		
		//ChromeOptions cap = new ChromeOptions();

		//driver = new RemoteWebDriver(new URL("http://localhost:4449/wd/hub"), cap);
		//hp = new RemoteWebDriver(new URL("http://localhost:4449/wd/hub"), cap);
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
	
	@BeforeTest
	public void getnameMethod(ITestContext context) {
		
		extentTest = extentreports.createTest(context.getName());
	}
	
	@BeforeSuite // this method will be excuted before suite begins its execution
	public void InitalizeExtentReport() {
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter("register_report.html");
		extentreports = new ExtentReports();
		extentreports.attachReporter(sparkreporter);
		// on the report display more information about OS, browser, java etc
		extentreports.setSystemInfo("OS", System.getProperty("os.name"));
		extentreports.setSystemInfo("JAVA", System.getProperty("java.version"));

	}

	@AfterSuite
	public void generateReports() throws IOException {
		extentreports.flush();
		Desktop.getDesktop().browse(new File("register_report.html").toURI());
	}
	
	
	

}
