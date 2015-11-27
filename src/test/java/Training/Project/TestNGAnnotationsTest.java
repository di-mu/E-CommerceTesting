package Training.Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Training.Project.Configuration;
import Training.Project.HomePage;
import Training.Project.LoginPage;
import Training.Project.ReadExcel;

public class TestNGAnnotationsTest {

	public WebDriver driver = Configuration.browser();
	public ReadExcel read;
	public HomePage home;
	public LoginPage login;

	public TestNGAnnotationsTest() {

		read = new ReadExcel();
		home = new HomePage();
		login = new LoginPage();
	}

	@BeforeSuite(alwaysRun = true)
	public void loginToApp() {

		driver.get(Configuration.LoginURL());
		driver.manage().window().maximize();
		
		//home.validateHomePage();

	}
	
	
	@AfterSuite(alwaysRun=true)
	public void closeBrowser(){
		//driver.quit();
	}
	
	@AfterMethod(alwaysRun=true)

	public void navigateToHome(){
		//home.navigateToHome();
	}
}
