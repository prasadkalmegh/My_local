package Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageClass {
//	driver.findElement(By.id("cart")).click();

	
	static WebDriver driver;
	
	@FindBy(id= "cart")
	private WebElement cartButton;
	
	public BasePageClass(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	public static void visibilityofElementLocated (By findby) {
		WebDriverWait driverWait =new WebDriverWait(driver,Duration.ofSeconds(10));
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(findby));
		
		
	}
	
	public void ClickOnCart() {
		cartButton.click();
	}
}
