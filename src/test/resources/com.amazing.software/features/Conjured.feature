Feature: Conjured Item

Scenario: Create Game
  Given I have two players
  Then each players have 0 cards
  When I Create a new Game
  Then each players have 5 cards