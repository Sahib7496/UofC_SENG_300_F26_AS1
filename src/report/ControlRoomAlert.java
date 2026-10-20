package report;

public class ControlRoomAlert implements ReportListener {
    @Override
    public void onIssueReported(IssueReport report) {
        System.out.println("[Control room] " + report + ". Take vehicle out of service.");
    }
}
