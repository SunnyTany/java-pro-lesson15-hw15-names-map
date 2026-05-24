package app;

import java.util.List;

public class DataHandler {

    private final DataRepository dataRepository;

    public DataHandler(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public String createUser(String name) {
        User newUser = new User(name);
        User savedUser = dataRepository.save(newUser);
        return "\nUser created successfully: ID %d, Name: %s".formatted(savedUser.getId(), savedUser.getName());
    }

    public String getAll() {
        StringBuilder sb = new StringBuilder();
        List<User> users = dataRepository.getAllUsers();

        if (users.isEmpty()) {
            return "\nALL NAMES:\nNo users registered yet.";
        }

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            sb.append("%d) %d, %s%n".formatted(i + 1, user.getId(), user.getName()));
        }
        return "\nALL NAMES:\n" + sb;
    }

    public String getById(Long id) {
        try {
            User user = dataRepository.getUserById(id);
            return "\nNAME: id %d, %s".formatted(user.getId(), user.getName());
        } catch (UserNotFoundException e) {
            return "\nError: %s".formatted(e.getMessage());
        }
    }
}