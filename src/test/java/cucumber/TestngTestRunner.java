package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = "src/test/java/cucumber",
		glue = "stepDefination",
		monochrome= true,
		plugin= {"html: target/cucumber.html"},
		dryRun= false
		
		)
public class TestngTestRunner extends AbstractTestNGCucumberTests {
	
	

}
