package payment;

import userclasses.User;

import java.math.BigDecimal;

public interface ReceiptPort {

    static void sendReceipt(RideDepositHold depositHold, BigDecimal amount, User user, ReceiptAccessMode receiptAccessMode){
    };
}
