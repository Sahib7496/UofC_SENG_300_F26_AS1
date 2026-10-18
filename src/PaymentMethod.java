import java.util.Objects;

public class PaymentMethod {
    /**
     * PaymentType (enum) of the PaymentMethod object
     * Set upon PaymentMethod object initialization, and cannot be overwritten afterwards
     */
    protected final PaymentType paymentType;

    public PaymentMethod(PaymentType paymentType){
        this.paymentType = paymentType;
    }

    /**
     * Compares two PaymentMethod objects for equality via PaymentType
     * Used for HashSets with no duplicate PaymentMethods
     * @param obj   the reference object with which to compare.
     * @return If the two PaymentMethod objects are equal
     */
    @Override
    public boolean equals(Object obj) {
        /*
        If the reference object is null or is not the class as the current object (PaymentMethod),
        return that the two objects are not equal
         */
        if (obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        /*
         If the reference object of type PaymentMethod has the same PaymentType as the current
         object (type cast is allowed as the other object be of class PaymentMethod as indicated above),
         then return that the two objects are equal
         */
        else {
            return this.paymentType == ((PaymentMethod) obj).paymentType;
        }
    }

    /**
     * Override of the hashcode function so that the parameter PaymentType
     * is to be used by HashSets of type PaymentMethod
     * @return Int representing the PaymentMethod object hashcode
     */
    @Override
    public int hashCode(){
        return Objects.hash(paymentType);
    }

    /**
     * Get the payment type (enum) of the payment method
     * @return PaymentType, of type Enum, of the payment method
     */
    PaymentType getPaymentType(){
        return this.paymentType;
    }
}
