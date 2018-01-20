package at.ac.univie.FiWi.LiM.controller;

import at.ac.univie.FiWi.LiM.model.*;
import at.ac.univie.FiWi.LiM.model.options.AmericanOption;
import at.ac.univie.FiWi.LiM.model.options.EuropeanOption;
import at.ac.univie.FiWi.LiM.model.options.LookbackOption;
import at.ac.univie.FiWi.LiM.service.MonteCarloSimulation;
import at.ac.univie.FiWi.LiM.view.ChartFrame;
import at.ac.univie.FiWi.LiM.view.MainFrame;
import at.ac.univie.FiWi.LiM.view.MenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppController implements ActionListener {

  private MainFrame view;
  private Simulation simulation;

  public AppController(MainFrame view) {
    this.view = view;
    this.simulation = null;
  }

  /**
   * Invoked when an action occurs.
   *
   * @param e
   */
  @Override
  public void actionPerformed(ActionEvent e) {

    if (e.getActionCommand().equals(MainFrame.BUTTON_CALCULATE)) {

      Option option = null;
      Option.Type optionType;
      if (view.isRadioButtonSelected(MainFrame.RADIO_OPTIONTYPE_CALL))
        optionType = Option.Type.CALL;
      else
        optionType = Option.Type.PUT;

      if (view.isRadioButtonSelected(MainFrame.RADIO_OPTIONSTYLE_EUROPEAN))
        option = new EuropeanOption(optionType, view.getOptionPrice(), view.getStrikePrice(), view.getMaturity(), view.getVolatility(), view.getRiskFreeRate());
      else if (view.isRadioButtonSelected(MainFrame.RADIO_OPTIONSTYLE_AMERICAN))
        option = new AmericanOption(optionType, view.getOptionPrice(), view.getStrikePrice(), view.getMaturity(), view.getVolatility(), view.getRiskFreeRate());
      else if (view.isRadioButtonSelected(MainFrame.RADIO_OPTIONSTYLE_LOOKBACK_FLOATING))
        option = new LookbackOption(optionType, view.getOptionPrice(), view.getStrikePrice(), view.getMaturity(), view.getVolatility(), view.getRiskFreeRate(), LookbackOption.LookbackType.FLOATING);
      else if (view.isRadioButtonSelected(MainFrame.RADIO_OPTIONSTYLE_LOOKBACK_FIXED))
        option = new LookbackOption(optionType, view.getOptionPrice(), view.getStrikePrice(), view.getMaturity(), view.getVolatility(), view.getRiskFreeRate(), LookbackOption.LookbackType.FIXED);

      simulation = MonteCarloSimulation.runSimulation(option, view.getNumOfSimulations());
      view.setOptionPricingValue(simulation.getOptionValue());


    } else if (e.getActionCommand().equals(MenuBar.MENU_ITEM_QUIT)) {
      System.exit(0);


    } else if (e.getActionCommand().equals(MenuBar.MENU_ITEM_PRICEPATH_GRAPH)) {
      Chart chart = new Chart(Chart.PRICE_PATHS, simulation);
      ChartFrame chartFrame = new ChartFrame(chart);
      chartFrame.setVisible(true);

    } else if (e.getActionCommand().equals(MenuBar.MENU_ITEM_OPTIONPRICINGABUNDANCE_GRAPH)) {
      Chart chart = new Chart(Chart.OPTION_PRICING_ABUNDANCE, simulation);
      ChartFrame chartFrame = new ChartFrame(chart);
      chartFrame.setVisible(true);
    }

  }
}
