import java.util.Objects;

public class PaymentMethod {
    /**
     * The user of which the PaymentMethod is attached to
     * User contains a unique id that is associated with transactions and receipts
     */
    private final User assignedUser;

    /**
     * PaymentType (enum) of the PaymentMethod object
     * Set upon PaymentMethod object initialization, and cannot be overwritten afterwards
     */
    private final PaymentType paymentType;

    public PaymentMethod(PaymentType paymentType, User assignedUser){
        this.paymentType = paymentType;
        this.assignedUser = assignedUser;
    }

    PaymentType getPaymentType(){
        return this.paymentType;
    }


}
