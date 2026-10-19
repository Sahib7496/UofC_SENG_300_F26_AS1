import java.math.BigDecimal;

public interface RideChargeRepository {
    static BigDecimal getPriceOfRideRatePerMin(){
        return BigDecimal.valueOf(0.80);
    };

    static BigDecimal getPriceOfRideSurcharge(){
        return BigDecimal.valueOf(60);
    };

    static long getTimeThresholdForSurcharge(){
        return 120;
    };
}
