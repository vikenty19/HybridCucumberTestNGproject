Feature: Registration functionality scenarios

  Scenario :User is able to create an account only with mandatory fields
    Given User navigates to Register Account page
    When User enters the details into below fields
      | FirstName | Ravi          |
      | LastName  | Kiran         |
      | Email     | Vic90@gmail.com |
      | Telephone | 9212345678    |
      | Password  | 12345         |
    And  User select Yes the Privacy Policy
    And  User click on continue button
    Then User  should see that the User Account has successfully been created

  Scenario :User creates an duplicate account
    Given User navigates to Register Account page
    When User enters the details into below fields
      | FirstName | Ravi          |
      | LastName  | Kiran         |
      | Email     | Vic90@gmail.com |
      | Telephone | 9212345678    |
      | Password  | 12345         |
    And  User select Yes the Privacy Policy
    And User select Yes for the newsletter
    And  User click on continue button
    Then User should see proper warning message about duplicate email

  Scenario: User creates an Account without filling any details
    Given User navigates to Register Account page
    When User doesn't enter  any details
    And  User click on continue button
    Then User should see a proper messages in all mandatory fields