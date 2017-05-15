package com.epam.testapp.cucumber.step;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.impl.Html;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertTrue;

public class StepDefs {

    @Given("^open localhost$")
    public void openLocalhost() throws Throwable {

        baseUrl = "http://localhost:8081";
        open("/");

    }

    @And("^link to logout \"([^\"]*)\" should't be visible$")
    public void linkToLogoutShouldTBeVisible(String arg0) throws Throwable {

        $(By.linkText(arg0)).shouldNotBe(Condition.visible);
    }

    @And("^link to login \"([^\"]*)\" should be visible$")
    public void linkToLoginShouldBeVisible(String arg0) throws Throwable {

        $(By.linkText(arg0)).shouldBe(Condition.visible);
    }

    @When("^press link \"([^\"]*)\"$")
    public void press_link(String linkText) throws Throwable {

        $(By.linkText(linkText)).click();
    }

    @Then("^verify that page with url \"([^\"]*)\" is opened$")
    public void verify_that_page_with_url_is_opened(String url) throws Throwable {

        assertTrue(Html.text.contains(url(), url));

    }


}
