
package SpaceChallenge;

import java.util.Random;

public class U1 extends Rocket {
    public U1() {
        this.setCostInMillionDollar(100.0D);
        this.setWeightInTonnes(10.0D);
        this.setMaxWeightLimitItCanCarryInTonnes(18.0D);
    }

    public boolean launch() {
        double random = (new Random()).nextDouble() / 10.0D;
        double currweight = this.getCurrentWeightInTonnes();
        double maxWeight = this.getMaxWeightLimitItCanCarryInTonnes();
        double check = 0.05D * (currweight / maxWeight);
        this.setChanceOfLaunchExplosion(0.05D * (this.getCurrentWeightInTonnes() / this.getMaxWeightLimitItCanCarryInTonnes()));
        return this.getChanceOfLaunchExplosion() < random;
    }

    public boolean land() {
        double random = (new Random()).nextDouble() / 10.0D;
        this.setChanceOfLandingCrash(0.01D * (this.getCurrentWeightInTonnes() / this.getMaxWeightLimitItCanCarryInTonnes()));
        return this.getChanceOfLandingCrash() < random;
    }
}
