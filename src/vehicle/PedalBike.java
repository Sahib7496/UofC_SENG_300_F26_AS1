package vehicle;

public class PedalBike extends Vehicle {
    /**
     * Create a new pedal bike.
     * @param vehicleID UID for the pedal bike
     */
    public PedalBike(String vehicleID) {
        super(vehicleID, -1); // default battery level is 0 because theres no battery in a pedal bike
    }

    /**
     * Check whether a pedal bike is rentable
     * @return true, because a pedal bike does not have a battery, therefore it is always rentable.
     */
    @Override
    public boolean isRentable() {
        return true;
    }
}
