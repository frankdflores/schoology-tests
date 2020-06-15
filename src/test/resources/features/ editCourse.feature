Feature: Courses

  Scenario: Edit a course
    Given I log in as "Trainer" user
    And I create a "course" with:
      | name | SeleniumWebDriver |
      | section | New Section |
      | area | Mathematics |
      | level | Undergraduate |
    When I navigate to "Courses"
    And I edit the "SeleniumWebDriver" "course" with:
      | name | SeleniumWebDriverEdited |
      | section | New Section01Edited |
      | area | Mathematics |
      | level | Undergraduate |
    Then I should see the "The section has been updated." message
    And I should see the "New Section01Edited" section on "SeleniumWebDriverEdited" course item