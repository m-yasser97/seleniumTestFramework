package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="strong.current-item")
	public WebElement productNamebreadCrumb;
	
	@FindBy(css="button.button-2.email-a-friend-button")
	WebElement emailtoFriendBtn;
	
	@FindBy(css="span.price-value-4")
	public WebElement productPricelbl;
	
	@FindBy(linkText="Add your review")
	WebElement addYourReviewLink;
	
	@FindBy(id="add-to-wishlist-button-4")
	WebElement addToWishlistBtn;
	
	@FindBy(linkText="wishlist")
	WebElement wishListLink;
	
	@FindBy(css="button.button-2.add-to-compare-list-button")
	WebElement addToCompareListBtn;
	
	@FindBy(linkText="product comparison")
	WebElement addToCompareListLink;
	
	@FindBy(id="add-to-cart-button-4")
	WebElement addToCartBtn;
	
	@FindBy(linkText="shopping cart")
	WebElement shoppingCartLink;
	
	
	public void GoToEmailtoFriendPage()
	{
		clickButton(emailtoFriendBtn);
	}
	
	public void GotoAddReviewPage()
	{
		clickButton(addYourReviewLink);
	}
	
	public void AddProductToWishlist()
	{
		clickButton(addToWishlistBtn);
	}
	
	public void GoToProductWishList()
	{
		clickButton(wishListLink);
	}
	
	public void AddProductToCompare()
	{
		clickButton(addToCompareListBtn);
	}
	
	public void GoToComparePage()
	{
		clickButton(addToCompareListLink);
	}
	
	public void addToCart()
	{
		clickButton(addToCartBtn);
	}
	
	public void GoToShoppingCart()
	{
		clickButton(shoppingCartLink);
	}
	
}
