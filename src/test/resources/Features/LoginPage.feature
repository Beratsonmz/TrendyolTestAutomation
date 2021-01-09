Feature: Login Page Feature

  @Login
  Scenario: Login Page Title
    Given User is on login page
    When User gets the title of the page
    Then Page title should be "En Trend Ürünler Türkiye'nin Online Alışveriş Sitesi Trendyol'da"

  @Login
  Scenario: Forget Password Link
    Given User is on login page
    Then Forgot password link should be displayed

  @Login
  Scenario: Login With Correct Credentials
    Given User is on login page
    When User enters email "b.c.h.o.a_78@hotmail.com"
    And User enters password "reTckJP7L5iKU9"
    And User clicks on login button
    And User sees the account container
    Then User moves cursor to the My Account button
    And My account dropdown should be displayed
