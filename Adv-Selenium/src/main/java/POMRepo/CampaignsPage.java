package POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {
	public CampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath= "//a[@href='javascript:;']")
	private WebElement moreOption;
	
	public WebElement getMoreOption() {
		return moreOption;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getCreateCampaign() {
		return createCampaign;
	}

	public WebElement getCampaignsName() {
		return campaignsName;
	}

	@FindBy(linkText ="Campaigns")
	private WebElement campaignsLink;
	
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement createCampaign;
	
	@FindBy(name="campaignname")
	private WebElement campaignsName;

}
