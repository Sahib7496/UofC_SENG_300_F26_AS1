import java.math.BigDecimal;

public class PaymentCharge {
    /**
     * Converts the rate reduction as a multiplier of the rate-per-minute of the ride
     * @param rateReduction The rate reduction, of type BigDecimal, to convert
     * @return A multiplier representing the percentage to deduct from the rate-per-minute of a ride
     */
    private static BigDecimal convertRateReductionToMultiplier(BigDecimal rateReduction){
        return BigDecimal.ONE.subtract(rateReduction);
    }

    /**
     * Computes the charge of a ride, and sends the charge to PaymentPermitter via method call
     * @param paymentMethod The payment method associated with the ride, containing the User and PaymentType
     * @param rideTime The duration of the ride, given in seconds of type long
     * @param rateReduction The rate reduction to apply to the rate-per-minute of a ride
     */
    public static void computeCharge(PaymentMethod paymentMethod, long rideTime, BigDecimal rateReduction){
        BigDecimal rateMultiplier = convertRateReductionToMultiplier(rateReduction);
        BigDecimal costWOSurcharge = rateMultiplier.multiply(BigDecimal.valueOf(0.80));
        //Replace placeholder 0.80 with the Rate per Minute value from PriceModelRepository, when implemented
        if (rideTime >= 120){
            //Replace 120 with ride time surcharge threshold from PriceModelRepository
            PaymentPermitter.charge(paymentMethod, costWOSurcharge.add(BigDecimal.valueOf(0.50)));
            //Replace placeholder 0.50 with the Rate per Minute value from PriceModelRepository, when implemented
        } else {
            PaymentPermitter.charge(paymentMethod, costWOSurcharge);
        }
    }
}
