package Payment;

public class PaymentPermitter {
    public static boolean validateRideChargeHold(PaymentMethod paymentMethod, Vehicle vehicle, StationZone stationZone){
        User user = paymentMethod.getAssignedUser();
        if (stationZone.getPaymentTypes().contains(paymentMethod.getPaymentType()) && user instanceof Rider){
            RideDepositHold rideDepositHold = new RideDepositHold((Rider) paymentMethod.getAssignedUser());
            vehicle.setDepositHold(rideDepositHold);
            return true;
        } else {
            return false;
        }
    }
}
