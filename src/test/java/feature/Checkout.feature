

Feature: Checkout functionality


  Scenario Outline: Check that the user “standard_user” can perform a checkout.
    Given User should login to swag labs using correct <Username> and <Password>
    And User click the add to cart buttons
    And User click the cart icon
    When User click the checkout button
    Then User should see the checkout info page

    Examples:
      | Username                  | Password       |
      | "standard_user"           | "secret_sauce" |
