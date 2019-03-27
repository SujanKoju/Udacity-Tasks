package SpaceChallenge;

public class Rocket implements SpaceShip {
    private double costInMillionDollar;
    private double weightInTonnes;
    private double maxWeightLimitItCanCarryInTonnes;
    private double currentWeightInTonnes;
    private double chanceOfLaunchExplosion;
    private double chanceOfLandingCrash;

    public Rocket() {
    }

    public double getCostInMillionDollar() {
        return this.costInMillionDollar;
    }

    public void setCostInMillionDollar(double costInMillionDollar) {
        this.costInMillionDollar = costInMillionDollar;
    }

    public double getWeightInTonnes() {
        return this.weightInTonnes;
    }

    public void setWeightInTonnes(double weightInTonnes) {
        this.weightInTonnes = weightInTonnes;
    }

    public double getMaxWeightLimitItCanCarryInTonnes() {
        return this.maxWeightLimitItCanCarryInTonnes;
    }

    public void setMaxWeightLimitItCanCarryInTonnes(double maxWeightLimitItCanCarryInTonnes) {
        this.maxWeightLimitItCanCarryInTonnes = maxWeightLimitItCanCarryInTonnes;
    }

    public double getCurrentWeightInTonnes() {
        return this.currentWeightInTonnes;
    }

    public void setCurrentWeightInTonnes(double currentWeightInTonnes) {
        this.currentWeightInTonnes = currentWeightInTonnes;
    }

    public double getChanceOfLaunchExplosion() {
        return this.chanceOfLaunchExplosion;
    }

    public void setChanceOfLaunchExplosion(double chanceOfLaunchExplosion) {
        this.chanceOfLaunchExplosion = chanceOfLaunchExplosion;
    }

    public double getChanceOfLandingCrash() {
        return this.chanceOfLandingCrash;
    }

    public void setChanceOfLandingCrash(double chanceOfLandingCrash) {
        this.chanceOfLandingCrash = chanceOfLandingCrash;
    }

    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

    public boolean canCarry(Item item) {
        return this.getCurrentWeightInTonnes() + (double)item.getWeight() <= this.getMaxWeightLimitItCanCarryInTonnes();
    }

    public void carry(Item item) {
        this.setCurrentWeightInTonnes(this.getCurrentWeightInTonnes() + (double)item.getWeight());
    }
}
