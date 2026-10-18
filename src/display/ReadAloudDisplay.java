package display;

public class ReadAloudDisplay implements Display {
    private Display inner;

    public ReadAloudDisplay(Display inner) {
        this.inner = inner;
    }

    @Override
    public void render(String text) {
        inner.render(text);                             // show in phone app or station kiosk format
        System.out.println("[Read aloud] " + text);     // show in text to speech
    }
}
