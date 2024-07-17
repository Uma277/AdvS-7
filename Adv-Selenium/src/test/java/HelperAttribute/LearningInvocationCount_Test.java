package HelperAttribute;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class LearningInvocationCount_Test 
{
	@Test (invocationCount = 3)
	public void Launch() throws InterruptedException
	{
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(3000);
		driver.quit();
		
	}
	
	@Test (invocationCount = 2)
	public void Demo()
	{
		Reporter.log("testng",true);
	}
	
	
}
