import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(
    features = "src/test/java/resources/features", // Path to ".feature" files
    glue = "stepDefinitions", // Package where we have the steps
    plugin = {"pretty", "html:target/cucumber-reports.html"}, // execution report generation
    monochrome = true, // cleaner console output
    tags = "@login-regression" 
)
public class TestRunner {
}