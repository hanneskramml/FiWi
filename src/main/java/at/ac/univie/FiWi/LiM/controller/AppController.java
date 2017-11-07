package at.ac.univie.FiWi.LiM.controller;

import at.ac.univie.FiWi.LiM.view.MenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppController implements ActionListener {
  /**
   * Invoked when an action occurs.
   *
   * @param e
   */
  @Override
  public void actionPerformed(ActionEvent e) {

    if (e.getActionCommand().equals(MenuBar.MENU_ITEM_QUIT)) {
      System.exit(0);
    }

  }
}
