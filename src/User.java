abstract public class User {
    /**
     * User ID, of type string, associated with the user upon creation
     */
    private final String userID;
    /**
     * Email address of the user, given as a string
     */
    private String email;

    /**
     * Constructor called during User subclass object initialization
     * @param userID The userID of the user
     * @param email The email of the user, if available. Otherwise, null or empty.
     */
    protected User(String userID, String email){
        this.userID = userID;
        this.email = email;
    }

    /**
     * Returns a string representing the current user's user ID
     * @return The user ID of the User subclass object
     */
    String getUserID(){
        return this.userID;
    }

    /**
     * Returns a string of the current user's email address
     * @return Email address of the User subclass object
     */
    String getEmail(){
        return this.email;
    }

    /**
     * Set the email address of the current user
     * @param email The new email address to be set to the user
     */
    void setEmail(String email){
        this.email = email;
    }

}
