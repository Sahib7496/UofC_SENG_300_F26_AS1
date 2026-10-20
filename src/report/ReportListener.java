package report;

public interface ReportListener {
    /**
     * Report a new issue about a vehicle
     * @param report details about the issue
     */
    void onIssueReported(IssueReport report);
}
