package re.netology;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String s) {
        super("Player " + s + " not found");
    }
}
