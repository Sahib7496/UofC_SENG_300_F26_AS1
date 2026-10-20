package UserClasses;//Imported BigDecimal to handle financial rate calculations without dealing with floating point limits
import java.math.BigDecimal;
/**
 * Subclass of User.User.Rider containing User.User.Rider objects that are Members with a unique rate reduction
 */
public class MemberRider extends Rider {
    /**
     * Constructor called during User.MemberRider object initialization.
     * References constructor of abstract parent class User.User.Rider.
     * @param rateReduction The rate reduction to apply to the User.MemberRider object
     */
    public MemberRider(String userID, String email, BigDecimal rateReduction){
        //Call parent class constructor with rate reduction to apply
        super(userID, email, rateReduction);
    }
}
