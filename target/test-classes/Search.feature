Feature:Search functionality

  Scenario:User search for existing product
    Given User opens application URL
    When User search for a product "HP"
    And User click on Search button
    Then User should see a valid product in the search results

  Scenario:User search for not  existing product
    Given User opens application URL
    When User search for an invalid product "Honda"
    And User click on Search button
    Then User should get an warning message about no product matching

  Scenario: User searches without any product
    Given User opens application URL
    When User doesn't enter any product name in the search field
    And User click on Search button
    Then User should get an warning message about no product matching