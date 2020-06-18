Feature: Delete Resources

  Scenario: Edit a Question Bank
    Given I log in as "Trainer" user
    And I add a resource "Question Bank" with:
      | name    | My Question Bank |
      | description | Brief description       |
      | enable Question Tracking    | true       |
    When I edit resource option of "Question Bank" with:
      | section | Section Test |
      | area    | Science      |
    Then I should see the "The section has been updated." message
