Feature: elf's features

Scenario: Elf's Power
  Given Player2 has 3 cards on his board
  And Player2 has an elf
  When Player2 use elf
  Then  Player2 should have 2 cards