Feature: Purchase the order from Ecommerce Site

  Background:
    Given I landed on Ecommerce Page


  @Regression
  Scenario Outline:Positive Test of Submitting the order
    Given Logged in with your username <name> and password <password>
    When i add product <productname> to cart
    And Checkout <productname> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples:
      | name                     | password         | productname |
      | anupamamungara@gmail.com | Selenium@1course | ZARA COAT 3 |
