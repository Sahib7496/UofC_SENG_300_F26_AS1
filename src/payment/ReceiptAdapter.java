package payment;

import userclasses.User;
import userclasses.UserInputRequest;

import java.math.BigDecimal;

public interface ReceiptAdapter {
    /**
     * get and send the charge receipt to the user.
     * @param depositHold RideDepositHold that contains user information.
     * @param amount amount charged to the user.
     */
    static void getChargeReceipt(RideDepositHold depositHold, BigDecimal amount){
        User user = depositHold.getAssignedUser();
        ReceiptAccessMode receiptAccessMode = UserInputRequest.getReceiptAccessMode(user);
        ReceiptPort.sendReceipt(depositHold, amount, user, receiptAccessMode);
    };
}
