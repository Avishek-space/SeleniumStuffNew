
@tag
Feature: Purchasing the order from the Ecommerce site.
  I want to use this template for my feature file

Background:
Given I landed on the Ecommerce login page
  

  @Regression
  Scenario Outline: poisitve test for purchasing an order.
    Given Logged in with username <name> and password <pass>
    When I added a product <productName> to the cart
    And Go to checkout product <productName> and submit the order
    Then the confirmation message "THANKYOU FOR THE ORDER." is displayed

    Examples: 
    
      | name              | pass          | productName    |
      | avi1234@gmail.com | Avijanu12345! | ZARA COAT 3     |
      | aviavi@gmail.com  | Abcd1234!     | ADIDAS ORIGINAL |
