Feature: Resources

  Scenario: Delete a Resource
    Given I log in as "Trainer" user
    And I create a resource with:
     | name | ResourceNameTest04 |
     | description | Description01 |
    When I delete the "ResourceNameTest04" resource
    Then I should see the "Your item has been removed." message
    And I should not see the "ResourceNameTest04" displayed
