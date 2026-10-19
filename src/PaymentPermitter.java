public class PaymentPermitter {
    public static boolean validateRideChargeHold(PaymentMethod paymentMethod, Vehicle vehicle, StationZone stationZone){
        if (stationZone.getPaymentTypes().contains(paymentMethod.getPaymentType())){
            RideDepositHold rideDepositHold = new RideDepositHold(paymentMethod.getAssignedUser(), vehicle);
            return true;
        } else {
            return false;
        }
    }
}
