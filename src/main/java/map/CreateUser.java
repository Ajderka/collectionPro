package map;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class CreateUser {
    public static void main(String[] args) {
        Map<User, Object> map = new HashMap<>();
        User one = new User("Olya", 2, new GregorianCalendar(1987, 0, 23));
        User two = new User("Olya", 2, new GregorianCalendar(1987, 0, 23));
        map.put(one, 1);
        map.put(two, 1);
        for (User u: map.keySet()) {
            System.out.println(u);
        }
    }
}