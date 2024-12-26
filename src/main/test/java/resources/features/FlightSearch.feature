Feature: Flight search on MakeMyTrip website

  Scenario: User searches for flights from HYD to MAA for a round trip
    Given I launch the browser and open the MakeMyTrip website
    When I click on the "Flights" tab
    And I select "Round Trip"
    And I enter "HYD" as the From location and "MAA" as the To location
    And I select the departure date as "2024-12-26" and return date as "2025-01-02"
    And I click the "Search" button
    Then I should see the flight search results page displayed
