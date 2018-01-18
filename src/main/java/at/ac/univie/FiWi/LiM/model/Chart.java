package at.ac.univie.FiWi.LiM.model;

public class Chart {

  public static final String PRICE_PATHS = "Price Paths";
  private String type;
  private Option option;

  public Chart(String type, Option option) {
    this.type = type;
    this.option = option;
  }

  public String getType() {
    return type;
  }

  public Option getOption() {
    return option;
  }
}
