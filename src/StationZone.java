import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StationZone {
    private final List<PaymentType> allowedPaymentTypes;
    private BrandColor brandColor;
    private Logo logo;

    // Constructor
    public StationZone(List<PaymentType> allowedPaymentTypes) {
        this.allowedPaymentTypes = allowedPaymentTypes;
    }

    // Setter method for logo
    public void setLogo(Logo logo){
        this.logo = logo;
    }

    // Setter method for brandColor
    public void setBrandColor(){
        this.brandColor = brandColor;
    }

    // Getter method for getLogo
    public Logo getLogo(){
        return this.logo;
    }

    // Getter method for getBrandColor
    public BrandColor getBrandColor(){
        return this.brandColor;
    }

    // Getter method for allowedPaymentTypes
    public List<PaymentType> getPaymentTypes(){
        return Collections.unmodifiableList(allowedPaymentTypes);
    }


}
