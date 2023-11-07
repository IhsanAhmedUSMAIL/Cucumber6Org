package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        //birden fazla tag/grup adı verilebilir
        tags = "@SmokeTest or @Regression", // and dersen sadece her iki etiketi olanı çalıştırır
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"}

)
public class _05_TestRunnerRegression  extends AbstractTestNGCucumberTests {
}
