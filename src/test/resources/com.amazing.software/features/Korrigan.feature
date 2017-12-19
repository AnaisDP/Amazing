Feature: Korrigan's features

  Scenario: Korrigan's Power
    Given Player1 has 0 cards
    And Player2 has 3 cards
    And Player1 has a korrigan
    When Player1 use korrigan
    Then Player1 should have 2 cards
    And Player2 should have 1 cards

  Scenario: use Korrigan when oppoment has 1 card
    Given Player1 has 0 cards
    And Player2 has 1 cards
    And Player1 has a korrigan
    When Player1 use korrigan
    Then Player1 should have 1 cards
    And Player2 should have 0 cards

  Scenario: use Korrigan when oppoment has 0 card
    Given Player1 has 1 cards
    And Player2 has 0 cards
    And Player1 has a korrigan
    When Player1 use korrigan
    Then Player1 should have 1 cards
    And Player2 should have 0 cards