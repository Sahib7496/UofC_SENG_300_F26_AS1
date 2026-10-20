package display;

import java.util.HashMap;

/**
 * A message catalog that manages user interface messages.
 */
public class MessageCatalog {
    private HashMap<MessageKey, String> english = new HashMap<>();
    private HashMap<MessageKey, String> french = new HashMap<>();

    /**
     * Create a new catalog and add all the default phrases
     * Add translations for the supported languages (English and French).
     */
    public MessageCatalog() {
        english.put(MessageKey.VEHICLE_UNLOCKED, "Vehicle unlocked. Enjoy your ride!");
        english.put(MessageKey.VEHICLE_NOT_AVAILABLE, "This vehicle is not available.");
        english.put(MessageKey.LOW_BATTERY, "Battery is below 20%. Please choose another vehicle.");
        english.put(MessageKey.PAYMENT_NOT_ALLOWED, "This payment method is not accepted in this zone.");
        english.put(MessageKey.PAYMENT_DECLINED, "Payment declined. Please choose another method.");
        english.put(MessageKey.STATION_FULL, "This station is full. Nearest station with a free docking point:");
        english.put(MessageKey.VEHICLE_NOT_LOCKED, "Vehicle not locked. Please lock it into the docking point.");
        english.put(MessageKey.TRIP_ENDED, "Trip ended. Total:");
        english.put(MessageKey.ISSUE_REPORTED, "Thank you. This vehicle has been taken out of service.");

        french.put(MessageKey.VEHICLE_UNLOCKED, "Véhicule déverrouillé. Bonne route !");
        french.put(MessageKey.VEHICLE_NOT_AVAILABLE, "Ce véhicule n'est pas disponible.");
        french.put(MessageKey.LOW_BATTERY, "La batterie est sous 20 %. Veuillez choisir un autre véhicule.");
        french.put(MessageKey.PAYMENT_NOT_ALLOWED, "Ce mode de paiement n'est pas accepté dans cette zone.");
        french.put(MessageKey.PAYMENT_DECLINED, "Paiement refusé. Veuillez choisir un autre mode de paiement.");
        french.put(MessageKey.STATION_FULL, "Cette station est pleine. Station la plus proche avec une place libre :");
        french.put(MessageKey.VEHICLE_NOT_LOCKED, "Véhicule non verrouillé. Veuillez le verrouiller à la borne.");
        french.put(MessageKey.TRIP_ENDED, "Trajet terminé. Total :");
        french.put(MessageKey.ISSUE_REPORTED, "Merci. Ce véhicule a été mis hors service.");
    }

    /**
     * Get an appropriate message which matches the key and language.
     * @param language Language of the expected output
     * @param key key of the specific expected message
     * @return string of the matching message, returns the message in English if no language is specified or if the specified language is not supported yet.
     */
    public String getMessage(Language language, MessageKey key) {
        String message;

        if (language == Language.FRENCH) {
            message = french.get(key);
        } else {
            message = english.get(key);
        }

        // If a translation is missing, use English as default
        if (message == null) {
            message = english.get(key);
        }

        // If there is no text, show key name so problem is easy to spot
        if (message == null) {
            message = "[" + key + "]";
        }

        return message;
    }
}
