package admin;

import payment.PaymentType;
import station.BrandColor;
import station.Logo;
import station.Zone;

import java.util.ArrayList;

public class ZoneConfigurator {

    // ---------- UC-ConfigureZone ----------

    public boolean configureZone(Zone zone, ArrayList<PaymentType> payments, String colour, String logoPath) {
        // Step 4: validate everything first
        if (payments.isEmpty()) {                       // exception 4a
            System.out.println("Rejected: a zone must allow at least one payment method.");
            return false;
        }
        if (!isValidColour(colour)) {
            System.out.println("Rejected: " + colour + " is not a valid colour. Use a format like #2E7D32.");
            return false;
        }
        if (!isValidLogo(logoPath)) {                   // exception 4b
            System.out.println("Rejected: " + logoPath + " is not a valid logo file. Use a .png or .jpg file.");
            return false;
        }

        ArrayList<PaymentType> oldPayments = new ArrayList<>(zone.getPaymentTypes());
        for (PaymentType oldPayment : oldPayments) {
            zone.removePaymentType(oldPayment);
        }
        for (PaymentType payment : payments) {
            zone.addPaymentType(payment);
        }

        zone.setBrandColour(new BrandColor(colour));
        zone.setLogo(new Logo(logoPath));
        System.out.println("Zone settings updated.");
        return true;
    }

    private boolean isValidColour(String colour) {
        return colour != null && colour.startsWith("#") && colour.length() == 7;
    }

    private boolean isValidLogo(String logoPath) {
        if (logoPath == null) {
            return false;
        }
        String lower = logoPath.toLowerCase();
        return lower.endsWith(".png") || lower.endsWith(".jpg");
    }
}
