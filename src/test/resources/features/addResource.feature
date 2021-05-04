Feature: Resources

  @deleteCourse @softAssert
  Scenario: Add a page resource
    Given I log in as "Instructor01" user
    When I navigate to "Resources"
    And I add a page resource with:
      | Title         | Page resource |
      | Resource Notes| new notes     |
    Then I should see the "The template was created." resource message
