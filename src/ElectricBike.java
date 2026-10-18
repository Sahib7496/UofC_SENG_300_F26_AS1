public class ElectricBike extends Vehicle{
    /**
     * Create a new electric bike.
     * @param vehicleID UID for the electric bike
     */
    public ElectricBike(String vehicleID, int batteryLevel) {
        super(vehicleID, batteryLevel);
    }

    /**
     * Check whether the electric bike is rentable
     * @return true if battery percentage of the electric bike is 20% more, no if it is under 20
     */
    @Override
    public boolean isRentable() {
        return (this.getBatteryLevel()>=20);
    }
}
