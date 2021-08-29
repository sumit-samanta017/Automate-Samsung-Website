@Integration
Feature: Add to Cart feature

  Background: 
    Given user is already on compare page

  Scenario: Check user is able to go to cart
    Given user is on add to cart page
    And user clicks on continue button on the top right
    And user again clicks on another continue button on top right
    Then user is on cart page
