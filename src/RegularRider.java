//Imported BigDecimal to handle financial rate calculations without dealing with floating point limits
import java.math.BigDecimal;

/**
 * Subclass of Rider containing Rider objects without a rate reduction
 */
public class RegularRider extends Rider{
    /**
     * Constructor called during Rider object initialization.
     * References constructor of abstract parent class Rider.
     */
    public RegularRider(){
        //Call parent class constructor with rate reduction to apply
        super(BigDecimal.valueOf(0));
    }
}
