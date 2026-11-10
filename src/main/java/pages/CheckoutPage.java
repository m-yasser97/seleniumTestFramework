package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="BillingNewAddress_FirstName")
	WebElement fnTxt;
	
	@FindBy(id="BillingNewAddress_LastName")
	WebElement lnTxt;
	
	@FindBy(id="BillingNewAddress_Email")
	WebElement emailTxt;
	
	@FindBy(id="BillingNewAddress_CountryId")
	WebElement countryList;
	
	@FindBy(id="BillingNewAddress_StateProvinceId")
	WebElement stateList;
	
	@FindBy(id="BillingNewAddress_City")
	WebElement cityTxt;
	
	@FindBy(id="BillingNewAddress_Address1")
	WebElement address1Txt;
	
	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement postalCodeTxt;
	
	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement phoneTxt;
	
	@FindBy(css="button.button-1.new-address-next-step-button")
	WebElement continueBtn;
	
	//Shipping
	
	
	@FindBy(css="button.button-1.shipping-method-next-step-button")
	WebElement shippingContinueBtn;
	
	//Payment
	
	@FindBy(css="button.button-1.payment-method-next-step-button")
	WebElement paymentBtn;
	
	//Information
	
	@FindBy(css="button.button-1.payment-info-next-step-button")
	WebElement infoContinueBtn;
	
	//Confirmation
	
	@FindBy(linkText="Apple MacBook Pro")
	public WebElement productNameTxt;
	
	@FindBy(css="button.button-1.confirm-order-next-step-button")
	WebElement confirmBtn;
	
	@FindBy(css="h1")
	public WebElement thankyouLbl;
	
	@FindBy(css="div.section.order-completed")
	WebElement successMessageTxt;
	
	@FindBy(linkText="Click here for order details.")
	WebElement orderDetailsLink;
	
	public void RegisteredUserCheckoutProduct(String countryName, String address, String state
			,String city, String postalCode, String phone)
	{
		select = new Select(countryList);
		select.selectByVisibleText(countryName);
		select = new Select(stateList);
		select.selectByVisibleText(state);
		setTextElementText(address1Txt, address);
		setTextElementText(cityTxt, city);
		setTextElementText(postalCodeTxt, postalCode);
		setTextElementText(phoneTxt, phone);
		clickButton(continueBtn);
		clickButton(shippingContinueBtn);
		clickButton(paymentBtn);
		clickButton(infoContinueBtn);
	}
	
	public void confirmOrder()
	{
		clickButton(confirmBtn);
	}
	
	public void printOrder()
	{
		
	}
	
}
