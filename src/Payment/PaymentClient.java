package Payment;

import java.math.BigDecimal;

public interface PaymentClient {
    static boolean charge(String gatewayID, BigDecimal amount){
        return true;
    }

    static void refund(String gatewayID){
    }
}
