package Squar.Framwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	static WebDriver driver;
	//.findElement(By.xpath("//a[text()='Cameras']")).click();
	
	@FindBy(xpath="//a[text()='Cameras']")
	private WebElement Cameratab;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver,this);
	}
	
	public ProductPage Cameratab() {
		Cameratab.click();
    	ProductPage page = new ProductPage(driver);
    	return page;

	}

}
