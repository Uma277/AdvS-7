package Testngtopic;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import genericlibr.ExcelUtil;
import genericlibr.WebdriverUtil;

public class LearningCrossBrowserTesting {

	WebDriver driver;
	WebdriverUtil wb = new WebdriverUtil();
	ExcelUtil um = new ExcelUtil();
	
	@Parameters("browser")
	@Test
	
	public void launch(@Optional("Edge") String bname) throws IOException
	{
		if(bname.contains("chrome"))
		{
			driver = new ChromeDriver();
			wb.maximaizeTheWindow(driver);
			driver.get(um.getDataFromPropertyfile("url"));
		}
		
		else if(bname.contains("Edge"))
		{
			driver = new EdgeDriver();
			wb.maximaizeTheWindow(driver);
			driver.get(um.getDataFromPropertyfile("url"));
		}
	}
}


