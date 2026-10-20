package display;

/**
 * Gets and manages the presentation of the messages.
 * acts as a kind of link between MessageCatalog and Display with the specified language.
 */
public class MessagePresenter {
    private MessageCatalog catalog;
    private Display display;
    private Language language;

    // Construct a new MessagePresenter
    public MessagePresenter(MessageCatalog catalog, Display display, Language language) {
        this.catalog = catalog;
        this.display = display;
        this.language = language;
    }

    /**
     * Set a language to the specified language
     * @param language language that overwrites the previous language
     */
    public void setLanguage(Language language) {
        this.language = language;
    }

    /**
     * Display a message for a specific key.
     * @param key key that identifies the message to be displayed.
     */
    public void show(MessageKey key) {
        display.render(catalog.getMessage(language, key));
    }

    // Additional detail for station name, trip fare, etc
    public void show(MessageKey key, String detail) {
        display.render(catalog.getMessage(language, key) + " " + detail);
    }
}
