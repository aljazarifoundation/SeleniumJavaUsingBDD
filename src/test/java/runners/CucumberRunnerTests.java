package runners;

import org.testng.annotations.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@Test
@CucumberOptions(tags = "",

        features = {"src/test/resources/features"},
        glue = {"definitions"},
        plugin = {"pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "html:target/cucumber/cucumber-html-report"
                    })

public class CucumberRunnerTests extends AbstractTestNGCucumberTests{

}
