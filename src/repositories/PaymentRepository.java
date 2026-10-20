package repositories;

import sqlrepositories.SQLPaymentRepository;

public interface PaymentRepository {
    static void sendPayment(String gatewayID){
        SQLPaymentRepository.savePayment(gatewayID);
    }
}
