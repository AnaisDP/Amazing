Feature: Troll's features

Scenario: Troll's Power
  Given Player1 has 0 cards on his board
  And Player2 has 2 cards on his board
  And Player1 has a Troll
  When Player1 use Troll
  Then Player2 has 1 card on his board
  And Player1 has 2 cards on his board