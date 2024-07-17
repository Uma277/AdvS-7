package Testngtopic;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import POMRepo.LoginPage;
import POMRepo.OrganisationPage;
import genericlibr.ExcelUtil;

public class MultipleDataUsingDataProvider 
{
	public String[][]testData() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/java/resources/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
	//	String sheet1;
		Sheet sheet = wb.getSheet("Sheet1");
		int rowNum = sheet.getPhysicalNumberOfRows();
		int colNum = sheet.getRow(0).getPhysicalNumberOfCells();
		String data[][] = new String[rowNum][colNum];
		for(int i=0;i<rowNum;i++) {
			for(int j=0;j<colNum;j++)
			{
				data[i][j] = sheet.getRow(i).getCell(j).toString();
			}
			
	}
		return data;

}


@Test(dataProvider = "testData")
public void details(String[] testData) throws IOException, InterruptedException
{
	WebDriver driver = new ChromeDriver();
	ExcelUtil um = new ExcelUtil();
	driver.get(um.getDataFromPropertyfile("url"));
	LoginPage lp = new LoginPage(driver);
	lp.getUserTxtBox().sendKeys(um.getDataFromPropertyfile("username"));
	lp.getLoginButton().click();
	OrganisationPage op = new OrganisationPage(driver);
	op.getOrganisationLink().click();
	op.getCreateOrganisation().click();
	op.getNameTxtBox().sendKeys(testData[0]);
	Thread.sleep(2000);
	op.getPhoneTxtBox().sendKeys(testData[1]);
	Thread.sleep(2000);
	op.getEmailTxtBox().sendKeys(testData[2]);
	
}

}