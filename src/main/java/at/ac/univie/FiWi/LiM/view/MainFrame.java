package at.ac.univie.FiWi.LiM.view;

import at.ac.univie.FiWi.LiM.controller.AppController;
import at.ac.univie.FiWi.LiM.model.EuropeanCallOption;
import at.ac.univie.FiWi.LiM.model.EuropeanPutOption;
import at.ac.univie.FiWi.LiM.service.MonteCarloSimulation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
	
	private JSpinner initialStockPriceSpinner;
	private JSpinner strikePriceSpinner;
	private JSpinner maturitySpinner;
	private JSpinner dispersionSpinner;
	private JSpinner expiryTimeSpinner;
	private JSpinner numOfSimulationsSpinner;
	private JSpinner riskFreeRateSpinner;
	
  public MainFrame() {
    AppController appController = new AppController();

    JPanel labelPanel = new JPanel();
    JPanel dataPanel = new JPanel();
    JPanel panel = new JPanel(new BorderLayout());
    JButton button = new JButton("European option pricing");
    JLabel labelEuropeanCall = new JLabel();
    JLabel labelEuropeanPut = new JLabel();
    labelEuropeanCall.setText("European Option Call Value: ");
    labelEuropeanPut.setText("European Option Put Value: ");
    button.addActionListener (new ActionListener() {
  	  @Override
  	  public void actionPerformed(ActionEvent e) {
  	    if(e.getActionCommand().equals("europeanOption"))
  	    {
  	      double optionPrice = (double) initialStockPriceSpinner.getValue();
  	      double maturity = (double) maturitySpinner.getValue();
  	      double strikePrice = (double) strikePriceSpinner.getValue();
  	      double volatility = (double) dispersionSpinner.getValue();
  	      double riskFreeRate = (double) riskFreeRateSpinner.getValue();
  	      int numOfSimulations = (int) numOfSimulationsSpinner.getValue();
  	      double callValue = MonteCarloSimulation.runSimulation(new EuropeanCallOption(optionPrice,strikePrice,maturity,volatility,riskFreeRate), numOfSimulations);
  	      double putValue = MonteCarloSimulation.runSimulation(new EuropeanPutOption(optionPrice,strikePrice,maturity,volatility,riskFreeRate), numOfSimulations);
  	      labelEuropeanCall.setText("European Option Call Value: " + callValue);
  	      labelEuropeanPut.setText("European Option Put Value: " + putValue);
  	    }
  	  }
    });
    button.setActionCommand("europeanOption");
    InitNumberSpinners(dataPanel);
    dataPanel.add(button);
    labelPanel.add(labelEuropeanCall);
    labelPanel.add(labelEuropeanPut);

    labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
    dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));
    panel.add(labelPanel, BorderLayout.WEST);
    panel.add(dataPanel,  BorderLayout.EAST);
    this.add(panel);
    MenuBar menuBar = new MenuBar(appController);
    this.setJMenuBar(menuBar);
    this.setTitle("LiM Option Pricing");
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }
  
  public void InitNumberSpinners(JPanel panel)
  {
	  JLabel label1 = new JLabel();
	  label1.setText("Initial Stock Value:");
	  initialStockPriceSpinner = new JSpinner(new SpinnerNumberModel(100, 0, 10000000, 0.1));
	  JLabel label2 = new JLabel();
	  label2.setText("Strike Price:");
	  strikePriceSpinner = new JSpinner(new SpinnerNumberModel(100, 0, 10000000, 0.1));
	  JLabel label3 = new JLabel();
	  label3.setText("Maturity:");
	  maturitySpinner = new JSpinner(new SpinnerNumberModel(1, 0, 10, 0.1));    
	  JLabel label4 = new JLabel();
	  label4.setText("Dispersion:");
	  dispersionSpinner = new JSpinner(new SpinnerNumberModel(0.2, 0, 10, 0.1));    
	  JLabel label5 = new JLabel();
	  label5.setText("Expiry Time:");
	  expiryTimeSpinner = new JSpinner(new SpinnerNumberModel(1, 0, 10, 0.1));    
	  JLabel label6 = new JLabel();
	  label6.setText("Number of Simulations:");
	  numOfSimulationsSpinner = new JSpinner(new SpinnerNumberModel(10000000, 0, 100000000, 1)); 
	  JLabel label7 = new JLabel();
	  label7.setText("Risk-free rate:");   
	  riskFreeRateSpinner = new JSpinner(new SpinnerNumberModel(0.05, 0, 10, 0.1));  
	  panel.add(label1);
	  panel.add(initialStockPriceSpinner);
	  panel.add(label2);
	  panel.add(strikePriceSpinner);
	  panel.add(label3);
	  panel.add(maturitySpinner);
	  panel.add(label4);
	  panel.add(dispersionSpinner);
	  panel.add(label5);
	  panel.add(expiryTimeSpinner);
	  panel.add(label6);
	  panel.add(numOfSimulationsSpinner);
	  panel.add(label7);
	  panel.add(riskFreeRateSpinner);
  }

}
