//Imported BigDecimal to handle financial rate calculations without dealing with floating point limits
import java.math.BigDecimal;
/**
 * Subclass of Rider containing Rider objects that are Students with a unique rate reduction
 */
public class StudentRider extends Rider{
    /**
     * Constructor called during StudentRider object initialization.
     * References constructor of abstract parent class Rider.
     * @param rateReduction The rate reduction to apply to the StudentRider object
     */
    public StudentRider(BigDecimal rateReduction){
        super(rateReduction);
    }
}
