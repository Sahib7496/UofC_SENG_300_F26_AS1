package SQLRepositories;

public enum SQLDatabaseSingleton implements SQLDatabaseOperations {
    db;
    private String url;
    private String user;

    private boolean initialized = false;

    private SQLDatabaseSingleton(){}
    public void init(String url, String user){
        if (!initialized){
            initialized = true;
            this.url = url;
            this.user = user;
        }
    }
}
