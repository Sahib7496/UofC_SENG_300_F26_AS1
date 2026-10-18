public abstract class Vehicle {

    private final String vehicleID;
    private int batteryLevel;

    // Constructor for the Vehicle
    public Vehicle(String vehicleID, int batteryLevel) {
        this.vehicleID = vehicleID;
        this.batteryLevel = batteryLevel;
    }

    /**
     * check whether a vehicle can be rented
     * @return true, if the vehicle can be rented, false if it cannot be rented.
     */
    public abstract boolean isRentable();

    // Getter methods for the vehicleID and batteryLevel
    public String getVehicleID() {
        return vehicleID;
    }
    public int getBatteryLevel() {
        return batteryLevel;
    }

    // Setter for battery level
    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }
}

