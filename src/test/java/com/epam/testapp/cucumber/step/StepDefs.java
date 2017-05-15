package com.epam.testapp.cucumber.step;

import com.codeborne.selenide.impl.Html;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
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

        $(By.cssSelector("a[href*='" + arg0 + "'")).shouldNotBe(visible);
    }

    @And("^link to login \"([^\"]*)\" should be visible$")
    public void linkToLoginShouldBeVisible(String arg0) throws Throwable {

        $(By.cssSelector("a[href*='" + arg0 + "'")).shouldBe(visible);
    }

    @When("^press link \"([^\"]*)\"$")
    public void press_link(String linkText) throws Throwable {

        $(By.cssSelector("a[href*='" + linkText + "'")).click();
    }

    @Then("^verify that page with url \"([^\"]*)\" is opened$")
    public void verify_that_page_with_url_is_opened(String url) throws Throwable {

        assertTrue(Html.text.contains(url(), url));

    }


    @Given("^type to input with name \"([^\"]*)\" text: \"([^\"]*)\"$")
    public void typeToInputWithNameText(String fieldName, String value) throws Throwable {

        $(By.name(fieldName)).setValue(value);
    }

    @And("^select \"([^\"]*)\" checkbox$")
    public void selectCheckbox(String arg0) throws Throwable {

        $(By.id(arg0)).setSelected(true);
    }

    @When("^message \"([^\"]*)\" not visible$")
    public void messageNotVisible(String arg0) throws Throwable {

        $(By.className(arg0)).shouldNotBe(visible);
    }

    @And("^press \"([^\"]*)\" button$")
    public void pressButton(String arg0) throws Throwable {

        $(By.cssSelector("input[type=" + arg0 + "]")).click();
    }

    @Given("^verify that text with value \"([^\"]*)\" exist$")
    public void verifyThatTextWithValueExist(String arg0) throws Throwable {

        $(byText(arg0)).shouldBe(visible);
    }
}
