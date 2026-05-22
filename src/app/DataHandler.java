package app;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DataHandler {

    Map<Integer, String> map = new DataRepository().getData();

    // The method forms the display of a numbered sequence of names
    public String getAll() {
        StringBuilder sb = new StringBuilder();
        AtomicInteger count = new AtomicInteger(0);
        map.forEach((id, name) ->
                sb.append(String.format("%d) %d, %s%n",
                        count.incrementAndGet(), id, name)
                ));
        return "\nALL NAMES:\n" + sb;
    }

    // The method forms the display of the name behind the song id
    public String getById(int id) {
        if (map.containsKey(id)) {
            return "\nNAME: id " + id + ", " + map.get(id);
        } else {
            return "\nNo data!";
        }
    }
}