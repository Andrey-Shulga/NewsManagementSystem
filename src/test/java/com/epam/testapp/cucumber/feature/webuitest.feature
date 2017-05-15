@webuitest

Feature: Open main page and go to link "News List" in order to redirect on login's form and after log in to page with
  news list

  Scenario: Without authentication open main page and press link "news-list"

    #actions on first page
    Given open localhost
    When press link "News list"
    Then verify that page with url "http://localhost:8081/login.html" is opened