package HelperAttribute;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class LearningDependsOnMethod 
{
	@Test(priority =1)
	public void login()
	{
		int i =1/0;
		Reporter.log("User has login the application", true);
	}
	
	@Test(dependsOnMethods="login", priority = 2)
	public void addcart()
	{
		Reporter.log("User has added product to cart", true);
		
	}
	
	@Test(dependsOnMethods="login", priority=3)
	public void logout()
	{
		Reporter.log("User has logout the application", true);
	}

	
}
