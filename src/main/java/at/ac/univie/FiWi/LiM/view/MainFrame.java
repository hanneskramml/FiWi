package at.ac.univie.FiWi.LiM.view;

import at.ac.univie.FiWi.LiM.controller.AppController;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

	public static final String BUTTON_CALCULATE = "Calculate Option Pricing";
	public static final String RADIO_OPTIONTYPE_CALL = "Call Option";
	public static final String RADIO_OPTIONTYPE_PUT = "Put Option";
	public static final String RADIO_OPTIONSTYLE_EUROPEAN = "European";
	public static final String RADIO_OPTIONSTYLE_AMERICAN = "American";
	public static final String RADIO_OPTIONSTYLE_LOOKBACK_FLOATING = "Lookback floating-strike";
	public static final String RADIO_OPTIONSTYLE_LOOKBACK_FIXED = "Lookback fixed-strike";

	private JSpinner initialStockPriceSpinner;
	private JSpinner strikePriceSpinner;
	private JSpinner maturitySpinner;
	private JSpinner dispersionSpinner;
	private JSpinner numOfSimulationsSpinner;
	private JSpinner riskFreeRateSpinner;
	private JRadioButton optionTypeCallRadio;
	private JRadioButton optionTypePutRadio;
	private JRadioButton optionStyleEuropeanRadio;
	private JRadioButton optionStyleAmericanRadio;
	private JRadioButton optionStyleLookbackFloatingRadio;
	private JRadioButton optionStyleLookbackFixedRadio;
	private JTextField optionPricingField;

	public MainFrame() {
    AppController appController = new AppController(this);

		optionTypeCallRadio = new JRadioButton(RADIO_OPTIONTYPE_CALL);
		optionTypeCallRadio.setSelected(true);
		optionTypePutRadio = new JRadioButton(RADIO_OPTIONTYPE_PUT);

		ButtonGroup optionTypeRadioGroup = new ButtonGroup();
		optionTypeRadioGroup.add(optionTypeCallRadio);
		optionTypeRadioGroup.add(optionTypePutRadio);

		JPanel optionTypePanel = new JPanel(new GridLayout(0,1));
		optionTypePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		optionTypePanel.add(optionTypeCallRadio);
		optionTypePanel.add(optionTypePutRadio);

		optionStyleEuropeanRadio = new JRadioButton(RADIO_OPTIONSTYLE_EUROPEAN);
		optionStyleEuropeanRadio.setSelected(true);
		optionStyleAmericanRadio = new JRadioButton(RADIO_OPTIONSTYLE_AMERICAN);
		optionStyleLookbackFloatingRadio = new JRadioButton(RADIO_OPTIONSTYLE_LOOKBACK_FLOATING);
		optionStyleLookbackFixedRadio = new JRadioButton(RADIO_OPTIONSTYLE_LOOKBACK_FIXED);

		ButtonGroup optionStyleGroup = new ButtonGroup();
		optionStyleGroup.add(optionStyleEuropeanRadio);
		optionStyleGroup.add(optionStyleAmericanRadio);
		optionStyleGroup.add(optionStyleLookbackFloatingRadio);
		optionStyleGroup.add(optionStyleLookbackFixedRadio);

		JPanel optionStylePanel = new JPanel(new GridLayout(0,1));
		optionStylePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		optionStylePanel.add(optionStyleEuropeanRadio);
		optionStylePanel.add(optionStyleAmericanRadio);
		optionStylePanel.add(optionStyleLookbackFloatingRadio);
		optionStylePanel.add(optionStyleLookbackFixedRadio);

		JPanel radioButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		radioButtonPanel.setLayout(new BoxLayout(radioButtonPanel, BoxLayout.Y_AXIS));
		radioButtonPanel.add(optionTypePanel, BorderLayout.NORTH);
		radioButtonPanel.add(optionStylePanel);
		this.add(radioButtonPanel, BorderLayout.EAST);



		//JPanel labelPanel = new JPanel();
    JPanel dataPanel = new JPanel(new GridLayout(0,2));
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

	JButton button = new JButton(BUTTON_CALCULATE);
	button.addActionListener (appController);
    InitNumberSpinners(dataPanel);
	JLabel emptyLabel1 = new JLabel(" ", SwingConstants.LEFT);
	dataPanel.add(emptyLabel1);
	JLabel emptyLabel2 = new JLabel(" ", SwingConstants.LEFT);
	dataPanel.add(emptyLabel2);
	JLabel emptyLabel3 = new JLabel(" ", SwingConstants.LEFT);
	dataPanel.add(emptyLabel3);
    dataPanel.add(button);
	JLabel emptyLabel4 = new JLabel(" ", SwingConstants.LEFT);
	dataPanel.add(emptyLabel4);
	JLabel emptyLabel5 = new JLabel(" ", SwingConstants.LEFT);
	dataPanel.add(emptyLabel5);
		JLabel optionPricingLabel = new JLabel("Option Pricing result:", SwingConstants.LEFT);
		optionPricingField = new JTextField();
		dataPanel.add(optionPricingLabel);
		dataPanel.add(optionPricingField);

    //labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
    //panel.add(labelPanel, BorderLayout.WEST);
    panel.add(dataPanel,  BorderLayout.WEST);
    this.add(panel);



    MenuBar menuBar = new MenuBar(appController);
    this.setJMenuBar(menuBar);
    this.setTitle("LiM Option Pricing");
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }
  
  public void InitNumberSpinners(JPanel panel)
  {
	  JLabel label1 = new JLabel("Initial Stock Value:", SwingConstants.LEFT);
	  initialStockPriceSpinner = new JSpinner(new SpinnerNumberModel(100, 0, 10000000, 0.1));
	  JLabel label2 = new JLabel("Strike Price:", SwingConstants.LEFT);
	  strikePriceSpinner = new JSpinner(new SpinnerNumberModel(100, 0, 10000000, 0.1));
	  JLabel label3 = new JLabel("Maturity:", SwingConstants.LEFT);
	  maturitySpinner = new JSpinner(new SpinnerNumberModel(1, 0, 10, 0.1));    
	  JLabel label4 = new JLabel("Volatility:", SwingConstants.LEFT);
	  dispersionSpinner = new JSpinner(new SpinnerNumberModel(0.2, 0, 10, 0.1));
	  JLabel label6 = new JLabel("Number of Simulations:", SwingConstants.LEFT);
	  numOfSimulationsSpinner = new JSpinner(new SpinnerNumberModel(10000, 0, 100000000, 1));
	  JLabel label7 = new JLabel("Risk-free rate:", SwingConstants.LEFT);
	  riskFreeRateSpinner = new JSpinner(new SpinnerNumberModel(0.05, 0, 10, 0.1));  
	  panel.add(label1);
	  panel.add(initialStockPriceSpinner);
	  panel.add(label2);
	  panel.add(strikePriceSpinner);
	  panel.add(label3);
	  panel.add(maturitySpinner);
	  panel.add(label4);
	  panel.add(dispersionSpinner);
	  panel.add(label6);
	  panel.add(numOfSimulationsSpinner);
	  panel.add(label7);
	  panel.add(riskFreeRateSpinner);
  }

	public double getOptionPrice() {
		return (double) initialStockPriceSpinner.getValue();
	}

	public double getStrikePrice() {
		return (double) strikePriceSpinner.getValue();
	}

	public double getMaturity() {
		return (double) maturitySpinner.getValue();
	}

	public double getVolatility() {
		return (double) dispersionSpinner.getValue();
	}

	public int getNumOfSimulations() {
		return (int) numOfSimulationsSpinner.getValue();
	}

	public double getRiskFreeRate() {
		return (double) riskFreeRateSpinner.getValue();
	}

	public boolean isRadioButtonSelected(String radioButton) {
		if (RADIO_OPTIONTYPE_CALL.equals(radioButton))
			return optionTypeCallRadio.isSelected();
		else if (RADIO_OPTIONTYPE_PUT.equals(radioButton))
			return optionTypePutRadio.isSelected();
		else if (RADIO_OPTIONSTYLE_EUROPEAN.equals(radioButton))
			return optionStyleEuropeanRadio.isSelected();
		else if (RADIO_OPTIONSTYLE_AMERICAN.equals(radioButton))
			return optionStyleAmericanRadio.isSelected();
		else if (RADIO_OPTIONSTYLE_LOOKBACK_FLOATING.equals(radioButton))
			return optionStyleLookbackFloatingRadio.isSelected();
		else if (RADIO_OPTIONSTYLE_LOOKBACK_FIXED.equals(radioButton))
			return optionStyleLookbackFixedRadio.isSelected();
		else
			return false;
	}

	public void setOptionPricingValue(double value) {
		optionPricingField.setText(String.valueOf(value));
	}

}
