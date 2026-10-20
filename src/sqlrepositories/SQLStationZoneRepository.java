package sqlrepositories;

import payment.PaymentMethod;
import station.StationZone;
import zone.BrandColor;
import zone.Logo;

import java.awt.*;
import java.util.List;

public class SQLStationZoneRepository {
    private SQLDatabaseSingleton db = SQLDatabaseSingleton.db;
    public static Color fetchBrandColor(BrandColor brandColorType){
        return null;
    }
    public static Image fetchBrandLogo(Logo brandLogoType){
        return null;
    }
    public static List<PaymentMethod> fetchAllowedPaymentTypes(StationZone stationZone){
        return null;
    }
}
