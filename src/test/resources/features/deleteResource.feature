# new feature
# Tags: optional

Feature: Resources

  Scenario: delete a resource
    Given I log in as "Trainer" user
    And I create a "Add Question Bank" resource with:
      | name        | Test Add Question Bank        |
      | description | Add Question Bank Description |
      | enable      | true                          |
    When I navigate to "Resources"
    And I delete the "Test Add Question Bank" resource
    Then I should see "Your item has been removed." as a message
    And I should not see a resource with "Test Add Question Bank" as a name