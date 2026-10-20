package payment;

import userclasses.User;

public class PaymentMethod {
    /**
     * The user of which the Payment.PaymentMethod is attached to
     * User.User contains a unique id that is associated with transactions and receipts
     */
    private final User assignedUser;

    /**
     * Payment.PaymentType (enum) of the Payment.PaymentMethod object
     * Set upon Payment.PaymentMethod object initialization, and cannot be overwritten afterwards
     */
    private final PaymentType paymentType;

    public PaymentMethod(PaymentType paymentType, User assignedUser){
        this.paymentType = paymentType;
        this.assignedUser = assignedUser;
    }

    public PaymentType getPaymentType(){
        return this.paymentType;
    }

    public User getAssignedUser(){
        return this.assignedUser;
    }

}
