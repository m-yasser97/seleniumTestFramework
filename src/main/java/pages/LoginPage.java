package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(id="Email")
	WebElement emailtxtbox;
	
	@FindBy(id="Password")
	WebElement passwordtxtbox;
	
	@FindBy(css="button.button-1.login-button")
	WebElement loginBtn;
	
	public void UserLogin(String email, String password)
	{
		setTextElementText(emailtxtbox,email);
		setTextElementText(passwordtxtbox,password);
		clickButton(loginBtn);
	}
}
