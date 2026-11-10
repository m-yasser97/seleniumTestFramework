package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegsitrationPage;

public class MyAccountTest extends TestBase {
	
	HomePage homeObject;
	UserRegsitrationPage registerObject;
	MyAccountPage myaccountObject;
	LoginPage loginObject;
	String oldPassword = "1234567";
	String newPassword = "12345678";
	String firstName = "Moataz";
	String lastName = "Nabil";
	String email = "testemail@gmail.com";
	
	@Test(priority = 1)
	public void UserCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegsitrationPage(driver);
		registerObject.UserRegistration(firstName,lastName,email,oldPassword);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	
	@Test(priority = 2)
	public void RegisteredUserCanChangePassword()
	{
		myaccountObject = new MyAccountPage(driver);
		registerObject.OpenmyAccountPage();
		myaccountObject.OpenChangePasswordPage();
		myaccountObject.ChangePassword(oldPassword, newPassword);
		Assert.assertTrue(myaccountObject.passwordChangeResult.getText().contains("Password was changed"));
		
	}
	
	@Test(priority = 3)
	public void UserCanLogout()
	{
		registerObject.userLogut();
	}
	
	@Test(priority = 4)
	public void RegisteredUserCanLogin()
	{
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email,newPassword);
		Assert.assertTrue(registerObject.logoutBtn.getText().contains("Log out"));
		
		
	}

}
