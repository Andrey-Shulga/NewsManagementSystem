@webuitest

Feature: Open main page and go to link "News List" in order to redirect on login's form and after log in to page with
  news list

  Scenario: Without authentication open main page and press link "news-list"

    #actions on first page
    Given open localhost
    And link to logout "Logout" should't be visible
    And link to login "Login" should be visible
    When press link "News List"
    Then verify that page with url "/login.html" is opened

  Scenario: Login with admin credentials

    #actions on login page
