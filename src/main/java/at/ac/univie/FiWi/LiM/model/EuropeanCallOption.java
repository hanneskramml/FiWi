package at.ac.univie.FiWi.LiM.model;

public class EuropeanCallOption extends Option {

  public EuropeanCallOption(double initialStockPrice, double maturity, double strikePrice) {
    super(initialStockPrice, maturity, strikePrice);
  }

  @Override
  public double getPayoff(double underlyingMarketValue) {
    return Math.max(underlyingMarketValue - this.getStrikePrice(), 0);
  }
}
