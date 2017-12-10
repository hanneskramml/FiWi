package at.ac.univie.FiWi.LiM.model;

public class EuropeanCallOption extends Option {

  public EuropeanCallOption(double optionPrice, double strikePrice, double maturity, double volatility, double riskFreeRate) {
    super(optionPrice, strikePrice, maturity, volatility, riskFreeRate);
  }

  @Override
  public double getPayoff(double underlyingMarketValue) {
    return Math.max(underlyingMarketValue - this.getStrikePrice(), 0);
  }
}
