package at.ac.univie.FiWi.LiM.model;

public class PricePath {

  private Double[] prices;

  public PricePath(int steps) {
    this.prices = new Double[steps+1];
  }

  public void addPath(int time, double price) {
    this.prices[time] = price;
  }

  public double getPrice(int time) {
    return this.prices[time];
  }

  public double getMaturityPrice() {
    return prices[prices.length-1];
  }

  public double getMaxPrice() {

    double max = Double.MIN_VALUE;
    for (Double price : prices)
      if (price > max)
        max = price;

    return max;
  }

  public double getMinPrice() {

    double min = Double.MAX_VALUE;
    for (Double price : prices)
      if (price < min)
        min = price;

    return min;
  }

  public int getPathLength() {
    return prices.length;
  }
}
