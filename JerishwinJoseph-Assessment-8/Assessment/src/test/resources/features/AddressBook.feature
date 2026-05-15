Feature: Access the Address Book 

	Background:
    Given the user is logged into TutorialsNinja

  Scenario: Add a new address using a Cucumber Data Table

    When the user navigates to the Address Book page
    And the user clicks "Add New Address"
    And the user fills in the address form with the following details:
      | Field        | Value           |
      | First Name   | John            |
      | Last Name    | Doe             |
      | Address 1    | 123 Main Street |
      | City         | Chennai         |
      | Post Code    | 600001          |
      | Country      | India           |
      | Region/State | Tamil Nadu      |
    Then the address should be saved successfully

		