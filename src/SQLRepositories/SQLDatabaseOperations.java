package SQLRepositories;

import java.sql.ResultSet;

public interface SQLDatabaseOperations {
    static boolean execute(String sql){
        return true;
    }
    static ResultSet query(String sql){
        return null;
    }
}
