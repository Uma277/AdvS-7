package HardCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericlibr.ExcelUtil;
import genericlibr.WebdriverUtil;

public class Script6 {

	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		WebdriverUtil wb = new WebdriverUtil();
		ExcelUtil um = new ExcelUtil();
		wb.maximaizeTheWindow(driver);
		driver.get(um.getDataFromPropertyfile("url"));
		//driver.findElement(By.name("user_name")).
		driver.findElement(By.name("user_password")).sendKeys(um.getDataFromPropertyfile("password"));
		driver.findElement(By.id("submitButton")).click();
		WebElement searchbox = driver.findElement(By.name("query_string"));
		searchbox.sendKeys("contacts");
		wb.refreshThePage(driver);
		searchbox.sendKeys("contacts");
		

	}

}
