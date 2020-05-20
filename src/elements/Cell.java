package elements;

public class Cell {

  private final int HEIGHT;
  private final int WIDTH;
  private int x;
  private int y;
  private boolean life;

  public Cell () {
    this.WIDTH = 20;
    this.HEIGHT = 20;
    this.life = false;
    this.x = -150;
    this.y = -150;
  }

  public int getHEIGHT() {
    return HEIGHT;
  }

  public int getWIDTH() {
    return WIDTH;
  }

  public boolean isLife() {
    return life;
  }

  public void setLife(boolean life) {
    this.life = life;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }
}
