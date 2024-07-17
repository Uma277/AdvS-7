package HardCode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POMRepo.LoginPage;
import genericlibr.ExcelUtil;
import genericlibr.WebdriverUtil;

public class ScriptUsingPom {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		WebdriverUtil wb = new WebdriverUtil();
		ExcelUtil um = new ExcelUtil();
		wb.maximaizeTheWindow(driver);
		wb.implicitlyWait(driver);
		driver.get(um.getDataFromPropertyfile("url"));
		LoginPage lp = new LoginPage(driver);
		lp.getUserTxtBox().sendKeys(um.getDataFromPropertyfile("username"));
		lp.getPswdTxtBox().sendKeys(um.getDataFromPropertyfile("password"));
		lp.getLoginButton().click();
	}

}
