# Rock Paper Scissors Game

## What problem does this solve?
This program allows two players to play a Rock Paper Scissors game in a best-of-three format. It keeps track of scores,
saves it as a memory in the history.txt file and determines the winner when one player wins two rounds.

## Program Structure
- Main.java: Starts the program
- Game.java: Contains game logic
- Player.java: Stores player information

## How to Run
- Open the terminal
- Run:
  cd src
  javac *.java
  java Main

## How the program works
- First the program will ask the users to input player1 and player2 name
- Then it will ask to input Rock, rock, Paper, paper, Scissor, scissor
- If one of the players succeed in winning two rounds, the player wins
- Both player winning each round and drawing the last round will result in a draw
