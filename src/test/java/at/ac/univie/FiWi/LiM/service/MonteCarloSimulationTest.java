package at.ac.univie.FiWi.LiM.service;

import at.ac.univie.FiWi.LiM.model.CallOption;
import at.ac.univie.FiWi.LiM.model.Option;
import at.ac.univie.FiWi.LiM.model.PutOption;
import org.junit.Test;

public class MonteCarloSimulationTest {
  @Test
  public void runSimulationforCallOption() throws Exception {
    Option callOption = new CallOption(100,100, 1, 0.2, 0.05);
    System.out.println("Call Price: " + MonteCarloSimulation.runSimulation(callOption));

  }

  @Test
  public void runSimulationForPutOption() throws Exception {
    Option putOption = new PutOption(100,100, 1, 0.2, 0.05);
    System.out.println("Put Price: " + MonteCarloSimulation.runSimulation(putOption));

  }
}