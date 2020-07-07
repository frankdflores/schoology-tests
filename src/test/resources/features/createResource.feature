Feature: Creation of Resources on schoology

  @deleteResource @softAssert
  Scenario: create a resource of type: Add Test/Quiz without additional option.
    Given I log in as "ResourceInstructor01" user
    And I create an Add Test Quiz resource with:
      | name | MT_Quiz Template |
      | maxPoints | 90 |
    And I added a multiple choice question with:
      | question | What kind of animal is a feline |
      | choice_0 | Dog |
      | choice_1 | Elephant |
      | choice_2 | Cat |
      | is_answer | 3 |
      | number_of_options | 3 |
    Then I comeback to resources page
    And I should see a resource with name "MT_Quiz Template"
    And resource "MT_Quiz Template" has the question "What kind of animal is a feline"


