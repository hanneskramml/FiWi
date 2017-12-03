package at.ac.univie.FiWi.LiM.model;

public class EuropeanPutOption extends Option {

  public EuropeanPutOption(double initialStockPrice, double maturity, double strikePrice) {
    super(initialStockPrice, maturity, strikePrice);
  }

  @Override
  public double getPayoff(double underlyingMarketValue) {
    return Math.max(this.getStrikePrice() - underlyingMarketValue, 0);
  }
}
