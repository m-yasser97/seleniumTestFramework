package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegsitrationPage extends PageBase {

	public UserRegsitrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(id="gender-male")
	WebElement genderRadioBtn;
	
	@FindBy(id="FirstName")
	WebElement firstNameTxtbox;
	
	@FindBy(id="LastName")
	WebElement lastNameTxtbox;
	
	@FindBy(id="Email")
	WebElement emailTxtbox;
	
	@FindBy(id="Password")
	WebElement passwordTxtbox;
	
	@FindBy(id="ConfirmPassword")
	WebElement cnfrmPasswordTxtbox;
	
	@FindBy(id="register-button")
	WebElement registerBtn;
	
	@FindBy(css="div.result")
	public WebElement successMessage;
	
	@FindBy(linkText = "Log out")
	public WebElement logoutBtn;
	
	@FindBy(linkText = "My account")
	WebElement myaccountBtn;
	
	public void UserRegistration(String firstname, String lastname, String email, String password)
	{//no hardcoded data inside, to be put when doing the test cases
		clickButton(genderRadioBtn);
		setTextElementText(firstNameTxtbox, firstname);
		setTextElementText(lastNameTxtbox, lastname);
		setTextElementText(emailTxtbox, email);
		setTextElementText(passwordTxtbox, password);
		setTextElementText(cnfrmPasswordTxtbox, password);
		clickButton(registerBtn);
	}
	
	public void userLogut()
	{
		clickButton(logoutBtn);
	}
	
	public void OpenmyAccountPage()
	{
		clickButton(myaccountBtn);
	}
}
