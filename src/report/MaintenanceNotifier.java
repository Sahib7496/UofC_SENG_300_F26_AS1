package report;

public class MaintenanceNotifier implements ReportListener {
    @Override
    public void onIssueReported(IssueReport report) {
        System.out.println("[Maintenance] Issue reported - " + report);
    }
}
