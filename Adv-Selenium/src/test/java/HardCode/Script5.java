package HardCode;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import genericlibr.ExcelUtil;
import genericlibr.WebdriverUtil;

public class Script5 {

	public static void main(String[] args) throws IOException {
		WebdriverUtil wb = new WebdriverUtil();
		ExcelUtil um = new ExcelUtil();
		WebDriver driver = new EdgeDriver();
		//wb.maximaizeTheWindow(driver);when you are nonstatic methods
		WebdriverUtil.maximaizeTheWindow(driver); //when you are calling static methods
		wb.implicitlyWait(driver);
		driver.get(um.getDataFromPropertyfile("url"));
		driver.findElement(By.name("user_name")).sendKeys(um.getDataFromPropertyfile("username"));
		driver.findElement(By.name("user_password")).sendKeys(um.getDataFromPropertyfile("password"));
		driver.findElement(By.id("submitButton")).click();

	}

}
