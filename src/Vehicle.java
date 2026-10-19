public abstract class Vehicle {

    private final String vehicleID;
    private int batteryLevel;
    private long rideStartTimeUnix;
    private VehicleStatus vehicleStatus;
    private RideDepositHold rideDepositHold;

    // Constructor for the Vehicle
    public Vehicle(String vehicleID, int batteryLevel) {
        this.vehicleID = vehicleID;
        this.batteryLevel = batteryLevel;
        this.rideStartTimeUnix = 0; // 0 by default
        this.vehicleStatus = VehicleStatus.AVAILABLE; // a vehicle is available by default
        this.rideDepositHold = null;
    }

    /**
     * check whether a vehicle can be rented
     * @return true, if the vehicle can be rented, false if it cannot be rented.
     */
    public abstract boolean isRentable();

    // Getter methods for the vehicleID, batteryLevel, rideDepositHold, rideStartTime, vehicleStatus
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

    // Setter for battery level, rideDepositHold, rideStartTime
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
}

