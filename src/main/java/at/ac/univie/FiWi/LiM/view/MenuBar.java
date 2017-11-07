package at.ac.univie.FiWi.LiM.view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar {

  public static final String MENU_ITEM_QUIT = "Programm beenden";

  public MenuBar(ActionListener actionListener) {
    super();

    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("Datei");
    menuBar.add(fileMenu);

    fileMenu.addSeparator();

    JMenuItem closeItem = new JMenuItem(MENU_ITEM_QUIT);
    closeItem.addActionListener(actionListener);
    fileMenu.add(closeItem);

    this.add(menuBar);
  }
}
