Feature: Register User

    Background: 
        Given the User is on the home page of the application
        And the user clicks the register link

    Scenario: Register a new User
        When the User fill the valid details in the register page
        And clicks the register button
        Then registraion completed message should be visible