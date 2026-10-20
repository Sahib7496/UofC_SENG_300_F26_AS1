package payment;

import userclasses.User;
import userclasses.UserInputRequest;

import java.math.BigDecimal;

public interface ReceiptAdapter {
    static void getChargeReceipt(RideDepositHold depositHold, BigDecimal amount){
        User user = depositHold.getAssignedUser();
        ReceiptAccessMode receiptAccessMode = UserInputRequest.getReceiptAccessMode(user);
        ReceiptPort.sendReceipt(depositHold, amount, user, receiptAccessMode);
    };
}
