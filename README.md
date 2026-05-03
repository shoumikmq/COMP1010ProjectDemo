# Rock Paper Scissors Game

## What problem does this solve?
This program allows two players to play a Rock Paper Scissors game in a best-of-three format. It keeps track of scores,
saves it as a memory and determines the winner when one player wins two rounds.

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
- Then it will ask to input one of the six words: Rock, rock, Paper, paper, Scissor, scissor
- The one to win two rounds first will win the game 
- Both player1 and player 2 winning each round and drawing the last round will result in a draw
- Each time the user finishes one game, the whole records get saved a memory in the history.txt file  

## Inner Structure
- If the user input anything other than six words, the program will ask the user to input again
- If the game doesn't end in three rounds, the program asks the user to input again
