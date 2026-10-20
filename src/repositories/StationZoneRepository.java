package repositories;

import payment.PaymentMethod;
import sqlrepositories.SQLStationZoneRepository;
import station.StationZone;
import zone.BrandColor;
import zone.Logo;

import java.awt.*;
import java.util.List;

public interface StationZoneRepository {
    static Color getBrandColor(BrandColor brandColorType){
        return SQLStationZoneRepository.fetchBrandColor(brandColorType);
    }
    static Image getBrandLogo(Logo brandLogoType){
        return SQLStationZoneRepository.fetchBrandLogo(brandLogoType);
    }
    static List<PaymentMethod> getAllowedPaymentTypes(StationZone stationZone){
        return SQLStationZoneRepository.fetchAllowedPaymentTypes(stationZone);
    }
}
