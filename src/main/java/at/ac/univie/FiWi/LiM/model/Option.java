package at.ac.univie.FiWi.LiM.model;

public abstract class Option {

  private double optionPrice;
  private double strikePrice;
  private double maturity;
  private double volatility;
  private double riskFreeRate;

  public Option(double optionPrice, double strikePrice, double maturity, double volatility, double riskFreeRate) {
    this.optionPrice = optionPrice;
    this.strikePrice = strikePrice;
    this.maturity = maturity;
    this.volatility = volatility;
    this.riskFreeRate = riskFreeRate;
  }

  public double getOptionPrice() {
    return optionPrice;
  }

  public void setOptionPrice(double optionPrice) {
    this.optionPrice = optionPrice;
  }

  public double getStrikePrice() {
    return strikePrice;
  }

  public void setStrikePrice(double strikePrice) {
    this.strikePrice = strikePrice;
  }

  public double getMaturity() {
    return maturity;
  }

  public void setMaturity(double maturity) {
    this.maturity = maturity;
  }

  public double getVolatility() {
    return volatility;
  }

  public void setVolatility(double volatility) {
    this.volatility = volatility;
  }

  public double getRiskFreeRate() {
    return riskFreeRate;
  }

  public void setRiskFreeRate(double riskFreeRate) {
    this.riskFreeRate = riskFreeRate;
  }

  public abstract double getPayoff(double underlyingMarketValue);
}
