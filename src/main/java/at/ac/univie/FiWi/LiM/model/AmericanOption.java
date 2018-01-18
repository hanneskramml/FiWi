package at.ac.univie.FiWi.LiM.model;

public class AmericanOption extends Option {

  public AmericanOption(Type optionType, int steps) {
    super(optionType, 0, 0, 0, 0, 0, steps);
  }

  public AmericanOption(Type optionType, double optionPrice, double strikePrice, double maturity, double volatility, double riskFreeRate) {
    super(optionType, optionPrice, strikePrice, maturity, volatility, riskFreeRate, (int) (maturity * BANK_DAYS_PER_YEAR));
  }

  @Override
  public double getPayoff(PricePath pricePath) {
    return 0;
  }
}
