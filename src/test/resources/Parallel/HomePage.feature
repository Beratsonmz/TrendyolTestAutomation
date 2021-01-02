Feature: Home Page Feature

  Background:
    Given User has already logged in
      | email                    | password       |
      | b.c.h.o.a_78@hotmail.com | reTckJP7L5iKU9 |

  Scenario: Home Page Title
    Given User is on Home Page
    When User gets the title of the page
    Then Page title should be "En Trend Ürünler Türkiye'nin Online Alışveriş Sitesi Trendyol'da"

  Scenario: Home Page Gender Pop Up

  Scenario: Account Dropdown Count
    Given User is on Home Page
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
