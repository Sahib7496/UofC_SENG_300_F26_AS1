package UserClasses;//Imported BigDecimal to handle financial rate calculations without dealing with floating point limits
import java.math.BigDecimal;

/**
 * Subclass of User.User.Rider containing User.User.Rider objects without a rate reduction
 */
public class RegularRider extends Rider {
    /**
     * Constructor called during User.User.Rider object initialization.
     * References constructor of abstract parent class User.User.Rider.
     */
    public RegularRider(String userID, String email){
        //Call parent class constructor with rate reduction to apply
        super(userID,email, BigDecimal.valueOf(0));
    }
}
