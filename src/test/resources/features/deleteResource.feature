Feature: ResourcesTest
  Scenario: Delete Question Bank
    Given I log in as "TestUser" user
    And I create a resource with:
      | name        | Question1            |
      | description | Description question |
    When I navigate to menu "Resources"
    And I delete the "Question1" resource
    Then I should see the "Your item has been removed." message
    And I should not see the resource deleted "Question1"