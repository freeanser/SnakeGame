import javax.swing.*;

public class StartGame {
  public static void main(String[] args) {
    // Create a new instance of JFrame
    JFrame jFrame = new JFrame();

    // Set the bounds (x, y, width, height) of the JFrame
    jFrame.setBounds(10, 10, 900, 720);

    // Make the JFrame non-resizable
    jFrame.setResizable(false);

    // Set the default close operation of the JFrame to exit on close
    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    // Add a new instance of GamePanel to the JFrame
    jFrame.add(new GamePanel());

    // Make the JFrame visible
    jFrame.setVisible(true);
  }
}
