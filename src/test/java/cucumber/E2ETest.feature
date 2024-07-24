
Feature: E2E Test case

Background: 
Given Navigate to baseUrl

  @Regression 
  Scenario Outline: Positive E2E test scenario
    Given Login with username <name> and password <password>
    When added product <product> to the cart and checkout
    Then verify the details "***"
  

    Examples: 
      | name                       |  password  | product    |
      | prasadkalmegh123@gmail.com |  Pr@s@d123 | Nikon D300 |
