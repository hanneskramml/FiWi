package at.ac.univie.FiWi.LiM.model;

public class EuropeanPutOption extends Option {

  public EuropeanPutOption(double optionPrice, double strikePrice, double maturity, double volatility, double riskFreeRate) {
    super(optionPrice, strikePrice, maturity, volatility, riskFreeRate);
  }

  @Override
  public double getPayoff(double underlyingMarketValue) {
    return Math.max(this.getStrikePrice() - underlyingMarketValue, 0);
  }
}
