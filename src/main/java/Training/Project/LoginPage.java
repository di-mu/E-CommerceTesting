package Training.Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver = Configuration.browser();

	@FindBy(id = Elements.Email)
	private WebElement Email;

	@FindBy(id = Elements.Password)
	private WebElement Password1;

	@FindBy(id = Elements.Login_Btn)
	private WebElement Login_Btn;

	@FindBy(xpath = Elements.InvalidEmailAddress)
	private WebElement InvalidEmailAddress;

	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	public void loginToApp(String userNmae, String Password) {

		Email.clear();
		Email.sendKeys(userNmae);
		Password1.clear();
		Password1.sendKeys(Password);
		Login_Btn.click();
	}
	
	public void invalidErrorMessage(){
		
		InvalidEmailAddress.isDisplayed();
	}
	
	
}
