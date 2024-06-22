package zuheTest;

public class Test {
    @org.junit.Test
    public void ttttest()
    {
        Torch aTorch = new Torch(new Battery());
        System.out.println("Charge: 2 hours");
        aTorch.charge(2);
        System.out.println("First Turn On: 3 hours");
        aTorch.turnOn(3);
        System.out.println("Second Turn On: 3 hours");
        aTorch.turnOn(3);
    }

    class Battery
    {
        public void chargeBattery(double p)
        {
            if (this.power < 1.) {
                this.power = this.power + p;
            }
        }

        public boolean useBattery(double p)
        {
            if (this.power >= p) {
                this.power = this.power - p;
                return true;
            }
            else {
                this.power = 0.0;
                return false;
            }
        }

        private double power = 0.0;
    }

    class Torch
    {    /**      * 10% power per hour use     * warning when out of power     */
    private Battery theBattery;

        public Torch(Battery theBattery) {
            this.theBattery = theBattery;
        }

        public void turnOn(int hours)
    {
        boolean usable;
        usable = this.theBattery.useBattery( hours*0.1 );
        if (usable != true) {
            System.out.println("No more usable, must charge!");
        }
    }
        /**     * 20% power per hour charge     */
        public void charge(int hours)
        {
            this.theBattery.chargeBattery( hours*0.2 );
        }

        /**
         * composition
         */

    }
}
