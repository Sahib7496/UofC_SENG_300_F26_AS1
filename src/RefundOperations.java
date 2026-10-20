public interface RefundOperations {
    static void getRefund(String gatewayID){
        Transaction.refund(gatewayID);
    }
}
