Feature: Login Functionality for OpenCart e-commerce Website

  As a user of the OpenCart website
  I want to login with my user credential
  so that i can access my account-related features and manage my order

  Background:
    Given I am on the OpenCart login page

  Scenario: Navigate to forgot password page from login page
    Given User on login page
    When I click on the Forgotten Password link
    Then I should redirected to password reset page



  Scenario: Successful login with valid credentials
    Given I have entered valid username and password
    When  I click on login button
    Then  I should logged in successfully



    Scenario: Successful logout for logged in user
      Given I have entered valid username and password for logout test
      When I click on logout button
      Then I should logout successfully


  Scenario Outline: Unsuccessful login with invalid user and password
    Given I have entered invalid "<username>" and "<password>"
    When  I click on logins button
    Then  I should seen a error message indicating "<error_message>"

    Examples:
    | username           | password            | error_message                                     |
    | invalid@email.com  | invalidPassword     | Warning : No match for E-mail Address / Password. |
    | abcccced           | validPassword       | Warning : No match for E-mail Address / Password. |
    | valid@email.com    | abcccced            | Warning : No match for E-mail Address / Password. |


