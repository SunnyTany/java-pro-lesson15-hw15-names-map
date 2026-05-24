package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class DataRepository {

    // Thread-safe map for storing users
    private final Map<Long, User> usersByIdMap = new ConcurrentHashMap<>();

    // Unique ID generator (starting with 1)
    private final AtomicLong idGenerator = new AtomicLong(1);

    // Method for saving or updating a user
    public User save(User user) {
        if (user.getId() == null) {
            // Generate a new unique ID if the user is new
            long newId = idGenerator.getAndIncrement();
            user.setId(newId);
        }
        usersByIdMap.put(user.getId(), user);
        return user;
    }

    public List<User> getAllUsers() {
        // We return a copy of the list to protect the internal map from external changes
        return new ArrayList<>(usersByIdMap.values());
    }

    public User getUserById(Long id) {
        User user = usersByIdMap.get(id);
        if (user == null) {
            throw new UserNotFoundException(id);
        }
        return user;
    }
}