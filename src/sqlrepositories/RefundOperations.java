package sqlrepositories;

import payment.Transaction;

public interface RefundOperations {
    static void getRefund(String gatewayID){
        Transaction.refund(gatewayID);
    }
}
