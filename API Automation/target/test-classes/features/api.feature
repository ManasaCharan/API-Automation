Feature: Add a Pet Owner
  Scenario: Successfully add a new pet owner
    Given I set the base URI to "http://localhost:8080"
    When I send a POST request to "/owners" with the following data
#    When I send a POST request to with the following data
      | firstName | Man  |
      | lastName  | Su   |
      | address   | 123 Main St |
      | city      | Bengaluru |
      | telephone | 1234567890 |
#    Then the response status code should be 201
#    And the response body should contain "id"