Feature: Groups

  Scenario: Edit a group
    Given I log in as "Trainer" user
    And I create a group with:
      | name        | SeleniumWebDriver |
      | description | Description       |
      | privacy     | School            |
      | access      | Invite Only       |
      | category    | Musical Groups    |
    When I navigate to "Groups"
    And I edit the "SeleniumWebDriver" group with:
      | name | SeleniumWebDriver updated |
    Then I should see "SeleniumWebDriver updated has been saved." as a message
    And I should see a group with "SeleniumWebDriver updated" as a name