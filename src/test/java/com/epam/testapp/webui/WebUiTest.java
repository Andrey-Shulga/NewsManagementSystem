package com.epam.testapp.webui;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report/smoketest", "json:target/cucumber.json"},
        features = "src/test/java/com/epam/testapp/cucumber/features",
        glue = "com/epam/testapp/cucumber/steps",
        tags = "@webuitest")
public class WebUiTest {

}
