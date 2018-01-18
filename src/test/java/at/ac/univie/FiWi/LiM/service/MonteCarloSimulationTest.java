package at.ac.univie.FiWi.LiM.service;

import at.ac.univie.FiWi.LiM.model.EuropeanOption;
import at.ac.univie.FiWi.LiM.model.LookbackOption;
import at.ac.univie.FiWi.LiM.model.Option;
import org.junit.Test;

public class MonteCarloSimulationTest {

  private static final double OPTION_PRICE = 100;
  private static final double STRIKE_PRICE = 100;
  private static final double MATURITY = 1;
  private static final double VOLATILITY = 0.2;
  private static final double RISK_FREE_RATE = 0.05;

  @Test
  public void runSimulationForEuropeanOption() throws Exception {
    Option callOption = new EuropeanOption(Option.Type.CALL, OPTION_PRICE, STRIKE_PRICE,  MATURITY,  VOLATILITY,  RISK_FREE_RATE);
    System.out.println("European Call Price: " + MonteCarloSimulation.runSimulation(callOption));

    Option putOption = new EuropeanOption(Option.Type.PUT, OPTION_PRICE, STRIKE_PRICE,  MATURITY,  VOLATILITY,  RISK_FREE_RATE);
    System.out.println("European Put Price: " + MonteCarloSimulation.runSimulation(putOption));
  }

  @Test
  public void runSimulationForLookbackOption() throws Exception {
    Option floatCallOption = new LookbackOption(Option.Type.CALL, OPTION_PRICE, STRIKE_PRICE,  MATURITY,  VOLATILITY, RISK_FREE_RATE, LookbackOption.LookbackType.FLOATING);
    System.out.println("Lookback (floating-strike) Call Price: " + MonteCarloSimulation.runSimulation(floatCallOption));

    Option floatPutOption = new LookbackOption(Option.Type.PUT, OPTION_PRICE, STRIKE_PRICE,  MATURITY,  VOLATILITY, RISK_FREE_RATE, LookbackOption.LookbackType.FLOATING);
    System.out.println("Lookback (floating-strike) Put Price: " + MonteCarloSimulation.runSimulation(floatPutOption));

    Option fixedCallOption = new LookbackOption(Option.Type.CALL, OPTION_PRICE, STRIKE_PRICE, MATURITY,  VOLATILITY, RISK_FREE_RATE, LookbackOption.LookbackType.FIXED);
    System.out.println("Lookback (fixed-strike) Call Price: " + MonteCarloSimulation.runSimulation(fixedCallOption));

    Option fixedPutOption = new LookbackOption(Option.Type.PUT, OPTION_PRICE, STRIKE_PRICE,  MATURITY,  VOLATILITY, RISK_FREE_RATE, LookbackOption.LookbackType.FIXED);
    System.out.println("Lookback (fixed-strike) Put Price: " + MonteCarloSimulation.runSimulation(fixedPutOption));

  }
}