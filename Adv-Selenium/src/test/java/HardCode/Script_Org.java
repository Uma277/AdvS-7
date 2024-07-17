package HardCode;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POMRepo.LoginPage;
import POMRepo.OrganisationPage;
import genericlibr.ExcelUtil;
import genericlibr.JavaUtil;
import genericlibr.WebdriverUtil;

public class Script_Org {

	public static void main(String[] args) throws InterruptedException, IOException
	{
		WebDriver driver = new ChromeDriver();
		WebdriverUtil wb = new WebdriverUtil();
		ExcelUtil um = new ExcelUtil();
		wb.maximaizeTheWindow(driver);
		wb.implicitlyWait(driver);
		driver.get(um.getDataFromPropertyfile("url"));
		LoginPage lp =new LoginPage(driver);
		lp.getUserTxtBox().sendKeys(um.getDataFromPropertyfile("username"));
		lp.getPswdTxtBox().sendKeys(um.getDataFromPropertyfile("password"));
		lp.getLoginButton().click();
		Thread.sleep(2000);
		
		OrganisationPage op = new OrganisationPage(driver);
		op.getOrganisationLink().click();
		op.getCreateOrganisation().click();
		Thread.sleep(2000);
		JavaUtil ja = new JavaUtil();
		int num = ja.getRandomNumber();
		
		op.getNameTxtBox().sendKeys(um.getDataFromExcelFile("Organisation",0,0));
		Thread.sleep(3000);
		wb.selectDropdownByValue(op.getIndustryDropdown(), "Healthcare");
		Thread.sleep(3000);
		
		op.getSaveButton().click();
	
		
	
	}

}
