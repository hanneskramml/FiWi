package at.ac.univie.FiWi.LiM.model;

import java.util.Vector;

public class Simulation {

  private int numOfSimulations;
  private Option option;
  private Vector<PricePath> pricePaths;
  private Vector<Double> payoffs;

  public Simulation(Option option, int numOfSimulations) {
    this.option = option;
    this.numOfSimulations = numOfSimulations;
    this.pricePaths = new Vector<>();
    this.payoffs = new Vector<>();
  }

  public void addPayoff(double payoff) {
    payoffs.add(payoff);
  }

  public Vector<Double> getPayoffs() {
    return payoffs;
  }

  public void addPricePath(PricePath pricePath) {
    pricePaths.add(pricePath);
  }

  public Vector<PricePath> getPricePaths() {
    return pricePaths;
  }

  public double getTotalPayoff() {
    return payoffs.stream().mapToDouble(Double::doubleValue).sum();
  }

  public double getOptionValue() {
    return getTotalPayoff() / numOfSimulations;
  }

  public int getNumOfSimulations() {
    return numOfSimulations;
  }
}
