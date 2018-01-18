package at.ac.univie.FiWi.LiM.view;

import at.ac.univie.FiWi.LiM.model.Chart;
import at.ac.univie.FiWi.LiM.model.PricePath;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.Vector;

public class ChartFrame extends JFrame {

  public ChartFrame(Chart chart) {
    super(chart.getType());
    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    JFreeChart jFreeChart;
    if (chart.getType().equals(Chart.PRICE_PATHS))
      jFreeChart = createPricePathChart(chart.getOption().getPricePaths());
    else
      jFreeChart = null;

    ChartPanel chartPanel = new ChartPanel(jFreeChart);
    this.setContentPane(chartPanel);
    this.pack();
  }

  private JFreeChart createPricePathChart(Vector<PricePath> pricePaths) {

    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    for (int i = pricePaths.size() - 100; i < pricePaths.size(); i++)
      for (int j = 0; j < pricePaths.get(i).getPathLength(); j++)
        dataset.addValue((Number) pricePaths.get(i).getPrice(j), "PricePath " + i, j);

    return ChartFactory.createLineChart("Last 100 Price Paths", "Time/Step", "Price", dataset, PlotOrientation.VERTICAL, false, true, false);
  }
}
