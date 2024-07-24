Feature:  Login with invalid credit

Background: Navigate to baseUrl

  @Regression 
  Scenario Outline: Invalid Test
    Given Navigate to baseUrl
    When  Login with username <name> and password <password>
    Then  verify the url of current page
  

    Examples: 
      | name                    |    password  | 
      | prasadkalmegh@gmail.com |    Pr@s@d    | 
