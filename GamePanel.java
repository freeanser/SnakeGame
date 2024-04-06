import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
  // Snake data structure
  int length;
  int[] snakeX = new int[600];
  int[] snakeY = new int[500];
  String direction;
  int foodX;
  int foodY;
  int score;
  Random random = new Random();

  boolean isfalse = false;
  boolean isStart = false;
  Timer timer = new Timer(100, this);

  // Constructor
  public GamePanel() {
    init();
    this.setFocusable(true);
    this.addKeyListener(this);
  }

  public void init() {
    length = 3;
    snakeX[0] = 100;
    snakeY[0] = 100;
    snakeX[1] = 75;
    snakeY[1] = 100;
    snakeX[2] = 50;
    snakeY[2] = 100;
    direction = "R";
    foodX = 25 + 25 * random.nextInt(34);
    foodY = 75 + 25 * random.nextInt(24);
    score = 0;
    timer.start();
  }

}
