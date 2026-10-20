package userclasses;

import payment.ReceiptAccessMode;

public interface UserInputRequest {
    static ReceiptAccessMode getReceiptAccessMode(User user){
        return ReceiptAccessMode.EMAIL;
    }
}
