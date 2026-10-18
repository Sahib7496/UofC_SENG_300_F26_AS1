abstract public class User {
    /**
     * User ID, of type string, associated with the user
     */
    private String userID;
    /**
     * Email address of the user, given as a string
     */
    private String email;

    /**
     * Constructor called during User subclass object initialization
     * @param userID The userID of the user
     * @param email The email of the user
     */
    protected User(String userID, String email){
        this.userID = userID;
        this.email = email;
    }

}
