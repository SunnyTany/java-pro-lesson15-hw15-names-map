package app;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("User with ID %d not found!".formatted(id));
    }
}