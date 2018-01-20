package at.ac.univie.FiWi.LiM.model.options;

import at.ac.univie.FiWi.LiM.model.Option;
import at.ac.univie.FiWi.LiM.model.PricePath;

public class EuropeanOption extends Option {

  public EuropeanOption(Type optionType, double maturity) {
    this(optionType, 0, 0, maturity, 0, 0);
  }

  public EuropeanOption(Type optionType, double optionPrice, double strikePrice, double maturity, double volatility, double riskFreeRate) {
    super(optionType, optionPrice, strikePrice, maturity, volatility, riskFreeRate, 1);
  }

  @Override
  public double getPayoff(PricePath pricePath) {

    double exp = Math.exp(-this.getRiskFreeRate() * this.getMaturity());
    double underlyingMarketValue = pricePath.getMaturityPrice();

    if (this.getOptionType().equals(Type.CALL))
      return exp * Math.max(underlyingMarketValue - this.getStrikePrice(), 0);

    else if (this.getOptionType().equals(Type.PUT))
      return exp * Math.max(this.getStrikePrice() - underlyingMarketValue, 0);

    else
      return 0;
  }
}
