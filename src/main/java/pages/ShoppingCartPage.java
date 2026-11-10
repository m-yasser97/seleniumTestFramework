package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="removefromcart32")
	WebElement removeFromCartBtn;
	
	@FindBy(id="itemquantity32")
	WebElement quantityTxt;
	
	@FindBy(css="span.product-subtotal")
	public WebElement totalLbl;
	
	@FindBy(css="div.no-data")
	WebElement cartIsEmpty;
	
	@FindBy(linkText="Apple MacBook Pro")
	public WebElement productNameTxt;
	
	@FindBy(id="checkout")
	WebElement checkoutBtn;
	
	@FindBy(id="termsofservice")
	WebElement agreeCheckbox;
	
	public void RemoveProductFromCart()
	{
		clickButton(removeFromCartBtn);
	}
	
	public void UpdateProductQuantityInCart(String quantity)
	{
		clearText(quantityTxt);
		setTextElementText(quantityTxt, quantity);
	}
	
	public void OpenCheckoutPage()
	{
		clickButton(agreeCheckbox);
		clickButton(checkoutBtn);
	}
}
