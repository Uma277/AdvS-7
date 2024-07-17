package Script_vTiger;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import genericlibr.ExcelUtil;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import POMRepo.ContactPage;
import POMRepo.OrganisationPage;
import genericlibr.BaseClass;

public class Script3 extends BaseClass
{
	@Test
	public void script3() throws IOException,EncryptedDocumentException
	{
		//WebDriver driver = null;
		ContactPage cp = new ContactPage(driver);
		ExcelUtil um = new ExcelUtil();
		cp.getContactLink().click();
		test.log(Status.INFO, "User has clicked on Contact link");
		cp.getCreateContact().click();
		test.log(Status.INFO, "User has clicked on create contact");
		
		cp.getLastname().sendKeys(um.getDataFromExcelFile("contact", 0, 0));
		OrganisationPage op = new OrganisationPage(driver);
		op.getSaveButton().click();
		
		
	}
}
