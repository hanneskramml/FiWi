package at.ac.univie.FiWi.LiM.service;

import at.ac.univie.FiWi.LiM.model.Option;
import at.ac.univie.FiWi.LiM.model.PricePath;
import at.ac.univie.FiWi.LiM.model.Simulation;

import java.util.Random;

public class MonteCarloSimulation {

  private static final int DEFAULT_NUM_OF_SIMULATIONS = 10000;

  public static Simulation runSimulation(Option option) {
    return runSimulation(option, DEFAULT_NUM_OF_SIMULATIONS);
  }

  public static Simulation runSimulation(Option option, int numOfSimulations) {
    Simulation simulation = new Simulation(option, numOfSimulations);

    for (int i = 0; i < numOfSimulations; i++) {
      PricePath pricePath = calcuatePricePath(option);
      simulation.addPricePath(pricePath);
      simulation.addPayoff(option.getPayoff(pricePath));
    }

    return simulation;
  }

  private static PricePath calcuatePricePath(Option option) {

    Random random = new Random();
    PricePath pricePath = new PricePath();

    double dispersion = option.getVolatility();       //volatility of the underlying (sigma)
    double variance = dispersion * dispersion;
    double expectedValue = option.getRiskFreeRate();  //option drift - in case of risk-neutral measure equals to risk free rate
    double dt = option.getMaturity() / option.getSteps();   //time delta: runtime in years / num of steps depending on bank days
    double marketValue = option.getOptionPrice();

    for (int i = 0; i <= option.getSteps(); i++) {
      pricePath.addPath(dt * i, marketValue);
      marketValue *= Math.exp((expectedValue - variance * 0.5) * dt + dispersion * Math.sqrt(dt) * random.nextGaussian());
    }

    return pricePath;
  }
}
