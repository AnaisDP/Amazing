Feature: Game Item

Scenario: Launch Game
    Given I have two players
    Then they have 0 cards
    When I Distribute Cards
    Then  they have 5 cards

Scenario: Gobelin's power
  Given Player1 has 0 cards
  And Player2 has 3 cards
  And Player1 has a gobelin
  When Player1 use gobelin
  Then Player1 has 3 cards
  And Player2 has 0 cards

Scenario: Gnome's Power
    Given Player1 has 0 cards
    And Player1 has a Gnome
    When Player1 use Gnome
    Then Player1 has 2 cards

Scenario: Korrigan's Power
    Given Player1 has 0 cards
    And Player2 has 3 cards
    And Player1 has a korrigan
    When Player1 use korrigan
    Then Player1 has 2 cards
    And Player2 has 1 cards

Scenario: Troll's Power
  Given Player1 has 0 cards on his board
  And Player2 has 2 cards on his board
  And Player1 has a Troll
  When Player1 use Troll
  Then Player1 has 2 cards on his board
  And Player2 has 1 card on his board