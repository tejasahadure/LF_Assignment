Feature: Login to Swag lab page

  Scenario Outline: Check that the user “locked_out_user” cannot log in to the application.
Given User should navigate to swag labs login page
When User enter the <Username> and <Password>
And User click the login button
Then User should not navigate to Swag Labs home page

Examples:
| Username     | Password       |
| "locked_out_user" | "secret_sauce" |
