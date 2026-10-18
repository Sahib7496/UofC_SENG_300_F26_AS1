public abstract class Vehicle {

    private final String vehicleID;
    private final String vehicleType;
    private int batteryLevel;

    public Vehicle(String vehicleID, String vehicleType, int batteryLevel) {
        this.vehicleID = vehicleID;
        this.vehicleType = vehicleType;
        this.batteryLevel = batteryLevel;
    }


}
