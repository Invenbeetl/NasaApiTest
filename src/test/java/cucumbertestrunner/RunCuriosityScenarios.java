package cucumbertestrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        tags = {"@Curiosity"},
        features = { "src/test/resources/features/" },
        glue = { "stepdefs" })
public class RunCuriosityScenarios {
}
