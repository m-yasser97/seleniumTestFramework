package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.UserRegsitrationPage;

public class RegisteredUserCheckoutProductTest extends TestBase{

	//1-Register user
	//2-Search for product
	//3-add to cart
	//4-checkout
	//5-logout
	HomePage homeObject;
	UserRegsitrationPage registerObject;
	LoginPage loginObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartObject;
	CheckoutPage checkoutObject;
	String productName = "Apple MacBook Pro";
	
	
	@Test(priority = 1)
	public void UserCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegsitrationPage(driver);
		registerObject.UserRegistration("Moataz", "Nabil", "testemail@gmail.com", "12345678");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	
	@Test(priority=2)
	public void UserCanSearchWithAutoSuggest()
	{
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("MacB");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
	}
	
	@Test(priority=3)
	public void UserCanAddProductToShoppingCart()
	{
		detailsObject.addToCart();
		detailsObject.GoToShoppingCart();
		cartObject = new ShoppingCartPage(driver);
		Assert.assertTrue(cartObject.totalLbl.getText().contains("3,600"));
		Assert.assertEquals(cartObject.productNameTxt.getText(),productName);
	}
	
	@Test(priority=4)
	public void UserCanCheckoutProduct()
	{
		checkoutObject = new CheckoutPage(driver);
		cartObject.OpenCheckoutPage();
		checkoutObject.RegisteredUserCheckoutProduct
		("Egypt", "testaddress", "Cairo", "Cairo", "0120912", "10289212");
		Assert.assertTrue(checkoutObject.productNameTxt.isDisplayed());
		Assert.assertTrue(checkoutObject.productNameTxt.getText().contains(productName));
		checkoutObject.confirmOrder();
		Assert.assertTrue(checkoutObject.thankyouLbl.isDisplayed());
	}
	
	@Test(priority=4)
	public void RegisteredUserCanLogout()
	{
		registerObject.userLogut();
	}
}
