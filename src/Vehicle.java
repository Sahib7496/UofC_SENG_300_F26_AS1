public abstract class Vehicle {

    private final String vehicleID;
    private int batteryLevel;
    private long rideStartTimeUnix;
    private VehicleStatus vehicleStatus;
    private RideDepositHold rideDepositHold;
    private double vehicleLatitude;
    private double vehicleLongitude;

    // Constructor for the Vehicle
    public Vehicle(String vehicleID, int batteryLevel) {
        this.vehicleID = vehicleID;
        this.batteryLevel = batteryLevel;
        this.rideStartTimeUnix = 0; // 0 by default
        this.vehicleStatus = VehicleStatus.AVAILABLE; // a vehicle is available by default
        this.rideDepositHold = null;
        this.vehicleLatitude = vehicleLatitude;
        this.vehicleLongitude = vehicleLongitude;
    }

    /**
     * check whether a vehicle can be rented
     * @return true, if the vehicle can be rented, false if it cannot be rented.
     */
    public abstract boolean isRentable();

    // Getter methods for the vehicleID, batteryLevel, rideDepositHold, rideStartTime, vehicleStatus, vehicleLatitude, vehicleLongitude
    public String getVehicleID() {
        return vehicleID;
    }
    public int getBatteryLevel() {
        return batteryLevel;
    }
    public RideDepositHold getRideDepositHold(){
        return rideDepositHold;
    }
    public long getRideStartTimeUnix() {
        return rideStartTimeUnix;
    }
    public VehicleStatus getVehicleStatus(){
        return vehicleStatus;
    }
    public double getVehicleLatitude() {
        return vehicleLatitude;
    }
    public double getVehicleLongitude() {
        return vehicleLongitude;
    }

    // Setter for battery level, rideDepositHold, rideStartTimeUnix, vehicleStatus, vehicleLatitude, vehicleLongitude
    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }
    public void setRideDepositHold(RideDepositHold rideDepositHold){
        this.rideDepositHold = rideDepositHold;
    }
    public void setRideStartTimeUnix(long rideStartTime) {
        this.rideStartTimeUnix = rideStartTime;
    }
    public void setVehicleStatus(VehicleStatus vehicleStatus){
        this.vehicleStatus = vehicleStatus;
    }
    public void setVehicleLatitude(double vehicleLatitude) {
        this.vehicleLatitude = vehicleLatitude;
    }
    public void setVehicleLongitude(double vehicleLongitude) {
        this.vehicleLongitude = vehicleLongitude;
    }
}

