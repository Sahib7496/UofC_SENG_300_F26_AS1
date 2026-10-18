package display;

public class AppDisplay implements Display {
    @Override
    public void render(String text) {
        System.out.println("[App] " + text);
    }
}
