package payment;

import station.StationZone;
import userclasses.Rider;
import userclasses.User;
import vehicle.Vehicle;

public class PaymentPermitter {
    /**
     * Check if the station zone contains the payment type and performs a type check to ensure that the user is a rider
     * @param paymentMethod payment method to be validated
     * @param vehicle vehicle to be rented
     * @param stationZone starting point of the rental.
     * @return true if the hold was successful, false if not.
     */
    public static boolean validateRideChargeHold(PaymentMethod paymentMethod, Vehicle vehicle, StationZone stationZone){
        User user = paymentMethod.getAssignedUser();
        if (stationZone.getPaymentTypes().contains(paymentMethod.getPaymentType()) && user instanceof Rider){
            RideDepositHold rideDepositHold = new RideDepositHold((Rider) paymentMethod.getAssignedUser());
            vehicle.setRideDepositHold(rideDepositHold);
            return true;
        } else {
            return false;
        }
    }
}
