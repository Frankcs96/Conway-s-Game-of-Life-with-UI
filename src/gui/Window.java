package gui;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Window extends JFrame {

  private int width;
  private int height;
  private String title;
  private Canvas canvas;

  public Window() {

    this.width = 900;
    this.height = 600;
    this.title = "Game of life";
    this.canvas = new Canvas();



    setSize(width, height);
    setTitle(title);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    add(canvas);
    setVisible(true);


  }



}

