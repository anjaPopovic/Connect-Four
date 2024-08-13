package org.example.cs203projekat5363anjapopovic;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ConnectFour extends Application {
    private final int ROWS = 6;
    private final int COLUMNS = 7;
    private final int CIRCLE_RADIUS = 50;
    private int[][] board = new int[ROWS][COLUMNS];
    private boolean player1Turn = true;
    private GridPane gridPane;
    private Circle[][] circles = new Circle[ROWS][COLUMNS];

    @Override
    public void start(Stage primaryStage) {
        gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: lightskyblue;");
        gridPane.setAlignment(Pos.CENTER);
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                StackPane stackPane = new StackPane();
                Rectangle rectangle = new Rectangle(2 * CIRCLE_RADIUS, 2 * CIRCLE_RADIUS, Color.LIGHTSKYBLUE);

                Circle circle = new Circle(CIRCLE_RADIUS - 5);
                circle.setFill(Color.WHITE);
                stackPane.getChildren().addAll(rectangle, circle);
                final int column = col;
                stackPane.setOnMouseClicked(event -> dropPiece(column));
                gridPane.add(stackPane, col, row);
                circles[row][col] = circle;
            }
        }
        Scene scene = new Scene(gridPane, 800, 700);
        primaryStage.setTitle("Connect Four");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void dropPiece(int column) {
        int row = ROWS - 1;
        while (row >= 0 && board[row][column] != 0) {
            row--;
        }
        if (row >= 0) {
            board[row][column] = player1Turn ? 1 : 2;
            Circle piece = circles[row][column];
            piece.setFill(player1Turn ? Color.RED : Color.YELLOW);
            if (checkForWin(row, column)) {
                showResult(player1Turn ? "Player 1" : "Player 2");
            } else if (checkForDraw()) {
                showResult("It's a draw");
            } else {
                player1Turn = !player1Turn;
            }
        }
    }

    private boolean checkForWin(int row, int col) {
        int player = board[row][col];

        //HORIZONTALNO
        int count = 1;
        for (int c = col - 1; c >= 0 && board[row][c] == player; c--) {
            count++;
        }
        for (int c = col + 1; c < COLUMNS && board[row][c] == player; c++) {
            count++;
        }
       if (count >= 4) {
            return true;
        }


       //VERTIKALNO
        count = 1;
       for (int r = row - 1; r >= 0 && board[r][col] == player; r--) {
            count++;
        }
        for (int r = row + 1; r < ROWS && board[r][col] == player; r++) {
            count++;
        }
        if (count >= 4) {
            return true;
        }

        //DIJAGONALNO
        count = 1;
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0 && board[r][c] == player; r--, c--) {
            count++;
        }
       for (int r = row + 1, c = col + 1; r < ROWS && c < COLUMNS && board[r][c] == player; r++, c++) {
            count++;
        }
        if (count >= 4) {
            return true;
        }

        count = 1;
        for (int r = row - 1, c = col + 1; r >= 0 && c < COLUMNS && board[r][c] == player; r--, c++) {
            count++;
        }
        for (int r = row + 1, c = col - 1; r < ROWS && c >= 0 && board[r][c] == player; r++, c--) {
            count++;
        }
       return count >= 4;
    }

    private boolean checkForDraw() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                if (board[row][col] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private void showResult(String winner) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText("Winner: " + winner + "\nDo you want to play again?");

        ButtonType exitButton = new ButtonType("Exit");
        ButtonType playAgainButton = new ButtonType("Play Again");

        alert.getButtonTypes().setAll(exitButton, playAgainButton);

        alert.showAndWait().ifPresent(buttonType -> {
            if (buttonType == exitButton) {
                System.exit(0);
            } else if (buttonType == playAgainButton) {
                resetGame();
            }
        });
    }

    private void resetGame() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                board[row][col] = 0;
                circles[row][col].setFill(Color.WHITE);
            }
        }
        player1Turn = true;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

