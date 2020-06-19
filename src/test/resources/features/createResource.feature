# new feature
# Tags: optional

Feature: Resources

  Scenario: Delete a question bank
    Given I log in as "Trainer" user
    And I navigate to Resources
    And I create a resource with:
      | name                    | RG_QuestionBank |
      | description             | This is a test  |
      | enableQuestionTracking  | True            |
    And I delete the question bank with name "RG_QuestionBank"
    Then I should see the "Your item has been removed." message