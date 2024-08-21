# Connect Four

## Introduction

This project represents an implementation of the popular game **Connect Four**, developed using JavaFX in the IntelliJ IDEA environment. It was created as part of the coursework for CS203 - Algorithms and Data Structures.

## Task Description

**Connect Four** is a classic two-player game played on a board with 7 columns and 6 rows. Players take turns placing their tokens in the columns, which fill from the bottom up. The objective is to align four tokens in a row (horizontally, vertically, or diagonally). The game ends when one player achieves this or when the board is completely filled.

## Game Outcomes

- **Victory**: A player wins by placing four consecutive tokens. Afterward, players can choose to play again or exit the game.
- **Draw**: If the board is filled completely without a winner, the game ends in a draw. Players are then given the option to restart or quit.

## Game Methods

- `dropPiece(int column)` - Inserts a token into the selected column.
- `checkForWin(int row, int column)` - Checks if the last move resulted in a win.
- `checkForDraw()` - Checks if the board is full and the game is a draw.
- `showResult(String winner)` - Displays the game result in a pop-up window, offering options to restart or exit the game.
- `resetGame()` - Resets the game board and state for a new game.

## Application Interface

The initial screen of the application looks like this:

![image](https://github.com/user-attachments/assets/7d3590a4-5811-4bc8-934b-66bb0f3f69a9)

## Conclusion

This Connect Four game implementation meets the essential project requirements and provides a functional and interactive gaming experience for two players.
