Feature: Login

    Background:
        Given the User is on the home page of the application
        And the user clicks the register link

    Scenario Outline: invalid Login
        When the user fills the email as "<email>"
        And the user fills the password as "<pass>"
        And clicks the login Button
        Then the erroe message is shown as "<error>"

        Examples:
            | email | pass | error |
            | jeri  | 123456  | Please enter a valid email address.  |
            | jeri12asddd@gmail.com | 123456 |No customer account found|
            | jeri1234@gmail.com | 12345678|The credentials provided are incorrect|

    Scenario: valid Login
        When the user fills the valid credentials
        And clicks the login Button
        Then the user should see mail on home page