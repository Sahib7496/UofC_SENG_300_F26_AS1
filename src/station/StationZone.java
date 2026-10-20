package station;
import payment.PaymentType;
import zone.BrandColor;
import zone.Logo;

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
    public void setBrandColor(BrandColor brandColor){
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

    /**
     * add a payment type to the allowed payment types without allowing duplicates or null values.
     * @param paymentType payment type to be added
     */
    public void addPaymentType(PaymentType paymentType){
        if (paymentType != null &&  !allowedPaymentTypes.contains(paymentType)) {
            allowedPaymentTypes.add(paymentType);
        }
    }

    /**
     * remove a pre-existing payment type from the payment types
     * @param paymentType payment type to be removed.
     */
    public void removePaymentType(PaymentType paymentType){
        if (allowedPaymentTypes.contains(paymentType)) {
            allowedPaymentTypes.remove(paymentType);
        }
    }
}
