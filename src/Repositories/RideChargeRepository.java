package Repositories;

import SQLRepositories.SQLRideChargeRepository;

import java.math.BigDecimal;

public interface RideChargeRepository {
    static BigDecimal getPriceOfRideRatePerMin(){
        return SQLRideChargeRepository.fetchPriceOfRideRatePerMin();
    };

    static BigDecimal getPriceOfRideSurcharge(){
        return SQLRideChargeRepository.fetchPriceOfRideSurcharge();
    };

    static long getTimeThresholdForSurcharge(){
        return SQLRideChargeRepository.fetchTimeThresholdForSurcharge();
    };
}
