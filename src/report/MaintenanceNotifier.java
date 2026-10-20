package report;

public class MaintenanceNotifier implements ReportListener {
    /**
     * Handle a report by issuing the alert to the maintenance crew
     * @param report report of the issue that occurred
     */
    @Override
    public void onIssueReported(IssueReport report) {
        System.out.println("[Maintenance] Issue reported - " + report);
    }
}
