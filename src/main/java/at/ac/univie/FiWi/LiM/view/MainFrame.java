package at.ac.univie.FiWi.LiM.view;

import at.ac.univie.FiWi.LiM.controller.AppController;

import javax.swing.*;

public class MainFrame extends JFrame {

  public MainFrame() {
    AppController appController = new AppController();

    MenuBar menuBar = new MenuBar(appController);
    this.setJMenuBar(menuBar);
    this.setTitle("LiM Option Pricing");
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }
}
