Feature: Registration functionality scenarios

  Scenario : Verify whether user is able to register into the application by providing all the details
    Given I launch the app
    And I navigate to Account Registration page
    When I provide all the below valid details :

      |FirstName| Ravi                    |
      |LastName | Kiran                   |
      |Email    |Ravi.kiran@gmail.com     |
      |Telephone|9212345678               |
      |Password |rkiran                   |
    And I check-in the Privacy Policy
    And  I click on continue button
    Then I should see that the User Account has successfully been created