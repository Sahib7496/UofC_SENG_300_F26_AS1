import java.awt.*;
import java.util.List;

public interface StationZoneRepository {
    static Color getBrandColor(BrandColorType brandColorType){
        return SQLStationZoneRepository.fetchBrandColor(brandColorType);
    }
    static Image getBrandLogo(BrandLogoType brandLogoType){
        return SQLStationZoneRepository.fetchBrandLogo(brandLogoType);
    }
    static List<PaymentMethod> getAllowedPaymentTypes(StationZone stationZone){
        return SQLStationZoneRepository.fetchAllowedPaymentTypes(stationZone);
    }
}
