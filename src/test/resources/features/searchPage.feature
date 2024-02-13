Feature: Login Functionality for OpenCart e-commerce Website

  As a user of Amazon, able to open the Amazon e-commerce site
  I need to find Specific Iphone with price
  So that i can add product in my cart after search

  Background:
    Given I am on the amazon page


  Scenario User navigate to Amazon page and select the Mobile category by clicking
    Given User is selected the Mobile category
    Then User will navigate to mobile Category page

  Scenario Outline: User will enter the product name and search the product with cost
    Given User searches for "<product>"
    Then Search result are displayed
    When User need to identify "<product>" with "<cost>"
    Then user add the product in cart

    Examples:
      | product                                       | cost    |
      | Apple iPhone 14 Plus (128 GB) - (Product) RED | ₹75,999 |
      | Apple iPhone 14 (128 GB) - Yellow             | ₹69,999 |



