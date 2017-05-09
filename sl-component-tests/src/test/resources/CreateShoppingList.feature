Feature: Creation of New Lists

  Scenario: I'm the user of the Application and I wanna create a new List
    Given the new list
      | list-id-device | 1      |
      | list-name      | List 1 |
    And the items
      | item-id-device | item-name | is-checked | quantity-description |
      | 11             | Item 1    | true       | 2                    |
      | 12             | Item 2    | false      | 3                    |
    When I click to create a new List
    Then the returned status is 201
    And the list-id-server is 1
    And the items are
      | item-id-device | item-id-server |
      | 1              | 1              |
      | 2              | 2              |