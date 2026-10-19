import java.math.BigDecimal;

public class Transaction {
    public static boolean charge(RideDepositHold depositHold, BigDecimal amount){
        return PaymentClient.charge(depositHold.getGatewayID(), amount);
    }

    public static boolean refund(String gatewayID){
        return PaymentClient.refund(gatewayID);
    }
}
