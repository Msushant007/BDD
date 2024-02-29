Feature: LoginPage

  @Sanity_Test
  Scenario: Successful Login with Valid Credential.
    Given User Launch the Chrome browser
    When User open URL "https://admin-demo.nopcommerce.com/login"
    And User Enters Email As "admin@yourstore.com" and Password as "admin"
    And Click on Login button
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User Click on Logout link
    Then After Logout Page Title should be "Your store. Login"







