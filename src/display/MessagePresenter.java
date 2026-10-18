package display;

public class MessagePresenter {
    private MessageCatalog catalog;
    private Display display;
    private Language language;

    public MessagePresenter(MessageCatalog catalog, Display display, Language language) {
        this.catalog = catalog;
        this.display = display;
        this.language = language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void show(MessageKey key) {
        display.render(catalog.getMessage(language, key));
    }

    // Additional detail for station name, trip fare, etc
    public void show(MessageKey key, String detail) {
        display.render(catalog.getMessage(language, key) + " " + detail);
    }
}
