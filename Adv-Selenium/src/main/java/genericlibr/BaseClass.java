package genericlibr;

import java.io.IOException;
import java.lang.reflect.Method;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.annotations.Parameters;
//import com.github.dockerjava.transport.DockerHttpClient.Request.Method;

import POMRepo.LoginPage;

@Listeners(ListenerImplementation.class)
public class BaseClass
{
	public WebDriver driver;
	WebdriverUtil wb =  new WebdriverUtil();
	ExcelUtil um = new ExcelUtil();
	LoginPage lp = new LoginPage(driver);
	public ExtentSparkReporter reporter;
	public ExtentReports reports;
	public ExtentTest test;
	
	
	@BeforeSuite(alwaysRun = true)
	public void beforesuite()
	{
		Reporter.log("Report generation",true);
		reporter = new ExtentSparkReporter(IConstant.reportPath);
		reports = new ExtentReports();
		reports.attachReporter(reporter);
	}
	
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void beforeClass(@Optional("chrome")String bname) throws IOException, InterruptedException
	{
		if(bname.contains("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(bname.contains("firefox"))
		{
			driver = new EdgeDriver();
		}
		driver = new EdgeDriver();
		wb.maximaizeTheWindow(driver);
		wb.implicitlyWait(driver);
		Thread.sleep(3000);
		driver.get(um.getDataFromPropertyfile("url"));
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method method) throws IOException,InterruptedException
	{
		test = reports.createTest(method.getName());
		Reporter.log(method.getName(),true);
		LoginPage lp = new LoginPage(driver);
		lp.getUserTxtBox().sendKeys(um.getDataFromPropertyfile("username"));
		test.log(Status.INFO, "User has entered username");
		Thread.sleep(2000);
		lp.getPswdTxtBox().sendKeys(um.getDataFromPropertyfile("password"));
		test.log(Status.INFO, "User has entered password");
		lp.getLoginButton().click();
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException
	{
		Thread.sleep(3000);
		lp = new LoginPage(driver);
		lp.getAdminButton().click();
		lp.getLogoutButton().click();
	}
	
	@AfterClass
	public void afterClass() {
		wb.closeBrowser();
	}
	
	
	@AfterSuite
	public void afterSuite()
	{
		Reporter.log("Report",true);
		reports.flush();
	}
	
	
}
	
	


