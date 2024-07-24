package stepDefination;

import java.io.IOException;

import org.testng.asserts.SoftAssert;

import TestComponants.BaseTest;
import io.cucumber.java.en.Then;

public class InavalidStep extends BaseTest{

	
	 @Then("verify the url of current page")
	 public void verify_the_url_of_current_page() throws IOException {
		 
            SoftAssert assert1 = new SoftAssert();
			String actual = driver.getCurrentUrl();
			String expected =  "https://tutorialsninja.com/demo/index.php?route=account/account";
			assert1.assertEquals(actual, expected);
			tearDown();
			assert1.assertAll();

			
	 }
}
