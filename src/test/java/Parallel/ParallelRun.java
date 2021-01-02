package Parallel;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = {"src/test/resources/Features/Parallel"},
        glue = {"Parallel"},
        plugin = {"pretty"}
)

public class ParallelRun extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
