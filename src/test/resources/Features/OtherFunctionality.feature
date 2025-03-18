Feature: Automate Let’s Kode It Practice Page

  @AllFunctionality
  Scenario: Test All Functionality on Let's Kode It Practice Page
    Given I open the Let’s Kode It Practice page
    # Radio Button
    When I select the radio button
    Then the radio button should be selected
    # Checkboxes
    When I select the checkbox
    Then both checkboxes should be selected
    # Window Switch
    When I click on button
    And I switch back to the main window
    # Tab Switch
    When I click on button for tab
    And I switch back to the main tab
      # Dropdown
    When I select from the dropdown
    Then should be selected
    # Multi Select
    When I select multiple options from the dropdown
    Then Options should be selected
    # Auto Suggest
    When I type "India" in the AutoSuggest box
    Then "India" should be displayed in the AutoSuggest box
    # Enable/Disable
    When I enable the input field
    Then the field should be enabled
    When I disable the input field
    Then the field should be disabled
    # Show/Hide
    When I click on Show button
    When the textbox should be hidden
    Then the textbox should be displayed
    # Alerts
    When I click on "Alert" button
    Then a confirmation popup should appear and I accept it
    # Mouse Hover
    When I hover over the Mouse Hover button
    Then I should see additional options
    #Table
    When I fetch the course details from the table
    Then I should see the correct course prices