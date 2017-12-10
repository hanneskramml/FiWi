package at.ac.univie.FiWi.LiM.model;

public class PutOption extends Option {

  public PutOption(double optionPrice, double strikePrice, double maturity, double volatility, double riskFreeRate) {
    super(optionPrice, strikePrice, maturity, volatility, riskFreeRate);
  }

  @Override
  public double getPayoff(double underlyingMarketValue) {
    return Math.max(this.getStrikePrice() - underlyingMarketValue, 0);
  }
}
