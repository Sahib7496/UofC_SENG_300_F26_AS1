package operator;

import station.Station;
import vehicle.Vehicle;
import vehicle.VehicleStatus;

import java.util.ArrayList;

/**
 * Monitor network status, rebalancing vehicles, manage vehicle service state.
 */
public class OperatorService {
    private ArrayList<Station> stations;
    private ArrayList<Vehicle> vehicles;

    public OperatorService(ArrayList<Station> stations, ArrayList<Vehicle> vehicles) {
        this.stations = stations;
        this.vehicles = vehicles;
    }

    private String describe(Vehicle vehicle) {
        // Show battery for electric vehicles
        String text = vehicle.getVehicleID() + " - " + vehicle.getVehicleStatus();
        text = text + " - battery " + vehicle.getBatteryLevel() + "%";
        return text;
    }

    // Monitor Network
    public void showNetworkStatus() {
        System.out.println("=== GoCycle network status ===");

        System.out.println("Stations");
        for (Station station : stations) {
            int docked = station.getDockedVehicles().size();
            String line = " " + station.getStationId() + ": " + docked + " of "
                    + station.getMaxDockingPoints() + " docks used.";
            System.out.println(line);
        }


        System.out.println("Vehicles:");
        for (Vehicle vehicle : vehicles) {
            System.out.println(" " + describe(vehicle));
        }
    }

    // Rebalance vehicles between stations
    public boolean moveVehicle(Vehicle vehicle, Station from, Station to) {
        if (vehicle.getVehicleStatus() != VehicleStatus.AVAILABLE) {
            System.out.println("Cannot move " + vehicle.getVehicleID() + ": only available vehicles can be rebalanced");
            return false;
        }

        if (!from.getDockedVehicles().contains(vehicle)) {
            System.out.println("Cannot move " + vehicle.getVehicleID() + ": it is not docked at this station");
            return false;
        }

        if (!to.hasFreeDockingPoint()) {
            System.out.println("Cannot move " + vehicle.getVehicleID() + ": " + to.getStationId() + " has no free docks");
            return false;
        }

        from.removeVehicleFromStation(vehicle);
        vehicle.setVehicleStatus(VehicleStatus.IN_TRANSIT);

        if (!to.addVehicleToStation(vehicle)) {
            System.out.println("Warning " + vehicle.getVehicleID() + " could not be locked at " + to.getStationId()
            + ". It stays in transit until it is locked.");
            return false;
        }

        vehicle.setVehicleStatus(VehicleStatus.AVAILABLE);   // step 5
        System.out.println("Moved " + vehicle.getVehicleID() + " from " + from.getStationId() + " to " + to.getStationId() + ".");
        return true;
    }

    // Take vehicle out of service
    public boolean takeOutOfService(Vehicle vehicle) {
        if (vehicle.getVehicleStatus() == VehicleStatus.IN_USE) {
            System.out.println(vehicle.getVehicleID() + " is on a trip. Take it out of service after it is returned.");
            return false;
        }

        vehicle.setVehicleStatus(VehicleStatus.OUT_OF_SERVICE);
        System.out.println(vehicle.getVehicleID() + " is now out of service.");
        return true;
    }

    // Put vehicle back in service
    public boolean putBackInService(Vehicle vehicle) {
        if (vehicle.getVehicleStatus() != VehicleStatus.OUT_OF_SERVICE) {
            System.out.println(vehicle.getVehicleID() + " is not out of service.");
            return false;
        }

        vehicle.setVehicleStatus(VehicleStatus.AVAILABLE);
        System.out.println(vehicle.getVehicleID() + " is back in service.");

        if (!vehicle.isRentable()) {
            System.out.println("Note: " + vehicle.getVehicleID()
                    + " has less than 20% battery, so riders cannot take it until it is charged.");
        }
        return true;
    }
}