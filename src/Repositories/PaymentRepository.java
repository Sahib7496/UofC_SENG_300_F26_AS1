package Repositories;

import SQLRepositories.SQLPaymentRepository;

public interface PaymentRepository {
    static void sendPayment(String gatewayID){
        SQLPaymentRepository.savePayment(gatewayID);
    }
}
