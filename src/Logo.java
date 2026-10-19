public class Logo {
    private final String filePath;

    // Constructor
    public Logo(String filePath) {
        this.filePath = filePath;
    }

    // Getter
    public String getFilePath() {
        return filePath;
    }

    @Override
    public String toString() {
        return filePath;
    }
}
