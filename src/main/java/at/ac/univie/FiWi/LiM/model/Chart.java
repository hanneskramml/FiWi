package at.ac.univie.FiWi.LiM.model;

public class Chart {

  public static final String PRICE_PATHS = "Price Paths";
  public static final String OPTION_PRICING_ABUNDANCE = "Option Pricing Abundance";

  private String type;
  private Simulation simulation;

  public Chart(String type, Simulation simulation) {
    this.type = type;
    this.simulation = simulation;
  }

  public String getType() {
    return type;
  }

  public Simulation getSimulation() {
    return simulation;
  }
}
