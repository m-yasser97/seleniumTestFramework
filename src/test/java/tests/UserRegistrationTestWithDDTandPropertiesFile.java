package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegsitrationPage;

public class UserRegistrationTestWithDDTandPropertiesFile extends TestBase {

	HomePage homeObject;
	UserRegsitrationPage registerObject;
	LoginPage loginObject;
	String firstName = LoadProperties.userData.getProperty("firstname");
	String lastName = LoadProperties.userData.getProperty("lastname");
	String Email = LoadProperties.userData.getProperty("email");
	String Password = LoadProperties.userData.getProperty("password");
	
	@Test(priority = 1)
	public void UserCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegsitrationPage(driver);
		registerObject.UserRegistration(firstName,lastName,Email,Password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.userLogut();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(Email,Password);
		Assert.assertTrue(registerObject.logoutBtn.getText().contains("Log out"));
		registerObject.userLogut();
	}
	
	@Test(dependsOnMethods = {"UserCanRegisterSuccessfully"})
	public void UserCanLogout()
	{
		//registerObject.userLogut();
	}
	
	@Test(dependsOnMethods = {"UserCanLogout"})
	public void RegisteredUserCanLogin()
	{
		// homeObject.openLoginPage();
		// loginObject = new LoginPage(driver);
		// loginObject.UserLogin(Email,Password);
		// Assert.assertTrue(registerObject.logoutBtn.getText().contains("Log out"));
		
		
	}
	
}
