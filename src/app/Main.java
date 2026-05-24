package app;

public class Main {

    public static void main(String[] args) {
        DataRepository repository = new DataRepository();
        DataHandler handler = new DataHandler(repository);
        UIOperator uiOperator = new UIOperator();

        // 1. Adding users dynamically
        uiOperator.getOutput(handler.createUser("Lucy"));
        uiOperator.getOutput(handler.createUser("Alice"));
        uiOperator.getOutput(handler.createUser("Bob"));
        uiOperator.getOutput(handler.createUser("Tom"));

        // 2. Display the entire list
        uiOperator.getOutput(handler.getAll());

        // 3. Looking for an existing user (for example, with automatic ID = 2)
        uiOperator.getOutput(handler.getById(2L));

        // 4. Checking error handling - user does not exist
        uiOperator.getOutput(handler.getById(99L));
    }
}