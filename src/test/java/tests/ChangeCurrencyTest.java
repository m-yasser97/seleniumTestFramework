package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase{
	
	HomePage homeObject;
	ProductDetailsPage detailsObject;
	SearchPage searchObject;
	String productName = "Apple MacBook Pro";
	
	@Test(priority=1)
	public void UserCanChangeCurrency()
	{
		homeObject = new HomePage(driver);
		homeObject.ChangeCurrency();
	}
	
	
	@Test(priority=2)
	public void UserCanSearchWithAutoSuggest()
	{
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("MacB");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.productPricelbl.getText().contains("€"));
		Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
	}
	

}
