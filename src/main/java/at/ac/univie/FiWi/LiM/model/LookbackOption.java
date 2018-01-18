package at.ac.univie.FiWi.LiM.model;

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

    if (lookbackType.equals(LookbackType.FLOATING)) {

      if (this.getOptionType().equals(Type.CALL))
        return pricePath.getMaturityPrice() - pricePath.getMinPrice();

      else if (this.getOptionType().equals(Type.PUT))
        return pricePath.getMaxPrice() - pricePath.getMaturityPrice();

    } else if (lookbackType.equals(LookbackType.FIXED)) {

      if (this.getOptionType().equals(Type.CALL))
        return Math.max(pricePath.getMaxPrice() - this.getStrikePrice(), 0);

      else if (this.getOptionType().equals(Type.PUT))
        return Math.max(this.getStrikePrice() - pricePath.getMinPrice(), 0);

    }
    return 0;

  }
}
