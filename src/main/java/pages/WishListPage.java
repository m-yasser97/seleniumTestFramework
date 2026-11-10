package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class WishListPage extends PageBase {

	public WishListPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText="Apple MacBook Pro")
	public WebElement productCell;
	
	@FindBy(css="div.page-title")
	public WebElement wishlistHeader;
	
	@FindBy(id="updatecart")
	WebElement updateWishlistBtn;
	
	@FindBy(id="removefromcart7")
	WebElement removeFromCartBtn;
	
	@FindBy(css="div.no-data")
	public WebElement emptyCartlbl;
	
	public void RemoveProductFromCart()
	{
		clickButton(removeFromCartBtn);
	}
	
	
}
