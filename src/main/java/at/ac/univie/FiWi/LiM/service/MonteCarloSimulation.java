package at.ac.univie.FiWi.LiM.service;

import at.ac.univie.FiWi.LiM.model.Option;

import java.util.Random;

public class MonteCarloSimulation {

  public static int NUM_OF_SIMULATIONS = 1000000;
  public static double EXPECTED_VALUE = 0;
  public static double DISPERSION = 0.2;
  public static double VARIANCE = DISPERSION * DISPERSION;
  public static double RISK_FREE_RATE = 0.05;
  public static double EXPIRY_TIME = 1;

  public static double runSimulation(Option option) {

    double payoff = 0;
    int i = 0;

    for (; i < NUM_OF_SIMULATIONS; i++) {
      double result = calculateMarketValue(option.getInitialStockPrice(), option.getMaturity(), 1);
      payoff += option.getPayoff(result);
    }

    return payoff / Math.exp(-RISK_FREE_RATE * option.getMaturity()) * NUM_OF_SIMULATIONS;
  }

  private static double calculateMarketValue(double initialStockPrice, double maturity, int steps) {
    Random random = new Random();

    if (steps == 0)
      return initialStockPrice;
    else
     return calculateMarketValue(initialStockPrice, maturity, steps-1) * Math.exp((EXPECTED_VALUE - VARIANCE * EXPIRY_TIME) * maturity / steps + DISPERSION * Math.sqrt(maturity / steps) * random.nextGaussian());
  }
}
