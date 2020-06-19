Feature: Delete Resources

  Scenario: Delete a Question Bank
    Given I log in as "Trainer" user
    And I add the resource Question Bank with:
      | name                     | My Question Bank  |
      | description              | Brief description |
      | enable Question Tracking | true              |
    When I delete the resource "My Question Bank"
    Then I should see the "Your item has been removed." message
