Feature: Product page Assertion




  Scenario Outline: Check that the Name (A to Z) works as per expected
    Given User should login to swag labs using correct <Username> and <Password>
    When User click the sort AZ
    Then User should see the AZ sorted products

    Examples:
      | Username                  | Password       |
      | "standard_user"           | "secret_sauce" |


  Scenario Outline: Check that Name (Z to A) works as per expected.
    Given User should login to swag labs using correct <Username> and <Password>
    When User click the sort ZA
    Then User should see the ZA sorted products

    Examples:
      | Username                  | Password       |
      | "standard_user"           | "secret_sauce" |


  Scenario Outline: Check that the Price (Low to High) works as per expected.
    Given User should login to swag labs using correct <Username> and <Password>
    When User click the sort low to high
    Then User should see the low to high sorted products

    Examples:
      | Username                  | Password       |
      | "standard_user"           | "secret_sauce" |



  Scenario Outline: Check that the Price (High to Low) works as per expected
    Given User should login to swag labs using correct <Username> and <Password>
    When User click the sort high to low
    Then User should see the high to low sorted products

    Examples:
      | Username                  | Password       |
      | "standard_user"           | "secret_sauce" |
