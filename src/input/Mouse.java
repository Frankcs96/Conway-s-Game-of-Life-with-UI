package input;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener {

  public Point coords = new Point();
  public boolean mouseLeftPressed = false;
  public boolean mouseRightPressed = false;

  @Override
  public void mouseClicked(MouseEvent e) {

  }

  @Override
  public void mousePressed(MouseEvent e) {
    coords.x = e.getX();
    coords.y = e.getY();

    System.out.println(coords);
    if (e.getButton() == MouseEvent.BUTTON1) {
      mouseLeftPressed = true;
    }

    if (e.getButton() == MouseEvent.BUTTON3) {
      mouseRightPressed = true;
    }

  }

  @Override
  public void mouseReleased(MouseEvent e) {
    mouseLeftPressed = false;
    mouseRightPressed = false;
  }

  @Override
  public void mouseEntered(MouseEvent e) {

  }

  @Override
  public void mouseExited(MouseEvent e) {

  }


}
