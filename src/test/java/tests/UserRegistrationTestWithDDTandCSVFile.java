package tests;

import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegsitrationPage;

public class UserRegistrationTestWithDDTandCSVFile extends TestBase {

	HomePage homeObject;
	UserRegsitrationPage registerObject;
	LoginPage loginObject;

	CSVReader reader;
	
	@Test(priority = 1)
	public void UserCanRegisterSuccessfully() throws CsvValidationException, IOException
	{
		//get path of CSV file
		String CSV_file = System.getProperty("user.dir")+"/src/test/java/data/UserData.csv";
		try{
			reader = new CSVReader(new FileReader(CSV_file));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] csvCell;
		//While loop will be executed till the last value in csv file
		while((csvCell = reader.readNext()) != null)
		{
			String firstname = csvCell[0];
			String lastname = csvCell[1];
			String email = csvCell[2];
			String password = csvCell[3];
		

			homeObject = new HomePage(driver);
			homeObject.openRegistrationPage();
			registerObject = new UserRegsitrationPage(driver);
			registerObject.UserRegistration(firstname, lastname, email, password);
			Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
			registerObject.userLogut();
			homeObject.openLoginPage();
			loginObject = new LoginPage(driver);
			loginObject.UserLogin(email,password);
			Assert.assertTrue(registerObject.logoutBtn.getText().contains("Log out"));
			registerObject.userLogut();
		}
	}
	
	private void While(boolean b) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'While'");
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
