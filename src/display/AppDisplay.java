package display;

/**
 * Implementation to display which shows output on the console as a stand-in for the app.
 */
public class AppDisplay implements Display {
    /**
     * Prints the text onto the console.
     * @param text text to be displayed to the app user.
     */
    @Override
    public void render(String text) {
        System.out.println("[App] " + text);    // stand-in for showing on phone app
    }
}
