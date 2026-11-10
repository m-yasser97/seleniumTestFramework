package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWishlistTest extends TestBase{
	
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	WishListPage wishlistObject;
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
	public void UserCanAddProductToWishList()
	{
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.AddProductToWishlist();
		detailsObject.GoToProductWishList();
		Assert.assertTrue(wishlistObject.wishlistHeader.getText().contains("wishlist"));
		Assert.assertTrue(wishlistObject.productCell.getText().contains("productName"));

	}
	
	@Test(priority=3)
	public void UserCanremoveProductFromWishList()
	{
		wishlistObject = new WishListPage(driver);
		wishlistObject.RemoveProductFromCart();
		Assert.assertTrue(wishlistObject.emptyCartlbl.getText().contains("The wishlist is empty!"));
	}
}
