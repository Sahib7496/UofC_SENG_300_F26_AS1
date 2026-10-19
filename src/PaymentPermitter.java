import java.math.BigDecimal;

public class PaymentPermitter {
    private boolean isPaymentTypeAllowed(PaymentType paymentType, Zone zone) {
         return zone.getPaymentTypes().contains(paymentType);
    }
    public static void charge(PaymentMethod paymentMethod, BigDecimal amount){

    }
}
