package at.ac.univie.FiWi.LiM;

import at.ac.univie.FiWi.LiM.view.MainFrame;
import javax.swing.*;

public class App {

  /**
   * Create and display the main GUI
   */
  private static void createAndShowGUI() {

    MainFrame mainFrame = new MainFrame();
    mainFrame.pack();
    mainFrame.setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }
}
