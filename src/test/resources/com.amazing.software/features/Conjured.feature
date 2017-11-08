Feature: Conjured Item

Scenario: Create Game
  Given I have two players
  Then each players have 0 cards
  When I Create a new Game
  Then each players have 5 cards

Scenario: Draw Card
  Given I have a player
  Then He have 0 card
  When He draw 1 card
  Then He have 1 card

Scenario: Gobelin Power*
  Given