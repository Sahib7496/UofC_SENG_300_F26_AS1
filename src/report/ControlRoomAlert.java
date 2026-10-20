package report;

public class ControlRoomAlert implements ReportListener {
    /**
     * Alert the control room about a vehicle to be taken out of service
     * @param report report of the issue that occurred
     */
    @Override
    public void onIssueReported(IssueReport report) {
        System.out.println("[Control room] " + report + ". Take vehicle out of service.");
    }
}
