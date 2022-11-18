@FeatureMyAccount @Smoke
Feature: My Account

  Background:
    Given create User
    Given the user is on the home page of practice.automationtesting.in
    When clic on My Account Menu
    And Enter the username in username textbox
    And Enter the password in password textbox
    And click on login button
    And User must successfully login to the web page
    And Click on My account link


  @AccountDetails
  Scenario: 7. My Accounts-Account Details
    And Click on Account details
    Then User can view account details where he can change his password also


  @LogOut
  Scenario: 8. My Accounts-Log-Out
    And Click on Logout button
    Then On clicking logout,User successfully comes out from the site


