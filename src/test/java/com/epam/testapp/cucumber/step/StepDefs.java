package com.epam.testapp.cucumber.step;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.codeborne.selenide.Selenide.open;

public class StepDefs {

    @Given("^open localhost$")
    public void openLocalhost() throws Throwable {

        open("http://localhost:8081");
    }

    @When("^press link \"([^\"]*)\"$")
    public void press_link(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^verify that page with url \"([^\"]*)\" is opened$")
    public void verify_that_page_with_url_is_opened(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
