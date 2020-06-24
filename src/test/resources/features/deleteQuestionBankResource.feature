Feature: Resources

  Scenario: Delete a Question Bank Resource
    Given I log in as "Instructor01" user
    And I create a Question Bank Resource with:
      | name    | Resource Question  |
      | description | This is a description       |
      | tracking    | True       |
    When I navigate to "Resources"
    And I delete the Question Bank Resource "Resource Question"
    Then I should see the "Your item has been removed." message
    And I should not find "Resource Question" item
