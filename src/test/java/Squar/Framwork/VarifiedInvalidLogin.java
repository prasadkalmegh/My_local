package Squar.Framwork;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import TestComponants.BaseTest;

public class VarifiedInvalidLogin extends BaseTest {
	@Test
	public void verifiedloginwithInvalidCredits() throws IOException {
		WebDriver driver = initBrowser();
	 	LandingPage lp = new LandingPage(driver);
	 	LoginPage login = lp.navigateTologinPage();
	 	HomePage hp = login.loginAction("prasadkalmegh@gmail.com", "Pr@s@d");
		SoftAssert assert1 = new SoftAssert();
		String actual = driver.getCurrentUrl();
		String expected =  "https://tutorialsninja.com/demo/index.php?route=account/account";
		assert1.assertEquals(actual, expected);
		tearDown();
		assert1.assertAll();
		
	 	
	}
	
 	

}
