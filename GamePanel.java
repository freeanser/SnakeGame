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

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    this.setBackground(Color.white);
    Data.header.paintIcon(this, g, 25, 11);// Draw the header
    g.fillRect(25, 75, 850, 600);// Default game interface

    g.setColor(new Color(51, 25, 0)); // Dark brown color
    g.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
    g.drawString("Length:" + length, 750, 35);
    g.drawString("Score:" + score, 750, 50);

    // Food
    Data.food.paintIcon(this, g, foodX, foodY);

    if (direction.equals("R")) {
      Data.right.paintIcon(this, g, snakeX[0], snakeY[0]);
    } else if (direction.equals("L")) {
      Data.left.paintIcon(this, g, snakeX[0], snakeY[0]);
    } else if (direction.equals("U")) {
      Data.up.paintIcon(this, g, snakeX[0], snakeY[0]);
    } else if (direction.equals("D")) {
      Data.down.paintIcon(this, g, snakeX[0], snakeY[0]);
    }

    // Snake
    // for (int i = 1; i < length; i++) {
    // Data.body.paintIcon(this, g, snakeX[i], snakeY[i]);
    // }

    // if (isStart == false) {
    // g.setColor(Color.white);
    // g.setFont(new Font("微软雅黑", Font.BOLD, 40));
    // g.drawString("按下空格开始游戏", 300, 300);
    // }

    // if (isfalse) {
    // g.setColor(Color.red);
    // g.setFont(new Font("微软雅黑", Font.BOLD, 40));
    // g.drawString("失败，按下空格重新开始 ", 300, 300);
    // }

    // }

    for (int i = 1; i < length; i++) {
      Data.body.paintIcon(this, g, snakeX[i], snakeY[i]);
    }

    if (!isStart) {
      g.setColor(Color.white);
      g.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
      g.drawString("Press space to start the game", 300, 300);
    }

    if (isfalse) {
      g.setColor(Color.red);
      g.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
      g.drawString("Failure, press space to restart", 300, 300);
    }
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();
    if (keyCode == KeyEvent.VK_SPACE) {
      if (isfalse) {
        isfalse = false;
        init();
      } else {
        isStart = !isStart;
      }
      repaint();
    }
    if (keyCode == KeyEvent.VK_UP) {
      if (direction != "D") {
        direction = "U";
        repaint();
      }
    }
    if (keyCode == KeyEvent.VK_LEFT) {
      if (direction != "R") {
        direction = "L";
        repaint();
      }
    }
    if (keyCode == KeyEvent.VK_DOWN) {
      if (direction != "U") {
        direction = "D";
        repaint();
      }
    }
    if (keyCode == KeyEvent.VK_RIGHT) {
      if (direction != "L") {
        direction = "R";
        repaint();
      }
    }
  }

}
