Feature: Gobelin features

Scenario: Gobelin's power
  Given Player1 has 0 cards
  And Player2 has 3 cards
  And Player1 has a gobelin
  When Player1 use gobelin
  Then Player1 should have 3 cards
  And Player2 should have 0 cards