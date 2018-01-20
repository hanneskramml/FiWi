package at.ac.univie.FiWi.LiM.model.options;

import at.ac.univie.FiWi.LiM.model.Option;
import at.ac.univie.FiWi.LiM.model.PricePath;

public class AmericanOption extends Option {

  public AmericanOption(Type optionType, int steps) {
    super(optionType, 0, 0, 0, 0, 0, steps);
  }

  public AmericanOption(Type optionType, double optionPrice, double strikePrice, double maturity, double volatility, double riskFreeRate) {
    super(optionType, optionPrice, strikePrice, maturity, volatility, riskFreeRate, (int) (maturity * BANK_DAYS_PER_YEAR));
  }

  @Override
  public double getPayoff(PricePath pricePath) {

    if (this.getOptionType().equals(Type.CALL))
      return Math.exp(-this.getRiskFreeRate() * pricePath.getMaxPriceStrikeTime()) * Math.max(pricePath.getMaxPrice() - this.getStrikePrice(), 0);

    else if (this.getOptionType().equals(Type.PUT)) {
      return Math.exp(-this.getRiskFreeRate() * pricePath.getMinPriceStrikeTime()) * Math.max(this.getStrikePrice() - pricePath.getMinPrice(), 0);
    }
    else
      return 0;  }
}
