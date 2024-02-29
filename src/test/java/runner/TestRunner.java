package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "./features/Login.feature",
        glue ={"stepdefs"},
        dryRun = true,
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber-reports",
                "json:target/cucumber.json"})

public class TestRunner extends AbstractTestNGCucumberTests {

}

//mvn exec:java                                  \
//    -Dexec.classpathScope=test                 \
//    -Dexec.mainClass=io.cucumber.core.cli.Main \
//    -Dexec.args="./features/Login.feature --glue stepdefs "
