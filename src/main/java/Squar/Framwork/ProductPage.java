package Squar.Framwork;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BasePageClass;

public class ProductPage extends BasePageClass {

	static WebDriver driver;
//	List<WebElement> products = driver.findElements(By.cssSelector("div.product-grid"));

	@FindBy(css = "div.product-grid")
	private List<WebElement> products;

	By productlocation = By.cssSelector("div h4");
	
	By CartProduct = By.cssSelector("a");

	public ProductPage(WebDriver driver) {
		super(driver);		
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getProduct() {
	    visibilityofElementLocated(productlocation);
		return products;

	}

	public WebElement getProductByName(String prodName) {
		WebElement prodCamera= null;

		for (WebElement product : products) {
			WebElement targetproduct = product.findElement(productlocation);
			String productName = targetproduct.getText();
			System.out.println(productName);
			if (productName.equalsIgnoreCase(prodName)) {
				prodCamera = targetproduct.findElement(CartProduct);
				return prodCamera;
			}

		}
		return prodCamera;
	}
	
	public ProductDetails addProductToCart(String prodName ) {
		WebElement prod = getProductByName(prodName);
		prod.click();
		ProductDetails details = new ProductDetails(driver);
        return details;
		
	}
	

}
