package SpaceChallenge;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        System.out.println("******* Loading U1 with Construction Materials *******");
        List u1FleetsWithConsEquip = simulation.loadU1("phase-1.txt");
        System.out.println("******* Loading U2 with Construction Materials ******* \n");
        List u2FleetsWithConsEquip = simulation.loadU2("phase-1.txt");
        System.out.println("******* Run Simulation for Fleet of U1 Rockets ******* ");
        simulation.runSimulation((ArrayList)u1FleetsWithConsEquip);
        System.out.println("******* Run Simulation for Fleet of U2 Rockets ******* ");
        simulation.runSimulation((ArrayList)u2FleetsWithConsEquip);
        System.out.println("******* Loading U1 with Human and Food Resources ******* ");
        List u1FleetsWithHuman = simulation.loadU1("phase-2.txt");
        System.out.println("******* Loading U2 with Human and Food Resources  ******* ");
        List u2FleetsWithHuman = simulation.loadU2("phase-2.txt");
        System.out.println();
        System.out.println("******* Run Simulation for Fleet of U1 Rockets ******* \n");
        simulation.runSimulation((ArrayList)u1FleetsWithHuman);
        System.out.println("******* Run Simulation for Fleet of U2 Rockets ******* \n");
        simulation.runSimulation((ArrayList)u2FleetsWithHuman);
    }
}
