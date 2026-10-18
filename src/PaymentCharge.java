import java.math.BigDecimal;

public class PaymentCharge {
    private static BigDecimal convertRateReductionToMultiplier(BigDecimal rateReduction){
        return BigDecimal.ONE.subtract(rateReduction);
    }
    public static BigDecimal computeCharge(PaymentMethod paymentMethod, BigDecimal rateReduction, long rideTime, long surchargeTimeThreshold){
        BigDecimal rateMultipler = convertRateReductionToMultiplier(rateReduction);
        BigDecimal costWOSurcharge = rateMultipler.multiply(BigDecimal.valueOf(0.80));
        //Replace placeholder 0.80 with the Rate per Minute value from PriceModelRepository, when implemented
        if (rideTime >= surchargeTimeThreshold){
            return costWOSurcharge.add(BigDecimal.valueOf(0.50));
            //Replace placeholder 0.50 with the Rate per Minute value from PriceModelRepository, when implemented
        } else {
            return costWOSurcharge;
        }
    }
}
