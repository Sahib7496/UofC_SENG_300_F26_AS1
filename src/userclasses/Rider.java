package userclasses;//Imported BigDecimal to handle financial rate calculations without dealing with floating point limits
import java.math.BigDecimal;
//Import HashSet for containing PaymentMethods per User.User.Rider


/**
 * Abstract class containing the attributes inherited by and shared amongst User.User.Rider subclasses
 */
public abstract class Rider extends User {
    /**
     * The amount to subtract from a User.User.Rider's fare charge from the range [0,1], which maps to a [0%, 100%] discount from the charge.
     * Value type of BigDecimal
     */
    protected BigDecimal rateReduction;
    /**
     * Constructor called during User.User.Rider subclass object initialization
     * @param rateReduction The rate reduction, given in BigDecimal, applied to the User.User.Rider
     */
    protected Rider(String userID, String email, BigDecimal rateReduction){
        super(userID, email);
        //setRateReduction is final, so it can be called in a constructor
        this.setRateReduction(rateReduction);
    }

    /**
     * Sets the rate reduction of the User.User.Rider
     * @param rateReduction The rate reduction, given in BigDecimal, applied to the user
     */
    public final void setRateReduction(BigDecimal rateReduction){
        //Get the User.User.Rider object's rate reduction value, in BigDecimal
        this.rateReduction = rateReduction;
    }

    /**
     * Gets the rate reduction of the User.User.Rider
     * @return The rate reduction value, in BigDecimal, of the User.User.Rider
     */
    public BigDecimal getRateReduction(){
        //Get the User.User.Rider object's rate reduction value, in BigDecimal
        return this.rateReduction;
    }
}
