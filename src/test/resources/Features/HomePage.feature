Feature: Home Page Feature

  @LoginRequired
  Scenario: Home Page Title
    Given User has already logged in
      | email                    | password       |
      | b.c.h.o.a_78@hotmail.com | reTckJP7L5iKU9 |
    When User gets the title of the page
    Then Page title should be "En Trend Ürünler Türkiye'nin Online Alışveriş Sitesi Trendyol'da"

  @LoginRequired
  Scenario: Account Dropdown Count
    Given User has already logged in
      | email                    | password       |
      | b.c.h.o.a_78@hotmail.com | reTckJP7L5iKU9 |
    When User moves cursor to the My Account button
    Then My account dropdown should be visible
      | Siparişlerim         |
      | Değerlendirmelerim   |
      | Trendyol Cüzdanım    |
      | İndirim Kuponlarım   |
      | Kullanıcı Bilgilerim |
      | Trendyol Asistan     |
      | Yardım               |
      | Çıkış Yap            |
    And My account dropdown should contain 8 different links

  @Guest
  Scenario: Home Page Gender Pop Up
    Given User is on Home Page
    When Gender popup appears
    Then Both gender buttons should be visible
    And  Close button should be visible

  @Guest
  Scenario: Close Home Page Gender Pop Up
    Given User is on Home Page
    When Gender popup appears
    And User clicks on close button
    Then Gender pop up should be disappear

  @Guest
  Scenario: Select Gender on Home Page Gender Pop Up
    Given User is on Home Page
    When Gender popup appears
    And User clicks on kadın button
    Then User should be navigated to the Kadın Page
    And Page title should be "Kadın, Moda, Giyim, Stil, Giyim Markaları | Trendyol"

  @Guest
  Scenario: Add Random Product to the Cart
    Given User is on Home Page
    When Gender popup appears
    And User clicks on close button
    And user randomly clicks one of the boutique link
    And user randomly clicks one of the search category link from slider
    And user selects random item from results
    And user add that item to the cart
    Then user displays cart
    And item count should be 1

