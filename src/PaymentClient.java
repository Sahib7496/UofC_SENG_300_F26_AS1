import java.math.BigDecimal;

public interface PaymentClient {
    public static boolean charge(String gatewayID, BigDecimal amount){
        return true;
    }

    public static boolean refund(String gatewayID){
        return true;
    }
}
