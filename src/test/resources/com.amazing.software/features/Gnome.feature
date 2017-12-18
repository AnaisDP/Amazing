Feature: Gnome features

Scenario: Gnome's Power
  Given Player1 has 0 cards
  And Player1 has a Gnome
  When Player1 use Gnome
  Then Player1 should have 2 cards

Scenario: Use a Gnome with an empty deck
  Given Player1 has 2 cards
  And Player1 has a Gnome
  And The Deck is empty
  When Player1 use Gnome
  Then Player1 should have 2 cards

Scenario: Use a Gnome with one card in the deck
  Given Player1 has 2 cards
  And Player1 has a Gnome
  And There is one card in the deck
  When Player1 use Gnome
  Then Player1 should have 3 cards