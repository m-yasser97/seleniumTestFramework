package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegsitrationPage;

public class UserRegistrationTest extends TestBase {

	HomePage homeObject;
	UserRegsitrationPage registerObject;
	LoginPage loginObject;
	
	@Test(priority = 1)
	public void UserCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegsitrationPage(driver);
		registerObject.UserRegistration("Moataz", "Nabil", "testemail@gmail.com", "12345678");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin("testemail@gmail.com","12345678");
		Assert.assertTrue(registerObject.logoutBtn.getText().contains("Log out"));
	}
	
	@Test(dependsOnMethods = {"UserCanRegisterSuccessfully"})
	public void UserCanLogout()
	{
		registerObject.userLogut();
	}
	
	@Test(dependsOnMethods = {"UserCanLogout"})
	public void RegisteredUserCanLogin()
	{
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin("testemail@gmail.com","12345678");
		Assert.assertTrue(registerObject.logoutBtn.getText().contains("Log out"));
		
		
	}
	
}
