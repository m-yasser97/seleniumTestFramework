package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegsitrationPage;

public class AddProductReviewTest extends TestBase{
	
	//1-user register
	//2-Search for Product
	//3-Add review
	//4-Logout
	
	HomePage homeObject;
	UserRegsitrationPage registerObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	EmailPage emailPageObject;
	String productName = "Apple MacBook Pro";
	
	//1- User register
	@Test(priority = 1)
	public void UserCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegsitrationPage(driver);
		registerObject.UserRegistration("Moataz", "Nabil", "testemail@gmail.com", "12345678");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	//2-Search for a product
	@Test(priority = 2)
	public void UserCanSearchWithAutoSuggest()
	{
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("MacB");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
	}
	//3-add review
	@Test(priority=3)
	public void RegisteredUserCanReviewProduct()
	{
		detailsObject.GoToEmailtoFriendPage();
		
	}
	
	//4-user logout
	@Test(priority = 4)
	public void UserCanLogout()
	{
		registerObject.userLogut();
	}

}
