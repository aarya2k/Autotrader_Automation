package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features"
        ,glue= {"src/test/java/steps/SearchSteps.java"}
)

public class CucumberITRunner {

}