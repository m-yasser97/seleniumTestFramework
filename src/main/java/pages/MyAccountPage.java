package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {
	
	public MyAccountPage (WebDriver driver){
		super(driver);
	}
	
	@FindBy(linkText = "Change password")
	WebElement changePasswordLink;
	
	@FindBy(id="OldPassword")
	WebElement oldPasswordTxt;
	
	@FindBy(id="NewPassword")
	WebElement newPasswordTxt;
	
	@FindBy(id="ConfirmNewPassword")
	WebElement confirmPasswordtxt;
	
	@FindBy(css="button.button-1.change-password-button")
	WebElement changePasswordBtn;
	
	@FindBy(css="p.content")
	public WebElement passwordChangeResult;
	
	public void OpenChangePasswordPage()
	{
		clickButton(changePasswordLink);
	}
	
	public void ChangePassword(String oldPassword, String newPassword)
	{
		setTextElementText(oldPasswordTxt, oldPassword);
		setTextElementText(newPasswordTxt, newPassword);
		setTextElementText(confirmPasswordtxt, newPassword);
		clickButton(changePasswordBtn);
	}

}
