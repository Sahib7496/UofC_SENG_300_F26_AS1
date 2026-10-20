package payment;

import java.math.BigDecimal;

/**
 * interface for charging a client with a given gatewayID
 */
public interface PaymentClient {
    /**
     * charge a client a specific amount of money with a given gatewayID
     * @param gatewayID the gateway id
     * @param amount amount that is charged to the client.
     * @return true if the charge was successful, false if unsuccessful.
     */
    static boolean charge(String gatewayID, BigDecimal amount){
        return true;
    }

    /**
     * refund a charge given a gateway ID
     * @param gatewayID gateway id of the related charge.
     */
    static void refund(String gatewayID){
    }
}
