public interface RefundHandler {
    static void getRefund(String gatewayID){
        Transaction.refund(gatewayID);
    }
}
