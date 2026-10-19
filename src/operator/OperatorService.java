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


}
