package at.ac.univie.FiWi.LiM.view;

import at.ac.univie.FiWi.LiM.model.Chart;
import at.ac.univie.FiWi.LiM.model.PricePath;
import at.ac.univie.FiWi.LiM.model.Simulation;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.util.Vector;

public class ChartFrame extends JFrame {

  public ChartFrame(Chart chart) {
    super(chart.getType());
    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    JFreeChart jFreeChart;
    if (chart.getType().equals(Chart.PRICE_PATHS))
      jFreeChart = createPricePathChart(chart.getSimulation().getPricePaths());
    else if (chart.getType().equals(Chart.OPTION_PRICING_ABUNDANCE))
      jFreeChart = createOptionPricingAbundanceChart(chart.getSimulation());
    else
      jFreeChart = null;

    ChartPanel chartPanel = new ChartPanel(jFreeChart);
    this.setContentPane(chartPanel);
    this.pack();
  }

  private JFreeChart createPricePathChart(Vector<PricePath> pricePaths) {

    XYSeriesCollection seriesCollection = new XYSeriesCollection();

    for (int i = pricePaths.size() - 100; i < pricePaths.size(); i++) {
      XYSeries series = new XYSeries("PricePath " + i);
      seriesCollection.addSeries(series);

      for (int j = 0; j < pricePaths.get(i).getPathLength(); j++)
        series.add(pricePaths.get(i).getTime(j), pricePaths.get(i).getPrice(j));
    }

    return ChartFactory.createXYLineChart("Last 100 Price Paths", "Year(s)", "Asset Price (S)", seriesCollection, PlotOrientation.VERTICAL, false, true, false);
  }

  private JFreeChart createOptionPricingAbundanceChart(Simulation simulation) {

    double[] payoffs = simulation.getPayoffs().stream().mapToDouble(Double::doubleValue).toArray();

    HistogramDataset histogramDataset = new HistogramDataset();
    histogramDataset.setType(HistogramType.FREQUENCY);
    histogramDataset.addSeries("Option Price Simulations", payoffs, 50);

    return ChartFactory.createHistogram("Option Pricing Abundance (N=" + simulation.getNumOfSimulations() + ")", "Option Payoff (Price)", "Abundance (Count)", histogramDataset, PlotOrientation.VERTICAL, false, true, false);
  }
}
