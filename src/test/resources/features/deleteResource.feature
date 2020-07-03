Feature: Resources

  Scenario: Delete a Resource
    Given I log in as "Instructor01" user
    And I create a resource with:
     | name | ResourceNameTest01 |
     | description | Description01 |
    When I delete the "ResourceNameTest01" resource
    Then I should see the "Your item has been removed." message
    And I should not see the "ResourceNameTest01" displayed
