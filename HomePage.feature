@OneTime
Feature: Home feature

  Scenario: Check user is navigated to Compare page from Home page
    Given when user is on home page
    When user moves to mobile option
    And user moves to smartphone option and click on compare
    Then user is on compare page
