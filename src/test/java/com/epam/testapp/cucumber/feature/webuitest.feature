@webuitest

Feature: Open main page, go to link "News List" in order to redirect on login's form, after log in go to page with
  news list, go to news form and add new news.

  Scenario: Without authentication open main page and press link "news-list"

    #actions on first page
    Given open localhost
    And link to logout "logout" should't be visible
    And link to login "login.html" should be visible
    When press link "news-list"
    Then verify that page with url "/login.html" is opened

  Scenario: Login with admin credentials

    #actions on login page
    Given type to input with name "username" text: "admin"
    And type to input with name "password" text: "admin"
    And select "rememberme" checkbox
    When message "error_login" not visible
    And press "submit" button
    Then verify that page with url "/News.do?method=list" is opened
    And link to logout "login.html" should't be visible
    And link to login "logout" should be visible

  Scenario: Go to news form, add new news, and check that new was added

    #actions on news form
    Given verify that text with value "admin" exist
    And press link "news-form"
    Then verify that page with url "/News.do?method=showNewsForm" is opened
    And type to input with name "news.title" text: "newsTitle"
    And type to input with name "news.brief" text: "newsBrief"
    And type to input with name "news.content" text: "newsContent"
    And press "submit" button
    Then verify that page with url "/AddNews.do" is opened
    And verify that text with value "newsTitle" exist
    And verify that text with value "newsBrief" exist
    And verify that text with value "newsContent" exist
    And press link "news-list"
    And verify that page with url "/News.do?method=list" is opened
    And verify that text with value "newsTitle" exist
    And verify that text with value "newsBrief" exist