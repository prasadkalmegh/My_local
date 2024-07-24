package stepDefination;

import java.io.IOException;

import org.testng.Assert;

import Squar.Framwork.CartPage;
import Squar.Framwork.CheckoutPage;
import Squar.Framwork.HomePage;
import Squar.Framwork.LandingPage;
import Squar.Framwork.LoginPage;
import Squar.Framwork.ProductDetails;
import Squar.Framwork.ProductPage;
import TestComponants.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class E2EStep extends BaseTest {
	
	LoginPage login;
	HomePage hp;
	ProductPage page;
	CheckoutPage checkoutPage ;
	
	@Given("Navigate to baseUrl")
	public void Nevigate_to_baseUrl() throws IOException {
	    initBrowser();     	
		LandingPage lp = new LandingPage(driver);
        login = lp.navigateTologinPage();
	}
	
	@Given("^Login with username(.+) and password(.+)$")
	public void Login_with_username_and_password(String name, String password) {
		 hp = login.loginAction(name, password);
	}
	
	
	@When("^added product (.+) to the cart and checkout$")
	public void added_product_to_cart_and_checkout(String product) {
		page = hp.Cameratab();
    	ProductDetails details = page.addProductToCart(product);
        Assert.assertEquals(details.getPrice(),"$98.00");
        CartPage cartPage = details.setQantity("2");
        checkoutPage = cartPage.gotoCheckoutPage();
		checkoutPage.clickOnToCheckout();
		
		
	}
	
	@Then("verify the details{string}")
	public void verify_the_details(String string) {
		checkoutPage.closeErrorPopup();		
	    boolean isSucces = checkoutPage.getsuccesMessage().equalsIgnoreCase("***");
		Assert.assertTrue(isSucces);
		tearDown();	
		}
	
	
	

}
