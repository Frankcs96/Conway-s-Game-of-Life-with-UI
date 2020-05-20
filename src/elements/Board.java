package elements;

import java.awt.Color;
import java.awt.Graphics2D;

public class Board {

  private Cell[][] board;

  public Board(final int SIZE) {
    this.board = new Cell[SIZE][SIZE];
    initBoard(this.board);

  }


  public void drawBoard(Graphics2D g2d) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {

        if (board[i][j].isLife()) {
          g2d.setColor(Color.BLACK);
        } else {
          g2d.setColor(Color.white);
        }

        g2d.fillRect(board[i][j].getX(), board[i][j].getY(), board[i][j].getWIDTH(),
            board[i][j].getHEIGHT());
        g2d.setColor(Color.BLACK);
        g2d.drawRect(board[i][j].getX(), board[i][j].getY() , board[i][j].getWIDTH(),
            board[i][j].getHEIGHT());

      }
    }
  }

  public void initBoard(Cell[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        board[i][j] = new Cell();
        board[i][j].setX(j * board[i][j].getWIDTH() - 50); // -50 so cells go out of the screen
        board[i][j].setY(i * board[i][j].getHEIGHT() - 50);
      }
    }
  }

  public int aliveNeighbours(int i, int j, Cell[][] board) {
    int result = 0;
    //Left
    if (j - 1 >= 0) {
      if (board[i][j - 1].isLife()) {
        result += 1;
      }
    }
    //right
    if (j + 1 < board.length) {
      if (board[i][j + 1].isLife()) {
        result += 1;
      }
    }
    //Up
    if (i - 1 >= 0) {
      if (board[i - 1][j].isLife()) {
        result += 1;
      }
    }
    //Down
    if (i + 1 < board.length) {
      if (board[i + 1][j].isLife()) {
        result += 1;
      }
    }
    //upper left diagonal
    if (i - 1 >= 0 && j - 1 >= 0) {
      if (board[i - 1][j - 1].isLife()) {
        result += 1;
      }
    }
    //upper right diagonal
    if ((i - 1 >= 0 && j + 1 < board.length)) {
      if (board[i - 1][j + 1].isLife()) {
        result += 1;
      }
    }
    // down left diagonal
    if (i + 1 < board.length && j - 1 >= 0) {
      if (board[i + 1][j - 1].isLife()) {
        result += 1;
      }
    }
    // down right diagonal
    if (i + 1 < board.length && j + 1 < board.length) {
      if (board[i + 1][j + 1].isLife()) {
        result += 1;
      }
    }
    return result;
  }

  public Cell[][] calculateNextStage() {
    Cell[][] result = new Cell[200][200];
    initBoard(result);
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if ((board[i][j].isLife() == false) && aliveNeighbours(i, j, board) == 3) {
          result[i][j].setLife(true);
        }
        if ((board[i][j].isLife()) && (aliveNeighbours(i, j, board) == 2
            || aliveNeighbours(i, j, board) == 3)) {
          result[i][j].setLife(true);
        }
      }
    }
    return result;
  }

  public void setNextStage() {
    this.board = calculateNextStage();
  }

  public Cell[][] getBoard () {
    return board;
  }


}
