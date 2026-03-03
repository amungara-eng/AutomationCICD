Feature: Error Validation


  @ErrorValidation
  Scenario Outline:
   Given I landed on Ecommerce Page
    When Logged in with your username <name> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples:
      | name                     | password         | 
      | anupamamungara@gmail.com | Selenium@1co     | 
