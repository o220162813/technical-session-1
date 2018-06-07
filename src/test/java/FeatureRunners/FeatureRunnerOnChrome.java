package FeatureRunners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Created by Stephen C-F Lin on 2018/6/6.
 */
@CucumberOptions(
        features = {"src/test/resources/Features/"},
        glue = {"StepDefinitions/"},
        tags = {"@TestingOnChrome"},
        format = {"pretty","html:target/RawHtmlResult1","json:target/RawJsonResult/report1.json"}
)
public class FeatureRunnerOnChrome extends AbstractTestNGCucumberTests {
}
