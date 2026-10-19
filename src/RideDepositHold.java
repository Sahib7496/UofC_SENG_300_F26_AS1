import java.math.BigDecimal;

public class RideDepositHold {
    private String gatewayID;
    private User user;
    /**
     * Boolean indicating if the DepositHold was already charged.
     * Prevents multiple threads charging the same account more than once for any given transaction.
     */
    private boolean charged;
    public RideDepositHold(Rider rider){
        this.gatewayID = GatewayHandler.generateGatewayID();
        this.charged = false;
    }
    String getGatewayID(){
        return this.gatewayID;
    }
    boolean getIsCharged(){
        return this.charged;
    }
    void getGatewayID(String gatewayID){
        this.gatewayID = gatewayID;
    }

    /**
     * Set the deposit hold as charged.
     * Cannot be set as false to prevent consecutive charges per transaction.
     */
    void setAsCharged(){
        this.charged = true;
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
    public void releaseRideDepositHold(Rider rider, Vehicle vehicle, DepositHoldReleaseMode depositHoldReleaseMode){
        this.setAsCharged();
        if (depositHoldReleaseMode.equals(DepositHoldReleaseMode.CHARGE)){
            BigDecimal amount = calculateRideCost(vehicle, rider);
            boolean success = Transaction.charge(this, amount);
            if (success){
                vehicle.setDepositHold(null);
            }
        } else {
            vehicle.setDepositHold(null);
        }
    }
}
