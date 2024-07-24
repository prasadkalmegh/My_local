package Squar.Framwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.This;

public class LandingPage {
	
	
//	private WebElement MyAccount;
//	private WebElement Login;	
//	
//	public LandingPage(WebDriver driver) {
//		
//		MyAccount =	driver.findElement(By.xpath("//span[text()='My Account']"));
//     	Login=driver.findElement(By.xpath("//li//a[text()='Login']"));
//
//	}
	
	static WebDriver driver;
	
	@FindBy(xpath ="//span[text()='My Account']")
	private WebElement myAccount;
	
	@FindBy(xpath="//li//a[text()='Login']")
	private WebElement loginButton;
	
	public LandingPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public LoginPage navigateTologinPage() {
		
		myAccount.click();
		loginButton	.click();
    	LoginPage login = new LoginPage(driver);
         return login;
	}

}
