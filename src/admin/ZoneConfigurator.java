package admin;

import payment.PaymentType;
import zone.BrandColor;
import zone.Logo;
import station.StationZone;

import java.util.ArrayList;

/**
 * Validate and apply configuration to a StationZone
 */
public class ZoneConfigurator {

    // ---------- UC-ConfigureZone ----------

    /**
     * Validate and apply new config settings to a specific StationZone
     * @param zone StationZone which is to be configured
     * @param payments list of allowed payment methods
     * @param colour the brand color
     * @param logoPath file path to the logo file
     * @return true if zone was validated and configured properly. false if not.
     */
    public boolean configureZone(StationZone zone, ArrayList<PaymentType> payments, String colour, String logoPath) {
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

        zone.setBrandColor(new BrandColor(colour));
        zone.setLogo(new Logo(logoPath));
        System.out.println("Zone settings updated.");
        return true;
    }

    /**
     * Check whether a color is valid
     * @param colour color to be checked.
     * @return true if the color begins with '#' and is 7 characters long. False otherwise.
     */
    private boolean isValidColour(String colour) {
        return colour != null && colour.startsWith("#") && colour.length() == 7;
    }

    /**
     * Check if a logo is valid by checking whether the path to logo is null and if the path ends with .png, .jpg (meaning it is an image)
     * @param logoPath Path to the logo file.
     * @return true if the logo is valid, false if the logo is not valid.
     */
    private boolean isValidLogo(String logoPath) {
        if (logoPath == null) {
            return false;
        }
        String lower = logoPath.toLowerCase();
        return lower.endsWith(".png") || lower.endsWith(".jpg");
    }
}
