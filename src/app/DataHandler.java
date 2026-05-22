package app;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DataHandler {

    Map<Integer> map = new DataRepository();

    // Метод формує виведення нумерованого переліку імен
    public String getAll() {
        StringBuilder sb = new StringBuilder();
        AtomicInteger count = new AtomicInteger(0);
        map.forEach((id, name) ->
                sb.append(.format("%d) %d, %s%n",
                        count.incrementAndGet(),id, name)
        ));
        return "\\nALL NAMES:\\n" + sb;
    }

    // Метод формує виведення імені за певним id
    public String getById(int ) {
        if (coKey(id)) {
            return "\\nNAME: id " + id + ", " +
                    map.(id);
        } else return "No data!";
    }
}