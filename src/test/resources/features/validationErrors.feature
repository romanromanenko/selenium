Feature: Validation errors

  Background:
    Given Open app

  Scenario: Fields validation errors registration form
    Given User switch to registration form
    When User active Terms and Condition checkbox
    And User click on Register button
    Then User validate errors of registration form
      | Enter your first name                                                                                                                     |
      | Enter your last name                                                                                                                      |
      | Enter your email address                                                                                                                  |
      | Enter your birthday                                                                                                                       |
      | OOPS! Your password must include at least 8 characters, one lowercase letter, one uppercase letter, one number and one special character  |
      | OOPS! Your password must include at least 8 characters, one lowercase letter, one uppercase letter, one number and one special character  |
