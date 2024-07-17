package POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	public ContactPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText= "Contacts")
	private WebElement ContactLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateContact;
	
	@FindBy(name="firstname")
	private WebElement Firstname;
	
	public WebElement getContactLink() {
		return ContactLink;
	}

	public WebElement getCreateContact() {
		return CreateContact;
	}

	public WebElement getFirstname() {
		return Firstname;
	}

	public WebElement getLastname() {
		return Lastname;
	}

	@FindBy(name="lastname")
	private WebElement Lastname;
	
	
	
	

}
