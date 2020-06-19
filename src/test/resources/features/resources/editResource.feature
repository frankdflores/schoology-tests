Feature: Delete Resources

  Scenario: Edit a Question Bank
    Given I log in as "Trainer" user
    And I add the resource Question Bank with:
      | name                     | My Question Bank  |
      | description              | Brief description |
      | enable Question Tracking | false             |
    When I edit the resource "My Question Bank" with:
      | name                     | My Question Bank modified  |
      | description              | Brief description modified |
      | enable Question Tracking | true                       |
    Then I should see the "Your changes have been saved." message
