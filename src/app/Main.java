package app;

public class Main {

    public static void main(String[] args) {
        DataRepository repository = new DataRepository();
        DataHandler handler = new DataHandler(repository);
        UIOperator uiOperator = new UIOperator();

        // 1. Dynamically adding all four users
        uiOperator.getOutput(handler.createUser("Lucy"));   // Отримає ID 1
        uiOperator.getOutput(handler.createUser("Alice"));  // Отримає ID 2
        uiOperator.getOutput(handler.createUser("Bob"));    // Отримає ID 3
        uiOperator.getOutput(handler.createUser("Tom"));    // Отримає ID 4

        // 2. Displaying a complete list of users
        uiOperator.getOutput(handler.getAll());

        // 3. Looking for an existing user
        try {
            uiOperator.getOutput(handler.getById(4L));
        } catch (UserNotFoundException e) {
            uiOperator.getOutput("\nError: %s".formatted(e.getMessage()));
        }

        // 4. Trying to find a non-existent user (catch block will be triggered)
        try {
            uiOperator.getOutput(handler.getById(99L));
        } catch (UserNotFoundException e) {
            uiOperator.getOutput("\nError: %s".formatted(e.getMessage()));
        }
    }
}