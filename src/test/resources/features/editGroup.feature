Feature: Groups

  Scenario: Edit a Group
    Given I log in as "Trainer" user
    And I create a group with:
      | name | FirstGroup |
      | description | Description01 |
      | privacy | Group |
      | access | Open |
      | category | Musical Groups |
    When I navigate to Groups
    And I edit the "FirstGroup" group with:
      | name | FirstGroupEdited |
      | description | Description01Edited |
      | code | CodeEdited |
      | privacy | No one |
      | access | Allow request |
      | category | Faculty Groups
    Then I should see "The section has been updated." message

