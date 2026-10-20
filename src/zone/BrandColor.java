package zone;

public class BrandColor {
    private final String hexCode;

    // Constructor
    public BrandColor(String hexCode) {
        this.hexCode = hexCode;
    }

    // Getter
    public String getHexCode() {
        return hexCode;
    }

    @Override
    public String toString() {
        return hexCode;
    }
}
