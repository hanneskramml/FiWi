package at.ac.univie.FiWi.LiM.model;

import java.util.Vector;

public abstract class Option {

  protected static final int BANK_DAYS_PER_YEAR = 250;
  public enum Type {CALL, PUT}

  private Type optionType;
  private double optionPrice;
  private double strikePrice;
  private double maturity;
  private double volatility;
  private double riskFreeRate;
  private Vector<PricePath> pricePaths;
  private int steps;

  public Option(Type optionType, double optionPrice, double strikePrice, double maturity, double volatility, double riskFreeRate, int steps) {
    this.optionType = optionType;
    this.optionPrice = optionPrice;
    this.strikePrice = strikePrice;
    this.maturity = maturity;
    this.volatility = volatility;
    this.riskFreeRate = riskFreeRate;
    this.pricePaths = new Vector<>();
    this.steps = steps;
  }

  public Type getOptionType() {
    return optionType;
  }

  public double getOptionPrice() {
    return optionPrice;
  }

  public double getStrikePrice() {
    return strikePrice;
  }

  public double getMaturity() {
    return maturity;
  }

  public double getVolatility() {
    return volatility;
  }

  public double getRiskFreeRate() {
    return riskFreeRate;
  }

  public void setOptionPrice(double optionPrice) {
    this.optionPrice = optionPrice;
  }

  public void setStrikePrice(double strikePrice) {
    this.strikePrice = strikePrice;
  }

  public void setVolatility(double volatility) {
    this.volatility = volatility;
  }

  public void setRiskFreeRate(double riskFreeRate) {
    this.riskFreeRate = riskFreeRate;
  }

  public void addPricePath(PricePath pricePath) {
    this.pricePaths.add(pricePath);
  }

  public Vector<PricePath> getPricePaths() {
    return pricePaths;
  }

  public int getSteps() {
    return steps;
  }

  public abstract double getPayoff(PricePath pricePath);
}
