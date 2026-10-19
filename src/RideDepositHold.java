import java.math.BigDecimal;

public class RideDepositHold {
    private String gatewayID;
    private User user;
    public RideDepositHold(Rider rider, Vehicle vehicle){
        this.gatewayID = GatewayHandler.generateGatewayID();
        vehicle.setDepositHold(this);
    }
    private static BigDecimal convertRateReductionToMultiplier(BigDecimal rateReduction){
        return BigDecimal.ONE.subtract(rateReduction);
    }
    private static long getRideTime(Vehicle vehicle){
        return (System.currentTimeMillis() - vehicle.getRideStartTimeUnix()) * 60000L;
    }
    private static BigDecimal calculateRideCost(Vehicle vehicle, Rider rider){
        BigDecimal rateMultiplier = convertRateReductionToMultiplier(rider.getRateReduction());
        /**
         * Time that the vehicle has been riden for, given in minutes
         */
        BigDecimal rideRatePerMin = RideChargeRepository.getPriceOfRideRatePerMin();
        long rideTime = getRideTime(vehicle);
        BigDecimal rideCostWOSurcharge = rateMultiplier.multiply(rideRatePerMin.multiply(BigDecimal.valueOf(rideTime)));
        long timeThreshold = RideChargeRepository.getTimeThresholdForSurcharge();
        if (rideTime >= timeThreshold){
            BigDecimal surcharge = RideChargeRepository.getPriceOfRideSurcharge();
            return rideCostWOSurcharge.add(surcharge);
        } else {
            return rideCostWOSurcharge;
        }
    }
    public void releaseRideDepositHold(User user, Vehicle vehicle, DepositHoldReleaseMode depositHoldReleaseMode){

    }
}
