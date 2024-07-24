package TestComponants;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class BaseTest {
	
    public static  WebDriver driver;
	public WebDriver initBrowser() throws IOException {
		
		FileInputStream inputStream = new FileInputStream("C:\\Users\\prasa\\OneDrive\\Desktop\\Automaton\\Framwork\\src\\main\\java\\resources\\property");
		Properties properties = new Properties();
		properties.load(inputStream);
		
		String browserName= System.getProperty("browser")!= null ? System.getProperty("browser"): properties.getProperty("browser");
		if(browserName.equals("chrome")) {
		    driver = new ChromeDriver();

		}else if(browserName.equals("Firefox")) {
			driver = new FirefoxDriver();
		}else if(browserName.equals("edge")) {
			driver = new EdgeDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String baseUrl= properties.getProperty("baseUrl");
		driver.get(baseUrl);
        return driver;
	}
	
	public void tearDown() {
		
		driver.close();

	}

	public static String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
	 	String path = System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	    File source =	screenshot.getScreenshotAs(OutputType.FILE);
	    File destination = new File(path);
	    FileHandler.copy(source,destination);
	    return path;
	}
}
