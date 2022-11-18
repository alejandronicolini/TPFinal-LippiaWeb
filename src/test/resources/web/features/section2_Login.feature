@FeatureLogin @Smoke
Feature: Login de usuario

  Background:
    Given create User
    Given the user is on the home page of practice.automationtesting.in
    When clic on My Account Menu


  @LoginCaseSensitive
  Scenario: 7. Login-Handles case sensitive
    And Enter the case changed username in username textbox
    And Enter the case changed password in the password tetxbox
    And click on login button
    Then Login must fail saying: "Error: the password you entered for the username *my_username is incorrect."


  @LoginAuthentication
  Scenario: 8. Login-Authentication
    And Enter the username in username textbox
    And Enter the password in password textbox
    And click on login button
    And Once your are logged in, sign out of the site
    And Now press back button
    Then User shouldn’t be signed in to his account rather a general webpage must be visible