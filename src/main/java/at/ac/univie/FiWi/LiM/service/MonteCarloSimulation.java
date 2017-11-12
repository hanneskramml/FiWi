package at.ac.univie.FiWi.LiM.service;

import at.ac.univie.FiWi.LiM.model.Option;

import java.util.Random;

public class MonteCarloSimulation {

  public static final int NUM_OF_SIMULATIONS = 1000000;
  public static final double EXPECTED_VALUE = 0;
  public static final double DISPERSION = 1;
  public static final double VARIANCE = DISPERSION * DISPERSION;
  public static final double RISK_FREE_RATE = 0.05;


  public static double runSimulation(Option option) {

    double total = 0; //TODO: define better var name
    int i = 0;

    for (; i < NUM_OF_SIMULATIONS; i++) {
      double result = calculateMarketValue(option.getInitialStockPrice(), option.getMaturity(), 1);
      total += option.getPayoff(result);
    }

    return Math.exp(-RISK_FREE_RATE * option.getMaturity()) * total / NUM_OF_SIMULATIONS;
  }

  private static double calculateMarketValue(double initialStockPrice, double maturity, int steps) {
    Random random = new Random();

    if (steps == 0)
      return initialStockPrice;
    else
     return calculateMarketValue(initialStockPrice, maturity, steps-1) * Math.exp((EXPECTED_VALUE - VARIANCE * 0.5) * maturity / steps + DISPERSION * Math.sqrt(maturity / steps) * random.nextGaussian());
  }
}
