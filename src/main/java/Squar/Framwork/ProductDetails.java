package Squar.Framwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BasePageClass;
import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class ProductDetails extends BasePageClass {
	
//	String price = driver.findElement(By.xpath("//ul[@class='list-unstyled']//h2")).getText();
	//driver.findElement(By.xpath("//input[@id='input-quantity']")).clear();
//	driver.findElement(By.id("button-cart")).click();

	static WebDriver driver;

	@FindBy(xpath= "//ul[@class='list-unstyled']//h2")
	private WebElement price;
	
	@FindBy(xpath 	= "//input[@id='input-quantity']")
	private WebElement qty;
	

	@FindBy(id = "button-cart")
	private WebElement setQuantityButton;
	
	
    public ProductDetails(WebDriver driver) {
    	super(driver);
		this.driver = driver;

    	PageFactory.initElements(driver,this);
	}
    
    public String getPrice() {
    	
    	String prodPrice = price.getText();
    	return prodPrice;
    	
    	}
    
    public CartPage setQantity(String Quantity) {
    	qty.clear();
    	qty.sendKeys(Quantity);
    	setQuantityButton.click();
    	ClickOnCart();
		CartPage cartPage = new CartPage(driver);

		return cartPage;
    }

}
