package at.ac.univie.FiWi.LiM.view;

import at.ac.univie.FiWi.LiM.controller.AppController;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

	public static final String BUTTON_CALCULATE = "Option Pricing";
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

		JPanel optionTypePanel = new JPanel(new GridLayout(1,0));
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

		JPanel optionStylePanel = new JPanel(new GridLayout(1,0));
		optionStylePanel.add(optionStyleEuropeanRadio);
		optionStylePanel.add(optionStyleAmericanRadio);
		optionStylePanel.add(optionStyleLookbackFloatingRadio);
		optionStylePanel.add(optionStyleLookbackFixedRadio);

		JPanel radioButtonPanel = new JPanel(new BorderLayout());
		radioButtonPanel.add(optionTypePanel, BorderLayout.NORTH);
		radioButtonPanel.add(optionStylePanel, BorderLayout.SOUTH);
		this.add(radioButtonPanel, BorderLayout.NORTH);



		//JPanel labelPanel = new JPanel();
    JPanel dataPanel = new JPanel();
    JPanel panel = new JPanel(new BorderLayout());

		JButton button = new JButton(BUTTON_CALCULATE);
		button.addActionListener (appController);
    InitNumberSpinners(dataPanel);
    dataPanel.add(button);

		JLabel optionPricingLabel = new JLabel("Option Pricing:");
		optionPricingField = new JTextField();
		dataPanel.add(optionPricingLabel);
		dataPanel.add(optionPricingField);

    //labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
    dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));
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
	  label4.setText("Volatility:");
	  dispersionSpinner = new JSpinner(new SpinnerNumberModel(0.2, 0, 10, 0.1));
	  JLabel label6 = new JLabel();
	  label6.setText("Number of Simulations:");
	  numOfSimulationsSpinner = new JSpinner(new SpinnerNumberModel(10000, 0, 100000000, 1));
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
