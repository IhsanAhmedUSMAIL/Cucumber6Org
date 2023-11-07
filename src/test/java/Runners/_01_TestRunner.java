package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( // @CucumberOptions = xml gibi görev görüyor
        features = {"src/test/java/FeatureFiles/_01_Login.feature"}, // buraya features files ın path i verilecek.
        glue = {"StepDefinitions"} // Step definitions ın klasörü yazılıyor.

)
public class _01_TestRunner extends AbstractTestNGCucumberTests {


}
