package Squar.Framwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

//	driver.findElement(By.id("input-email")).sendKeys("prasadkalmegh123@gmail.com");
//    driver.findElement(By.id("input-password")).sendKeys("Pr@s@d123");
//	driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
//	
	static WebDriver driver;

	@FindBy(id = "input-email")
	private WebElement userName;

	@FindBy(id = "input-password")
	private WebElement password;

	@FindBy(xpath = "//input[@class='btn btn-primary']")
	private WebElement submitButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public HomePage loginAction(String userEmail,String userPassword) {
		userName.sendKeys(userEmail);
		password.sendKeys(userPassword);
		submitButton.click();
    	HomePage hp =new HomePage(driver);
    	return hp;

	}

}
