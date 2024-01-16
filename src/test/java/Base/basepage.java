package Base;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class basepage {

	
	public static WebDriver driver;
	public static ExtentReports extentreports;
	public static ExtentTest extentTest;
	
	public static void openBrowser(String browser) throws MalformedURLException  {
		
		driver = new ChromeDriver();
		
		
		//ChromeOptions cap = new ChromeOptions();

		//driver = new RemoteWebDriver(new URL("http://localhost:4449/wd/hub"), cap);
	

		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demowebshop.tricentis.com/");
	}
	
/*	@BeforeTest
	public void getnameMethod(ITestContext context) {
		
		extentTest = extentreports.createTest(context.getName());
	}
	
	@BeforeSuite // this method will be excuted before suite begins its execution
	public void InitalizeExtentReport() {
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter("register_user_report.html");
		extentreports = new ExtentReports();
		extentreports.attachReporter(sparkreporter);
		// on the report display more information about OS, browser, java etc
		extentreports.setSystemInfo("OS", System.getProperty("os.name"));
		extentreports.setSystemInfo("JAVA", System.getProperty("java.version"));

	}

	@AfterSuite
	public void generateReports() throws IOException {
		extentreports.flush();
		Desktop.getDesktop().browse(new File("register_user_report.html").toURI());
	} */

	@AfterMethod
	public void generateTestStatus(Method m, ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Capture Screenshot");
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			// Create a file at the destination and store the screenshot there.
			// ./ to take current project folder structure

			File destFile = new File("./Screenshots/demowebshop.png");

			FileUtils.copyFile(srcFile, destFile);
			extentTest.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.pass(m.getName() + " is passed");
		}
	}
	
	Logger logger = (Logger) LogManager.getLogger(basepage.class);

	@BeforeSuite
	public void method1() throws InterruptedException {
		System.out.println("this is method1");

		logger.trace(" This is trace method");
		Thread.sleep(2000);
		logger.info(" this is information message");
		Thread.sleep(2000);
		logger.error(" this is an error message");
		Thread.sleep(2000);
		logger.fatal(" this is a fatal messgae");
		Thread.sleep(2000);
		logger.warn(" this is a warning message");
		Thread.sleep(2000);
		System.out.println("this is end of method1");
	}

	
	
}
