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
