package Script_vTiger;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.internal.BaseClassFinder;

import POMRepo.CampaignsPage;
import POMRepo.OrganisationPage;
import genericlibr.BaseClass;
import genericlibr.ExcelUtil;

public class Script4 extends BaseClass {
	
	@Test
	
	public void script4() throws IOException
	{
		WebDriver driver = null;
		CampaignsPage cp = new CampaignsPage(driver);
		ExcelUtil um = new ExcelUtil();
		cp.getMoreOption().click();
		cp.getCampaignsLink().click();
		cp.getCreateCampaign().click();
		cp.getCampaignsName().sendKeys(um.getDataFromExcelFile("campaign", 0, 0));
		OrganisationPage op = new OrganisationPage(driver);
		op.getSaveButton().click();
	}

}
