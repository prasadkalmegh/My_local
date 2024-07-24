package Squar.Framwork;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
//	driver.findElement(By.xpath("//div//a[text()='Checkout']")).click();
//	driver.findElement(By.cssSelector("button.close")).click();
//	String Succesmessage = driver.findElement(By.xpath("//a[text()='Nikon D300'][1]/../span")).getText();

	@FindBy(xpath = "//div//a[text()='Checkout']")
	private WebElement checkout;
	
	@FindBy(css = "button.close")
	private WebElement errorMessage;
	
	@FindBy(xpath = "//a[text()='Nikon D300'][1]/../span")
	private WebElement succesMessage;
	
	public CheckoutPage(WebDriver driver) {
		
	  PageFactory.initElements(driver,this);
	}
	
	public void clickOnToCheckout() {
		checkout.click();
	}
	
	public void closeErrorPopup() {
		
	errorMessage.click();
	}
	
	public String getsuccesMessage() {
		
	String SuccesmessageText =	succesMessage.getText();
	return SuccesmessageText;
	
	}

}
