package at.ac.univie.FiWi.LiM.model.options;

import at.ac.univie.FiWi.LiM.model.Option;
import at.ac.univie.FiWi.LiM.model.PricePath;

public class LookbackOption extends Option {

  public enum LookbackType { FLOATING, FIXED }
  private LookbackType lookbackType;

  public LookbackOption(Type optionType, double maturity, LookbackType lookbackType) {
    this(optionType, 0, 0, maturity, 0, 0, lookbackType);
  }

  public LookbackOption(Type optionType, double optionPrice, double strikePrice, double maturity, double volatility, double riskFreeRate, LookbackType lookbackType) {
    super(optionType, optionPrice, strikePrice, maturity, volatility, riskFreeRate, (int) (maturity * BANK_DAYS_PER_YEAR));
    this.lookbackType = lookbackType;
  }

  @Override
  public double getPayoff(PricePath pricePath) {

    double exp = Math.exp(-this.getRiskFreeRate() * this.getMaturity());

    if (lookbackType.equals(LookbackType.FLOATING)) {

      if (this.getOptionType().equals(Type.CALL))
        return exp * Math.max(pricePath.getMaturityPrice() - pricePath.getMinPrice(), 0);

      else if (this.getOptionType().equals(Type.PUT))
        return exp * Math.max(pricePath.getMaxPrice() - pricePath.getMaturityPrice(), 0);

    } else if (lookbackType.equals(LookbackType.FIXED)) {

      if (this.getOptionType().equals(Type.CALL))
        return exp * Math.max(pricePath.getMaxPrice() - this.getStrikePrice(), 0);

      else if (this.getOptionType().equals(Type.PUT))
        return exp * Math.max(this.getStrikePrice() - pricePath.getMinPrice(), 0);

    }
    return 0;

  }
}
