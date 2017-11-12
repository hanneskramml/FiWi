package at.ac.univie.FiWi.LiM.model;

public abstract class Option {

  private double initialStockPrice;
  private double maturity;
  private double strikePrice;

  public Option(double initialStockPrice, double maturity, double strikePrice) {
    this.initialStockPrice = initialStockPrice;
    this.maturity = maturity;
    this.strikePrice = strikePrice;
  }

  public double getInitialStockPrice() {
    return initialStockPrice;
  }

  public void setInitialStockPrice(double initialStockPrice) {
    this.initialStockPrice = initialStockPrice;
  }

  public double getMaturity() {
    return maturity;
  }

  public void setMaturity(double maturity) {
    this.maturity = maturity;
  }

  public double getStrikePrice() {
    return strikePrice;
  }

  public void setStrikePrice(double strikePrice) {
    this.strikePrice = strikePrice;
  }

  public abstract double getPayoff(double underlyingMarketValue);
}
