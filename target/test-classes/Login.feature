Feature: Login functionality

  Scenario: Login with valid credentials
    Given User navigates to login page
    When  User has entered the valid email address "amotooricap3@gmail.com" into email fields
    And User has entered the valid password "12345" into password field
    And User clicks on Login button
    Then User Should been login successfully

  Scenario: Login with invalid credentials
    Given User navigates to login page
    When  User has entered the invalid email address "amotooricap2025@gmail.com" into email fields
    And User has entered the invalid password "123456778" into password field
    And User clicks on Login button
    Then User Should get an proper warning message about invalid credentials

  Scenario: login with valid email and invalid password
    Given User navigates to login page
    When  User has entered the invalid email address "amotooricap2025@gmail.com" into email fields
    And User has entered the invalid password "123456778" into password field
    And User clicks on Login button
    Then User Should get an proper warning message about invalid credentials

  Scenario: Login with invalid email and valid password
    Given User navigates to login page
    When  User has entered the invalid email address "amotooricap2025@gmail.com" into email fields
    And User has entered the valid password "12345" into password field
    And User clicks on Login button
    Then User Should get an proper warning message about invalid credentials

  Scenario: Login without providing any credentials
    Given User navigates to login page
    When  User doesn't entered email address  into email fields
    And User doesn't entered  password  into password field
    And User clicks on Login button
    Then User Should get an proper warning message about invalid credentials