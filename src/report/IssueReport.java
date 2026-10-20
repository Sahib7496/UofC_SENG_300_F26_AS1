package report;

import vehicle.Vehicle;

public class IssueReport {
    private final Vehicle vehicle;
    private final String description;

    // Constructor
    public IssueReport(Vehicle vehicle, String description) {
        this.vehicle = vehicle;
        this.description = description;
    }

    // Getter - vehicle object
    public Vehicle getVehicle() {
        return vehicle;
    }

    // Getter - string description
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return vehicle.getVehicleID() + ": " + description;
    }
}
