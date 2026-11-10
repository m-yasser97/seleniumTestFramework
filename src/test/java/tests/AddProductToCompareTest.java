package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ComparePage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToCompareTest extends TestBase {
	
	String firstProductName = "MacB";
	String secondProductName = "Azure";
	
	//1-Search for Product no.1
	//2-Search for Product no.2
	//3-Add to compare list
	//4-clear list
	
	ProductDetailsPage detailsObj;
	HomePage homeObj;
	ComparePage compareObj;
	SearchPage searchObj;
	
	@Test(priority=1)
	public void UserCanCompareProducts()
	{
		searchObj = new SearchPage(driver);
		detailsObj = new ProductDetailsPage(driver);
		compareObj = new ComparePage(driver);
		
		searchObj.ProductSearchUsingAutoSuggest(firstProductName);
		Assert.assertTrue(detailsObj.productNamebreadCrumb.getText().contains(firstProductName));
		detailsObj.AddProductToCompare();
		
		searchObj.ProductSearchUsingAutoSuggest(secondProductName);
		Assert.assertTrue(detailsObj.productNamebreadCrumb.getText().contains(secondProductName));
		detailsObj.AddProductToCompare();
		
		detailsObj.GoToComparePage();
		compareObj.CompareProducts();			
	}
	
	@Test(priority=2)
	public void UserCanClearCompareList()
	{
		compareObj.clearCompareList();
	}
	

}
