package payment;

import java.math.BigDecimal;

public class Transaction {
    /**
     * Charges a rider based on their ride deposit hold information
     * @param depositHold deposit hold information of the rider
     * @param amount amount to be charged
     * @return true if charge successful, false if the charge fails
     */
    public static boolean charge(RideDepositHold depositHold, BigDecimal amount){
        return PaymentClient.charge(depositHold.getGatewayID(), amount);
    }

    /**
     * Issue a refund to the user
     * @param gatewayID payment gateway id associated to the initial transaction.
     */
    public static void refund(String gatewayID){
        PaymentClient.refund(gatewayID);
    }
}
