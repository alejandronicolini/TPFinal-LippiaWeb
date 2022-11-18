@FeatureRegistration @Smoke
Feature: Registro de cuenta de usuario

  Background:
    Given the user is on the home page of practice.automationtesting.in
    When clic on My Account Menu


  Scenario Outline: Registro de Usuario Fallido con Mensaje de Error
    And enter Email "<email>" in Email-Address textbox
    And enter password "<password>" in password textbox
    And click on Register button
    Then Registration must fail with a warning message  "<mensaje>"
    @Empty_password
    Examples:
      | email               | password | mensaje                                  |
      | florencia@gmail.com |          | Error: Please enter an account password. |
    @Empty_email_password
    Examples:
      | email | password | mensaje                                      |
      |       |          | Error: Please provide a valid email address. |