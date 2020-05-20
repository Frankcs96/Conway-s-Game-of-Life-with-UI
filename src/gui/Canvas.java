package gui;

import elements.Board;
import elements.Cell;
import input.Keyboard;
import input.Mouse;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Canvas extends JPanel implements ActionListener {

  private Timer timer;
  private Board board;
  private Keyboard keyboard;
  private Mouse mouse;
  private Font font;


  public Canvas() {
    this.board = new Board(200);
    this.timer = new Timer(50, this);
    this.keyboard = new Keyboard();
    this.mouse = new Mouse();
    font = new Font("Arial", Font.BOLD, 20);

    setBackground(Color.WHITE);
    setFocusable(true);
    setVisible(true);
    addKeyListener(keyboard);
    addMouseListener(mouse);

    timer.start();


  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setFont(font);

    if (!keyboard.pause) {
      this.board.setNextStage();
    }

    this.board.drawBoard(g2d);

    g2d.setColor(Color.BLACK);
    g2d.drawString("Left click to draw", 570, 30);
    g2d.drawString("Right click to erase", 570, 50);
    g2d.drawString("Press space for pause/resume", 570, 70);


  }

  @Override
  public void actionPerformed(ActionEvent e) {

    repaint();

    if(mouse.mouseLeftPressed) {
      drawWithClick(true);
    }

    if (mouse.mouseRightPressed) {
      drawWithClick(false);
    }

  }

  private void drawWithClick(boolean event) {   // True - Left click || False - right click
    Cell[][] myBoard = board.getBoard();

    for (int i = 0; i < myBoard.length; i++) {
      for (int j = 0; j < myBoard.length; j++) {
        Cell cell = myBoard[i][j];
        if ((mouse.coords.x >= cell.getX() && mouse.coords.x <= cell.getX() + cell.getWIDTH()) && (
            mouse.coords.y >= cell.getY() && mouse.coords.y <= cell.getY() + cell.getHEIGHT())) {
          if (event) {
            myBoard[i][j].setLife(true);
          } else {
            myBoard[i][j].setLife(false);
          }


        }
      }
    }
  }
}
