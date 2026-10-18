//Imported BigDecimal to handle financial rate calculations without dealing with floating point limits
import java.math.BigDecimal;
//Import HashSet for containing PaymentMethods per Rider
import java.util.HashSet;

/**
 * Abstract class containing the attributes inherited by and shared amongst Rider subclasses
 */
public abstract class Rider {
    /**
     * The percentage to subtract from a Rider's fare charge.
     * Value type of BigDecimal
     */
    protected BigDecimal rateReduction;
    /**
     * An unordered set of payment methods that the Rider has
     */
    protected HashSet<PaymentMethod> paymentMethods;
    /**
     * Constructor called during Rider subclass object initialization
     * @param rateReduction The rate reduction, given in BigDecimal, applied to the Rider
     */
    protected Rider(BigDecimal rateReduction){
        //setRateReduction is final, so it can be called in a constructor
        this.setRateReduction(rateReduction);
    }

    /**
     * Sets the rate reduction of the Rider
     * @param rateReduction The rate reduction, given in BigDecimal, applied to the user
     */
    final void setRateReduction(BigDecimal rateReduction){
        //Get the Rider object's rate reduction value, in BigDecimal
        this.rateReduction = rateReduction;
    }

    /**
     * Gets the rate reduction of the Rider
     * @return The rate reduction value, in BigDecimal, of the Rider
     */
    BigDecimal getRateReduction(){
        //Get the Rider object's rate reduction value, in BigDecimal
        return this.rateReduction;
    }
}
