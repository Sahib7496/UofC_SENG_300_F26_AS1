package operator;

import station.Station;
import vehicle.Vehicle;

import java.util.ArrayList;


public class OperatorService {
    private ArrayList<Station> stations;
    private ArrayList<Vehicle> vehicles;

    public OperatorService(ArrayList<Station> stations, ArrayList<Vehicle> vehicles) {
        this.stations = stations;
        this.vehicles = vehicles;
    }

    private String describe(Vehicle vehicle) {
        String text = vehicle.getVehicleID() + " - " + vehicle.getStatus();

        // Show battery for electric vehicles
        if (vehicle instanceof BatteryPowered) {
            BatteryPowered electric = (BatteryPowered) vehicle;
            text = text + " - battery " + electric.getBatteryLevel() + "%";
        }
        return text;
    }

    // Monitor Network
    public void showNetworkStatus() {
        System.out.println("=== GoCycle ntwork status ===");

        System.out.println("Stations");
        for (Station station : stations) {
            int docked = station.getDockedVehicles().size();
            String line = " " + station.getName() + ": " + docked + " of "
                    + station.getMaxDockingPoints() + " docks used.";
        }
        System.out.println(line);

        System.out.println("Vehicles:");
        for (Vehicle vehicle : vehicles) {
            System.out.println(" " + describe(vehicle));
        }
    }

    // Rebalance vehicles between stations
    public boolean moveVehicle(Vehicle vehicle, Station from, Station to) {
        if (vehicle.getStatus() != VehicleStatus.AVAILABLE) {
            System.out.println("Cannot move " + vehicle.getVehicleID() + ": only available vehicles can be rebalanced");
            return false;
        }

        if (!from.getDockedVehicles().contains(vehicle)) {
            System.out.println("Cannot move " + vehicle.getVehicleID() + ": it is not docked at this station");
            return false;
        }

        if (!to.hasFreeDockingPoint()) {
            System.out.println("Cannot move " + vehicle.getVehicleID() + ": " + to.getName() + " has no free docks");
            return false;
        }

        from.removeVehicleFromStation(vehicle);
        vehicle.setStatus(VehicleStatus.IN_TRANSIT);

        if (!to.addVehicleToStation(vehicle)) {
            System.out.println("Warning " + vehicle.getVehicleID() + " could not be locked at " + to.getName()
            + ". It stays in transit until it is locked.");
            return false;
        }

        vehicle.setStatus(VehicleStatus.AVAILABLE);   // step 5
        System.out.println("Moved " + vehicle.getVehicleID() + " from " + from.getName() + " to " + to.getName() + ".");
        return true;
    }

    // Take vehicle out of service
    public boolean takeOutOfService(Vehicle vehicle) {
        if (vehicle.getStatus() == VehicleStatus.IN_USE) {
            System.out.println(vehicle.getVehicleID() + " is on a trip. Take it out of service after it is returned.");
            return false;
        }

        vehicle.setStatus(VehicleStatus.OUT_OF_SERVICE);
        System.out.println(vehicle.getVehicleID() + " is now out of service.");
        return true;
    }

    // Put vehicle back in service
    public boolean putBackInService(Vehicle vehicle) {
        if (vehicle.getStatus() != VehicleStatus.OUT_OF_SERVICE) {
            System.out.println(vehicle.getVehicleID() + " is not out of service.");
            return false;
        }

        vehicle.setStatus(VehicleStatus.AVAILABLE);
        System.out.println(vehicle.getVehicleID() + " is back in service.");

        if (!vehicle.isRentable()) {
            System.out.println("Note: " + vehicle.getVehicleID()
                    + " has less than 20% battery, so riders cannot take it until it is charged.");
        }
        return true;
    }
}