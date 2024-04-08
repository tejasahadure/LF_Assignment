Feature: Cart functionality


  Scenario Outline: Check the user can log into the application with user “standard_user”
    Given User should login to swag labs using correct <Username> and <Password>
    When User click the add to cart button <itemNumber>
    Then User should see the updated cart badge

    Examples:
      | Username                  | Password       | itemNumber |
      | "standard_user"           | "secret_sauce" | 0          |

