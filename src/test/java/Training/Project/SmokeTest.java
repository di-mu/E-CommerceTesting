package Training.Project;

import org.testng.annotations.Test;

import Training.Project.Configuration;

public class SmokeTest extends TestNGAnnotationsTest {
	
	ShoppingCart shoppingCart = new ShoppingCart();
	
	@Test(testName = "login_Positive", description = "login_Positive", timeOut = 190000, enabled = true, groups = {
			 "1", "sanity" }, priority=1)
	public void validCredentials(){
		home.loginLink();
		login.loginToApp(Configuration.LoginUserNmae(), Configuration.LoginPassword());
	}
	
	@Test(testName = "login_Negative", description = "login_Negative", timeOut = 190000, enabled = false, groups = {
			 "2", "sanity"}, priority=2)
	public void login_Negative(){
		
		home.logout();
		login.loginToApp("aaa", "aaa");
		login.invalidErrorMessage();
		login.loginToApp(Configuration.LoginUserNmae(), Configuration.LoginPassword());
	}

	
	@Test(testName = "search Product", description = "search Product", timeOut = 190000, enabled = true, groups = {
			"3", "sanity"}, priority=3)
	public void search_Product(){
		
		home.searchProduct(read.readData("Product_ipod"));
		home.validateResults();
		home.clickAddToCart();
		wait3sec();
	}
	
	@Test(testName = "Shopping Cart - Summary", description = "Shopping Cart - Summary", timeOut = 190000, enabled = true, groups = {
			"4", "sanity"}, priority=4)
	public void ShoppingCart_Summary(){
		home.shoppingCart();
		shoppingCart.validateItemDescription();
		shoppingCart.validateCartTitle();
	}

	@Test(testName = "Delete Item", description = "Delete Item", timeOut = 190000, enabled = true, groups = {
			"5", "sanity"}, priority=5)
	public void DeleteItem(){
		shoppingCart.delteItem();
		wait3sec();
	}
	
	@Test(testName = "Shopping Cart - Address", description = "Shopping Cart - Address", timeOut = 190000, enabled = true, groups = {
			"6", "sanity"}, priority=6)
	public void ShoppingCart_Address(){
		search_Product();
		ShoppingCart_Summary();
		shoppingCart.clickNextButton();
		wait3sec();
		shoppingCart.nextAddress();
		wait3sec();
	}
	
	@Test(testName = "Shopping Cart - Carrier", description = "Shopping Cart - Carrier", timeOut = 190000, enabled = true, groups = {
			"7", "sanity"}, priority=7)
	public void ShoppingCart_Carrier(){
		shoppingCart.checkAgree();
		shoppingCart.nextCarrier();
	}
	
	@Test(testName = "Shopping Cart - Carrier", description = "Shopping Cart - Carrier", timeOut = 190000, enabled = true, groups = {
			"8", "sanity"}, priority=8)
	public void ShoppingCart_Payment(){
		shoppingCart.clickPaybycheck();
		wait3sec();
		shoppingCart.clickSubmit();
		wait3sec();
		home.logout();
	}
	
	public void wait3sec(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
