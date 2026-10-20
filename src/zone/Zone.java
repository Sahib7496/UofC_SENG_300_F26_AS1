package zone;

import java.util.List;
import java.util.ArrayList;

public class Zone {
    private final String zoneId;
    private Logo logo;
    private BrandColor brandColor;
    private final ArrayList<PaymentType> paymentTypes = new ArrayList<>();

    // Constructor
    public Zone(String zoneId, String logoPath, String colorHex) {
        this.zoneId = zoneId;
        this.logo = new Logo(logoPath);
        this.brandColor = new BrandColor(colorHex);
    }

    // Getter - zoneId
    public String getZoneId() {
        return zoneId;
    }

    // Setter - logo
    public void setLogo(Logo logo) {
        this.logo = logo;
    }

    // Setter - brandColor
    public void setBrandColour(BrandColor brandColor) {
        this.brandColor = brandColor;
    }

    // Add payment type
    public void addPaymentType(PaymentType paymentType) {
        if (!paymentTypes.contains(paymentType)) {
            paymentTypes.add(paymentType);
        }
    }

    // Remove payment type
    public void removePaymentType(PaymentType paymentType) {
        paymentTypes.remove(paymentType);
    }

    // Getter - logo
    public Logo getLogo() {
        return logo;
    }

    // Getter - brandColor
    public BrandColor getBrandColor() {
        return brandColor;
    }

    // Getter - paymentTypes
    public List<PaymentType> getPaymentTypes() {
        return new ArrayList<>(paymentTypes);
    }
}
