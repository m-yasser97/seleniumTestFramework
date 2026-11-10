package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegsitrationPage;

public class EmailFriendTest extends TestBase {

	//1- User Registration
	//2-Search for a product
	//3-Email to Friend
	
	HomePage homeObject;
	UserRegsitrationPage registerObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	String productName = "Apple MacBook Pro";
	ProductReviewPage reviewObject;
	
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
	//3-email to friend
	@Test(priority=3)
	public void RegisteredUserCanSendProductToFriend()
	{
		detailsObject.GotoAddReviewPage();
		reviewObject = new ProductReviewPage(driver);
		reviewObject.AddProductReview("new review", "the product is very good");
		Assert.assertTrue(reviewObject.successMessage.getText().
				contains("Product review is successfully added."));
	}
	
	//4-user logout
	@Test(priority = 4)
	public void UserCanLogout()
	{
		registerObject.userLogut();
	}
}
