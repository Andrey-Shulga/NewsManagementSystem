package com.epam.testapp.cucumber;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-report", "json:target/cucumber-report/cucumber.json",
                "junit:target/cucumber-report/cucumber.xml"},
        features = "src/test/java/com/epam/testapp/cucumber/feature",
        glue = "com/epam/testapp/cucumber/step",
        tags = "@webuitest")
public class WebUiTest {

    @BeforeClass
    static public void setupTimeout() {
        //Configuration.timeout = 10000;
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        Configuration.browser = "chrome";
    }
}
