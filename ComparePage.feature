@Smoke
Feature: Compare feature

  Background: 
    Given user is already on Home page


  Scenario: Check user is able to compare the selected items from the dropdown
    Given user is on compare page
    When user selects particular mobiles from the available particular dropdowns
    And user clicks on view more option
    Then user should be able to see the whole comparision list
    And user clicks on buy now option
    Then user is on add to cart page
