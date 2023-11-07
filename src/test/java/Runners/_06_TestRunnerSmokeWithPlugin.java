package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        // aşağıdaki bütün testlerden @SmokeTest tag i olanları çalıştır
        tags = "@SmokeTest",
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        dryRun = true, // true olduğunda testleri çalıştırmaz sadece feature lara
                      // ait steplerin varlığını kontrol eder.
                      // false olduğunda ise testi çalıştırır
        plugin = {"html:target/site/cucumber-pretty.html"} // basit rapor, inetrnetten cucumber raport yazarsan da çıkar
)
public class _06_TestRunnerSmokeWithPlugin extends AbstractTestNGCucumberTests {
}
