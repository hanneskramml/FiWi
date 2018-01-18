package at.ac.univie.FiWi.LiM.view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar {

  public static final String MENU_ITEM_QUIT = "Quit Application";
  public static final String MENU_ITEM_PRICEPATH_GRAPH = "Show Price Paths";


  public MenuBar(ActionListener actionListener) {
    super();

    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    menuBar.add(fileMenu);

    //fileMenu.addSeparator();
    JMenuItem closeItem = new JMenuItem(MENU_ITEM_QUIT);
    closeItem.addActionListener(actionListener);
    fileMenu.add(closeItem);

    JMenu chartMenu = new JMenu("Chart");
    menuBar.add(chartMenu);

    JMenuItem pricePathItem = new JMenuItem(MENU_ITEM_PRICEPATH_GRAPH);
    pricePathItem.addActionListener(actionListener);
    chartMenu.add(pricePathItem);

    this.add(menuBar);
  }
}
