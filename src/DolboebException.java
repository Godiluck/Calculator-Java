public class DolboebException extends Exception {
    public DolboebException(String description) {
        super("Долбоеб, " + description + "!");
    }
}
