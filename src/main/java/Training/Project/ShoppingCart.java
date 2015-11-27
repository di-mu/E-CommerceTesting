package Training.Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ShoppingCart {
	public WebDriver driver = Configuration.browser();
	
	@FindBy(xpath = Elements.ItemDescription)
	private WebElement itemDescription;
	
	@FindBy(xpath = Elements.NextButton)
	private WebElement nextButton;
	
	@FindBy(id = Elements.CartTitle)
	private WebElement cartTitle;
	
	@FindBy(xpath = Elements.Delete)
	private WebElement delete;
	
	@FindBy(xpath = Elements.CheckBox)
	private WebElement checkBox;

	@FindBy(xpath = Elements.Next2)
	private WebElement nextBtn2;
	
	@FindBy(id = Elements.TermsAndConditionsChkBox)
	private WebElement agreeCheck;
	
	@FindBy(xpath = Elements.Next3)
	private WebElement NextBtn3;
	
	@FindBy(xpath = Elements.PayByCheck)
	private WebElement paybycheck;

	@FindBy(xpath = Elements.Submit)
	private WebElement submit;
	
	public ShoppingCart(){
		PageFactory.initElements(driver, this);
	}
	
	public void validateItemDescription(){
		//System.out.println(itemDescription.getText());
		Assert.assertEquals(itemDescription.getText(), "iPod shuffle");
	}
	
	public void clickNextButton(){
		Assert.assertTrue(nextButton.isDisplayed());
		nextButton.click();
	}
	
	public void validateCartTitle(){
		Assert.assertEquals(cartTitle.getText(), "Shopping cart summary");
	}
	
	public void delteItem(){
		delete.click();
	}
	
	public void uncheckAddress(){
		checkBox.click();
		//Assert.assertEquals(checkBox.getAttribute(arg0), expected);
	}
	
	public void nextAddress(){
		nextBtn2.click();
	}
	
	public void checkAgree(){
		agreeCheck.click();
	}
	
	public void nextCarrier(){
		NextBtn3.click();
	}
	
	public void clickPaybycheck(){
		paybycheck.click();
	}
	
	public void clickSubmit(){
		submit.click();
	}
}
