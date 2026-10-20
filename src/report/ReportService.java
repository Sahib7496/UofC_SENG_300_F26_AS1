package report;

import vehicle.Vehicle;
import vehicle.VehicleStatus;

import java.util.ArrayList;


public class ReportService {
    private ArrayList<ReportListener> listeners = new ArrayList<>();

    /**
     * add a new listener to be reported when issues are found
     * @param listener the ReportListener to be added to the list of listeners
     */
    public void addListener(ReportListener listener) {
        listeners.add(listener);
    }

    /**
     * notify all listeners when a new issue is reported
     * @param report issue details to report
     */
    private void notifyListeners(IssueReport report) {
        for (ReportListener listener : listeners) {
            listener.onIssueReported(report);
        }
    }

    /**
     * If a report is made, set the vehicle to out of service status and notify the listeners
     * @param vehicle vehicle which has an issue
     * @param description issue description
     */
    public void reportIssue(Vehicle vehicle, String description) {
        if (description == null || description.trim().isEmpty()) {
            description = "No details given";
        }

        vehicle.setVehicleStatus(VehicleStatus.OUT_OF_SERVICE);
        notifyListeners(new IssueReport(vehicle, description));
    }

    /**
     * check and report low battery for vehicles.
     * battery at -1 is not included as it is the default battery level for the pedal bikes.
     * @param vehicle vehicle to be reported.
     */
    public void checkBattery(Vehicle vehicle) {
        if (vehicle.getBatteryLevel() != -1 && vehicle.getBatteryLevel() < 20) {
            reportIssue(vehicle, "Low battery (" + vehicle.getBatteryLevel() + "%)");
        }
    }
}
