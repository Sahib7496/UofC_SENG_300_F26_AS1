package display;

/**
 * Implementation of Display class that adds a text-to-speech feature to a display.
 */
public class ReadAloudDisplay implements Display {
    private Display inner;

    // Constructor
    public ReadAloudDisplay(Display inner) {
        this.inner = inner;
    }

    /**
     * render the text to the display and the text to speech
     * @param text
     */
    @Override
    public void render(String text) {
        inner.render(text);                             // show in phone app or station kiosk format
        System.out.println("[Read aloud] " + text);     // show in text to speech
    }
}
