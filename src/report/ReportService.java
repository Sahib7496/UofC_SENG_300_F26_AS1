package report;

import vehicle.ElectricVehicle;
import vehicle.Vehicle;
import vehicle.VehicleStatus

import java.util.ArrayList;

public class ReportService {
    private ArrayList<ReportListener> listeners = new ArrayList<>();

    public void addListener(ReportListener listener) {
        listeners.add(listener);
    }

    private void notifyListeners(IssueReport report) {
        for (ReportListener listener : listeners) {
            listener.onIssueReported(report);
        }
    }

    public void reportIssue(Vehicle vehicle, String description) {
        if (description == null || description.trim().isEmpty()) {
            description = "No details given";
        }

        vehicle.setVehicleStatus(OUT_OF_SERVICE);
        notifyListeners(new IssueReport(vehicle, description));
    }

    public void checkBattery(ElectricVehicle vehicle) {
        if (vehicle.getBatteryLevel() < 20) {
            reportIssue(vehicle, "Low battery (" + vehicle.getBatteryLevel() + "%)");
        }
    }
}
