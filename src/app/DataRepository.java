package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class DataRepository {

    private final Map<Long, User> usersByIdMap = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public User save(User user) {
        if (user.getId() == null) {
            long newId = idGenerator.getAndIncrement();
            user.setId(newId);
        }
        usersByIdMap.put(user.getId(), user);
        return user;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(usersByIdMap.values());
    }

    // The repository returns an object or null
    public User getUserById(Long id) {
        return usersByIdMap.get(id);
    }
}