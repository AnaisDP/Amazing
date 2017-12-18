Feature: Dryad's features

Scenario: Dryad's Power
  Given Player1 has 0 cards on his board
  And Player2 has 3 cards on his board
  And  Player1 has a Dryad
  When Player1 use Dryad
  Then Player2 has 2 card on his board
  And Player1 has 2 cards on his board