package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase {

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="FullName")
	WebElement fullnameTxtbox;
	
	@FindBy(id="Email")
	WebElement emailTxtbox;
	
	@FindBy(id="Enquiry")
	WebElement enquiryTxtbox;
	
	@FindBy(css="button.button-1.contact-us-button")
	WebElement submitBtn;
	
	@FindBy(css="div.result")
	public WebElement successMessage;
	
	public void ContactUs(String fullName, String email, String enquiry )
	{
		setTextElementText(fullnameTxtbox, fullName);
		setTextElementText(emailTxtbox, email);
		setTextElementText(enquiryTxtbox, enquiry);	
		clickButton(submitBtn);
	}
}
