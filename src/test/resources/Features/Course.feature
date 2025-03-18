Feature: All Courses Page Functionalities

 
  Scenario: Filter courses by category
    Given I navigate to the All Courses page
    When I select "Test Automation" from the category filter
    Then I should see only courses related to "Test Automation"
    
     Scenario: Search for a course
    Given I navigate to the All Courses page
    When I enter "Selenium WebDriver Advanced" in the search box
    Then I should see search results related to "Selenium WebDriver Advanced"
    