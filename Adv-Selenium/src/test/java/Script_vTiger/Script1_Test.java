package Script_vTiger;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibr.JavaUtil;
import POMRepo.OrganisationPage;
import genericlibr.BaseClass;
import genericlibr.ExcelUtil;

public class Script1_Test extends BaseClass
{
	@Test
	public void script1()throws EncryptedDocumentException, IOException, InterruptedException
	{
		//WebDriver driver;
		OrganisationPage op = new OrganisationPage(driver);
		op.getOrganisationLink().click();
		SoftAssert sa = new SoftAssert();
		
		sa.assertEquals(driver.getTitle(), "Administrator - Organizations-vtiger CRM 5- Commercial Open Source CRM", "Actual & expected condition not matching");
		
		op.getCreateOrganisation().click();
		assertEquals(op.getCreateOrgTxt().isDisplayed(),true,"Not displayed the text");
		JavaUtil ja = null;
		int ranNum = ja.getRandomNumber();
		ExcelUtil um = null;
		String data = um.getDataFromExcelFile("Organisation",0,0)+ranNum;
		
		WebElement ele = op.getNameTxtBox();
		ele.sendKeys(um.getDataFromExcelFile("Organisation",0,0)+ranNum);
		sa.assertEquals(ele.getAttribute("value"),data,"data are not matching");
		op.getSaveButton().click();
		sa.assertEquals(driver.getTitle()," Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM");
		Thread.sleep(2000);
		
		
		
		
	}

}
