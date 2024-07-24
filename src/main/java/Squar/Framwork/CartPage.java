package Squar.Framwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	//		String totalPrice = driver.findElement(By.xpath("//strong[text()='Total']/../following-sibling::td")).getText();
//	driver.findElement(By.xpath("//strong[text()='Checkout']")).click();


	static WebDriver driver;
	
	@FindBy(xpath= "//strong[text()='Total']/../following-sibling::td")
	private WebElement totalPrice;
	
	
	@FindBy(xpath= "//strong[text()='Checkout']")
	private WebElement checkOutButton;
	
    public CartPage(WebDriver driver) {
		this.driver = driver;

    	PageFactory.initElements(driver,this);
	}
  
    
    public String getPrice() {
    	String netdPrice = totalPrice.getText();
    	return netdPrice;
    }
    
    public CheckoutPage gotoCheckoutPage() {
    	checkOutButton.click();
		CheckoutPage checkoutPage = new CheckoutPage(driver);

		return checkoutPage;
    }
    

}
	

