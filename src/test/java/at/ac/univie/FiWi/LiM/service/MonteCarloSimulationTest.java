package at.ac.univie.FiWi.LiM.service;

import at.ac.univie.FiWi.LiM.model.CallOption;
import at.ac.univie.FiWi.LiM.model.Option;
import org.junit.Test;

public class MonteCarloSimulationTest {
  @Test
  public void runSimulation() throws Exception {
    Option option = new CallOption(100,3, 120);
    System.out.println("Call Price: " + MonteCarloSimulation.runSimulation(option));
  }

}