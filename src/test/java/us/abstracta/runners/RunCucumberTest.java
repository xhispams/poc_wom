package us.abstracta.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import us.abstracta.pages.*;
import us.abstracta.pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "us.abstracta.steps",
        plugin = {"pretty", "html:target/cucumber-reports.html"})

public class RunCucumberTest {
}