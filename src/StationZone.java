///
/// TEMPORARY INTERFACE
///
import java.util.List;

public interface StationZone {
    void setLogo(Logo logo);
    void setBrandColour(BrandColor brandColor);
    void addPaymentType(PaymentType paymentType);
    void removePaymentType(PaymentType paymentType);
    Logo getLogo();
    BrandColor getBrandColor();
    List<PaymentType> getPaymentTypes();
}
