package at.ac.univie.FiWi.LiM.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PricePath {

  private List<Double> times;
  private List<Double> prices;

  public PricePath() {
    times = new ArrayList<>();
    prices = new ArrayList<>();
  }

  public void addPath(double time, double price) {
    times.add(time);
    prices.add(price);
  }

  public double getPrice(int index) {
    return prices.get(index);
  }

  public double getTime(int index) {
    return times.get(index);
  }

  public double getMaturityPrice() {
    return prices.get(prices.size() - 1);
  }

  public double getMaxPrice() {
    return Collections.max(prices);
  }

  public double getMinPrice() {
    return Collections.min(prices);
  }

  public int getPathLength() {
    return prices.size();
  }

  public double getMaxPriceStrikeTime() {
    double max = Double.MIN_VALUE;
    int index = 0;

    for (int i = 0; i < prices.size(); i++)
      if (prices.get(i) > max) {
        max = prices.get(i);
        index = i;
      }

    return times.get(index);
  }

  public double getMinPriceStrikeTime() {
    double min = Double.MAX_VALUE;
    int index = 0;

    for (int i = 0; i < prices.size(); i++)
      if (prices.get(i) < min) {
        min = prices.get(i);
        index = i;
      }

    return times.get(index);
  }

}
