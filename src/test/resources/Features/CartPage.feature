Feature: Cart Page Feature

  Background: Item already added to cart
    Given shopping cart contains 1 item

  Scenario: Validate inactivation of + button after item quantity reach the limit
    Given user on Cart Page
    And item count should be 1
    When user clicks + button 9 times
    Then item count should be 10
    And + button should become inactive.
