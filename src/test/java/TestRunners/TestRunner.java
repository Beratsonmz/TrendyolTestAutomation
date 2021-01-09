package TestRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features =  {"src/test/resources/Features/"},
        glue = {"StepDefinitions","AppHooks"},
        plugin = {"pretty"}
)

public class TestRunner {
}
