package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegsitrationPage;

public class UserRegistrationTestWithDDTandDataProvider extends TestBase {

	HomePage homeObject;
	UserRegsitrationPage registerObject;
	LoginPage loginObject;

	@DataProvider(name="testdata")
	public static Object[][] userData()
	{
		return new Object[][] {
			{"Moataz", "Nabil", "testemail@gmail.com", "12345678"},
			{"Ahmed", "Ali", "testemail2@gmail.com", "12345678"},
			{"Mohamed", "Yasser", "testemail3@gmail.com", "12345678"},
		};
	}
	
	@Test(priority = 1, alwaysRun = true, dataProvider = "testdata")
	public void UserCanRegisterSuccessfully(String firstName, String lastName, String email, String password)
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegsitrationPage(driver);
		registerObject.UserRegistration(firstName, lastName, email, password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.userLogut();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, password);
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
		// loginObject.UserLogin("testemail@gmail.com","12345678");
		// Assert.assertTrue(registerObject.logoutBtn.getText().contains("Log out"));
		
		
	}
	
}
