package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegsitrationPage;

public class UserRegistrationTestWithDDTandExcelFile extends TestBase {

	HomePage homeObject;
	UserRegsitrationPage registerObject;
	LoginPage loginObject;

	@DataProvider
	public Object[][] userRegisterData()throws IOException
	{
		ExcelReader ER = new ExcelReader();
		return ER.getExcelData();
	}
	
	@Test(priority = 1,alwaysRun = true,dataProvider = "ExcelData")
	public void UserCanRegisterSuccessfully(String firstname,String lastname, String email,String password)
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegsitrationPage(driver);
		registerObject.UserRegistration(firstname,lastname,email,password);
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
	
}
