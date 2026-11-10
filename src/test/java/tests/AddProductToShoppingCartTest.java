package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase {


	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartObject;
	String productName = "Apple MacBook Pro";
	
	@Test(priority=1)
	public void UserCanSearchWithAutoSuggest()
	{
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("MacB");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
	}
	
	@Test(priority=2)
	public void UserCanAddProductToShoppingCart()
	{
		detailsObject.addToCart();
		detailsObject.GoToShoppingCart();
		cartObject = new ShoppingCartPage(driver);
		Assert.assertTrue(cartObject.totalLbl.getText().contains("3,600"));
		Assert.assertEquals(cartObject.productNameTxt.getText(),productName);

		
	}
	
	@Test(priority=3)
	public void UserCanRemoveProductFromCart()
	{
		
		cartObject.RemoveProductFromCart();
		
	}
}
