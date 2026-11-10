package tests;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.Helper;

import java.time.Duration;

public class TestBase {

public static WebDriver driver;

@BeforeSuite
@Parameters({"browser"})
public void startDriver(@Optional("EdgeDriver") String browserName)
{
	if(browserName.equalsIgnoreCase("EdgeDriver"))
	{
		driver = new EdgeDriver();
	} // do "else if" if there's more browsers
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
	driver.navigate().to("https://demo.nopcommerce.com/");
}



@AfterSuite
public void stopDriver()
{
	driver.quit();
}
	
	//Take screenshot when test case failed and add it in the Screenshots folder

@AfterMethod
public void screenshotOnFailure(ITestResult result)
{
	if(result.getStatus() == ITestResult.FAILURE)
	{
		System.out.println("Failed!");
		System.out.println("Taking Screenshot.....");
		Helper.captureScreenshot(driver, result.getName());
	}
}


}
