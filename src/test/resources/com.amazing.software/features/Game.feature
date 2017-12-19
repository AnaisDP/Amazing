Feature: Game Item

Scenario: Launch Game
    Given I have two players
    Then they have 0 cards
    When I Distribute Cards
    Then  they have 5 cards
  
Scenario: Draw Card
  Given Player1 has 2 cards
  When Player1 draw a card
  Then Player1 should have 3 cards
  
Scenario: Draw card with an empty deck
  Given Player1 has 2 cards
  And The Deck is empty
  When Player1 draw a card
  Then Player1 should have 2 cards