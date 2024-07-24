package Squar.Framwork;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.tools.javac.code.Directive;

public class E2ETest {
	
	@Test
	public void endToEndTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wb= new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");

		//landing page
     	driver.findElement(By.xpath("//span[text()='My Account']")).click();
     	driver.findElement(By.xpath("//li//a[text()='Login']")).click();

     	
     	//Logging page
    	driver.findElement(By.id("input-email")).sendKeys("prasadkalmegh123@gmail.com");
	    driver.findElement(By.id("input-password")).sendKeys("Pr@s@d123");
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		
		//Home Page
		driver.findElement(By.xpath("//a[text()='Cameras']")).click();

		//Product Page
		List<WebElement> products = driver.findElements(By.cssSelector("div.product-grid"));
		
		for(WebElement product:products) {
			WebElement targetproduct = product.findElement(By.cssSelector("div h4"));
			String productName=targetproduct.getText();
			System.out.println(productName);
			if(productName.equalsIgnoreCase("Nikon D300")) {
				targetproduct.findElement(By.cssSelector("a")).click();
			}
			
			
		}
	
	    //Product Details Page
		
		String price = driver.findElement(By.xpath("//ul[@class='list-unstyled']//h2")).getText();
		System.out.println(price);
        
		Assert.assertEquals(price,"$98.00");
		
		driver.findElement(By.xpath("//input[@id='input-quantity']")).clear();
		driver.findElement(By.xpath("//input[@id='input-quantity']")).sendKeys("2");
		
		driver.findElement(By.id("button-cart")).click();
		
		driver.findElement(By.id("cart")).click();

		String totalPrice = driver.findElement(By.xpath("//strong[text()='Total']/../following-sibling::td")).getText();
		System.out.println(totalPrice);

    
		Assert.assertEquals(totalPrice, "$196.00");
		
		driver.findElement(By.xpath("//strong[text()='Checkout']")).click();
		
		
		//CheckOut Page
		driver.findElement(By.xpath("//div//a[text()='Checkout']")).click();
		driver.findElement(By.cssSelector("button.close")).click();
		
		String Succesmessage = driver.findElement(By.xpath("//a[text()='Nikon D300'][1]/../span")).getText();
		System.out.println(Succesmessage);
		
		boolean isSucces =Succesmessage.equalsIgnoreCase("***");
		Assert.assertTrue(isSucces);
		
	}

}
