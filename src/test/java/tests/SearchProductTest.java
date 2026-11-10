package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase {
	
	String productName = "Apple MacBook Pro";
	SearchPage searchObject;
	ProductDetailsPage pdpObject;
	
	@Test
	public void UserCanSearchForProducts()
	{
		searchObject = new SearchPage(driver);
		pdpObject = new ProductDetailsPage(driver);
		searchObject.ProductSearch(productName);
		searchObject.OpenProductDetailsPage();
		Assert.assertTrue(pdpObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
		//OR Assert.assertEquals(pdpObject.productNamebreadCrumb.getText(),productName);

	}
}
