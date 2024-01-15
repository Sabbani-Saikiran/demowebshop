package Testpages;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Base.basepage;
import Utilities.Xls_DataProvider2;
import pages.Homepage;
import pages.Loginpage;

@Listeners(ItestListenerClass.class)

public class LoginpageTest extends basepage{
	
	
	Homepage hp;
	Loginpage lp;
	
	@BeforeMethod
	public void openApplication() throws MalformedURLException {

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
	
	
	
	@BeforeTest
	public void getnameMethod(ITestContext context) {
		
		extentTest = extentreports.createTest(context.getName());
	}
	
	@BeforeSuite // this method will be excuted before suite begins its execution
	public void InitalizeExtentReport() {
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter("login_report.html");
		extentreports = new ExtentReports();
		extentreports.attachReporter(sparkreporter);
		// on the report display more information about OS, browser, java etc
		extentreports.setSystemInfo("OS", System.getProperty("os.name"));
		extentreports.setSystemInfo("JAVA", System.getProperty("java.version"));

	}

	@AfterSuite
	public void generateReports() throws IOException {
		extentreports.flush();
		Desktop.getDesktop().browse(new File("login_report.html").toURI());
	}
	

}
