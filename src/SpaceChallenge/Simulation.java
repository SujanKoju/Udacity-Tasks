
package SpaceChallenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Simulation {
    public Simulation() {
    }

    public List<Item> loadItems(String fileName) {
        ArrayList<Item> allItems = new ArrayList();
        File itemFile = new File(fileName);
        Scanner scanner = null;

        try {
            scanner = new Scanner(itemFile);
        } catch (FileNotFoundException var8) {
            var8.printStackTrace();
        }

        while(scanner.hasNextLine()) {
            String itemWithWeight = scanner.nextLine();
            String[] items = itemWithWeight.split("=");
            Item item = new Item();
            item.setName(items[0]);
            item.setWeight(Integer.parseInt(items[1]) / 1000);
            allItems.add(item);
        }

        return allItems;
    }

    public List<U1> loadU1(String fileName) {
        List<Item> items = this.loadItems(fileName);
        List<U1> u1Rockets = new ArrayList();
        U1 u1 = new U1();

        for(int itemNo = 0; itemNo < items.size(); ++itemNo) {
            if (u1.canCarry((Item)items.get(itemNo))) {
                u1.carry((Item)items.get(itemNo));
            } else {
                --itemNo;
                u1Rockets.add(u1);
                u1 = new U1();
            }
        }

        if (u1.getCurrentWeightInTonnes() > 0.0D) {
            u1Rockets.add(u1);
        }

        return u1Rockets;
    }

    public List<U2> loadU2(String fileName) {
        List<Item> items = this.loadItems(fileName);
        List<U2> u2Rockets = new ArrayList();
        U2 u2 = new U2();

        for(int itemNo = 0; itemNo < items.size(); ++itemNo) {
            if (u2.canCarry((Item)items.get(itemNo))) {
                u2.carry((Item)items.get(itemNo));
            } else {
                --itemNo;
                u2Rockets.add(u2);
                u2 = new U2();
            }
        }

        if (u2.getCurrentWeightInTonnes() > 0.0D) {
            u2Rockets.add(u2);
        }

        return u2Rockets;
    }

    public void runSimulation(List<Rocket> rockets) {
        double totalBudgetInMillonDollar = 0.0D;
        int launchFail = 0;
        int landFail = 0;
        Iterator var6 = rockets.iterator();

        while(true) {
            while(var6.hasNext()) {
                Rocket rocket = (Rocket)var6.next();
                if (rocket.launch() && rocket.land()) {
                    totalBudgetInMillonDollar += rocket.getCostInMillionDollar();
                } else {
                    while(rocket.launch() && !rocket.land()) {
                        if (rocket.launch()) {
                            if (rocket.land()) {
                                totalBudgetInMillonDollar += rocket.getCostInMillionDollar();
                            } else {
                                System.out.println("Rocket explode during Landing. Resend the Rocket");
                                ++landFail;
                            }
                        } else {
                            System.out.println("Rocket explode during Launching. Resend the Rocket");
                            ++launchFail;
                        }
                    }
                }
            }

            totalBudgetInMillonDollar = (double)(launchFail + landFail + rockets.size()) * ((Rocket)rockets.get(0)).getCostInMillionDollar();
            System.out.println("Total Budget Req -->" + totalBudgetInMillonDollar + " Million Dollar");
            System.out.println("Total Rocket in Fleet ->" + rockets.size());
            System.out.println("Sucessfully Transfered to moon with ->" + launchFail + " LaunchFail and " + landFail + " LandFail \n");
            return;
        }
    }
}
