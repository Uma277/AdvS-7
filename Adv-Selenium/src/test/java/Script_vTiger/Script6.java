package Script_vTiger;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import POMRepo.OrganisationPage;
import POMRepo.ProductPage;
import genericlibr.ExcelUtil;

public class Script6 {
	
	@Test
	public void script6() throws IOException,InterruptedException,EncryptedDocumentException
	{
		WebDriver driver = null;
		ProductPage pp = new ProductPage(driver);
		ExcelUtil um = new ExcelUtil();
		pp.getProductLink().click();
		pp.getCreateProduct().click();
		pp.getProductName().sendKeys(um.getDataFromExcelFile("product", 0, 0));
		OrganisationPage op = new OrganisationPage(driver);
		op.getSaveButton().click();
	}

}
