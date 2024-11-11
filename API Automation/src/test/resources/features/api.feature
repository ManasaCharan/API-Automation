Feature: Add a Pet Owner
  Scenario: Successfully add a new pet owner
    Given I set the base URI to "http://localhost:8080"
    When I send a POST request to "/owners" with the following data
      | firstName | Man  |
      | lastName  | Su   |
      | address   | 123 Main St |
      | city      | Bengaluru |
      | telephone | 1234567890 |
#    Then the response status code should be 201
#    And the response body should contain "id"

  Scenario: Get owner details by valid ID
    Given I set the base URI to "http://localhost:8080"
    When I send a GET request to "/owners/1"
    Then the response status code should be 200
    And the response should contain "1"
    And the response should contain "Man"

  Scenario: Update owner details with valid data
    Given I set the base URI to "http://localhost:8080"
    When I send a PUT request to "/owners/1" with the following data
      | name  | Man Update  |
    Then the response status code should be 200
    And the response should contain "id"
    And the response should contain "Man"


  Scenario: Delete owner by valid ID
    Given I set the base URI to "http://localhost:8080"
    When I send a DELETE request to "/owners/1"
    Then the response status code should be 200
    And the response should contain "1"
    And the response should contain "Man"
