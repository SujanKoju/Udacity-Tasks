
package SpaceChallenge;

import java.util.Random;

public class U2 extends Rocket {
    public U2() {
        this.setCostInMillionDollar(120.0D);
        this.setWeightInTonnes(18.0D);
        this.setMaxWeightLimitItCanCarryInTonnes(29.0D);
    }

    public boolean launch() {
        double random = (new Random()).nextDouble() / 10.0D;
        this.setChanceOfLaunchExplosion(0.04D * (this.getCurrentWeightInTonnes() / this.getMaxWeightLimitItCanCarryInTonnes()));
        return this.getChanceOfLaunchExplosion() < random;
    }

    public boolean land() {
        double random = (new Random()).nextDouble() / 10.0D;
        this.setChanceOfLandingCrash(0.08D * (this.getCurrentWeightInTonnes() / this.getMaxWeightLimitItCanCarryInTonnes()));
        return this.getChanceOfLandingCrash() < random;
    }
}
