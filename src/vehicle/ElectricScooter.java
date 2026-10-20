package vehicle;

public class ElectricScooter extends Vehicle {
    /**
     * Create a new electric scooter.
     * @param vehicleID UID for the electric scooter
     */
    public ElectricScooter(String vehicleID, int batteryLevel) {
        super(vehicleID, batteryLevel);
    }

    /**
     * Check whether the electric scooter is rentable
     * @return true if battery percentage of the electric bike is 20% more, no if it is under 20
     */
    @Override
    public boolean isRentable() {
        return (this.getBatteryLevel()>=20);
    }
}
