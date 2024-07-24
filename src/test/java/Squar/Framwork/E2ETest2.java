package Squar.Framwork;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import javax.swing.text.ChangedCharSetException;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.tools.javac.code.Directive;

import TestComponants.BaseTest;
import sun.security.x509.CertificateX509Key;

public class E2ETest2 extends BaseTest {
	
	@Test(dataProvider="getData")
	public void endToEndTest(String Uesrname,String Password) throws IOException {
	
		WebDriver driver = initBrowser();
     	LandingPage lp = new LandingPage(driver);
     	LoginPage login = lp.navigateTologinPage();
     	HomePage hp = login.loginAction(Uesrname, Password);
     	ProductPage page=hp.Cameratab();
    	ProductDetails details = page.addProductToCart("Nikon D300");
        Assert.assertEquals(details.getPrice(),"$98.00");
        CartPage cartPage = details.setQantity("2");
     	//Assert.assertEquals(cartPage.getPrice(), "$196.00");
     	CheckoutPage checkoutPage 	= cartPage.gotoCheckoutPage();
		checkoutPage.clickOnToCheckout();
		checkoutPage.closeErrorPopup();		
	    boolean isSucces =checkoutPage.getsuccesMessage().equalsIgnoreCase("***");
		Assert.assertTrue(isSucces);
		
		tearDown();
	}
	
	@DataProvider(name="getData")
	public Object[][] getData() {
		return new Object[][]{
				{"prasadkalmegh123@gmail.com", "Pr@s@d123"},
		        {"prasadkalmegh19@gmail.com", "Pr@s@d123"}};
	}
	
	}
