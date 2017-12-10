package at.ac.univie.FiWi.LiM.service;

import at.ac.univie.FiWi.LiM.model.Option;

import java.util.Random;

public class MonteCarloSimulation {

  private static final int DEFAULT_NUM_OF_SIMULATIONS = 10000000;
  private static final Random random = new Random();

  public static double runSimulation(Option option) {
    return runSimulation(option, DEFAULT_NUM_OF_SIMULATIONS);
  }

  public static double runSimulation(Option option, int numOfSimulations) {
    double totalPayoff = 0;
    int i = 0;

    for (; i < numOfSimulations; i++) {
      double marketValue = calculateMarketValue(option, 1);
      totalPayoff += option.getPayoff(marketValue);
    }

    return Math.exp(-option.getRiskFreeRate() * option.getMaturity()) * totalPayoff / numOfSimulations;
  }

  private static double calculateMarketValue(Option option, int steps) {
    double optionPrice = option.getOptionPrice();
    double maturity = option.getMaturity();
    double dispersion = option.getVolatility(); //volatility of the underlying (sigma)
    double variance = dispersion * dispersion;
    double expectedValue = option.getRiskFreeRate(); //option drift - in case of risk-neutral measure equals to risk free rate

    if (steps == 0)
      return optionPrice;
    else
      return calculateMarketValue(option, steps-1) * Math.exp((expectedValue - variance * 0.5) * option.getMaturity() / steps + dispersion * Math.sqrt(maturity / steps) * random.nextGaussian());
  }
}
