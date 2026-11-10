package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {
	
	HomePage homeObject;
	ContactUsPage contactusObject;
	
	String fullName = "Test User";
	String email = "test@test.com";
	String enquiry = "this is for test";
	
	@Test
	public void UserCanUseContactUs()
	{
		homeObject = new HomePage(driver);
		homeObject.OpenContactUsPage();
		contactusObject = new ContactUsPage(driver);
		contactusObject.ContactUs(fullName, email, enquiry);
		Assert.assertTrue(contactusObject.successMessage.getText()
				.contains("Your enquiry has been successfully sent to the store owner"));
	}
	

}
