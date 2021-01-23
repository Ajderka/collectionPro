package set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class UsageSet {
    public static void main(String[] args) {
        Set<String> strings = new HashSet<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        strings.addAll(List.of("one", "four", "five"));

        Set<String> strings1 = Set.of("1", "2", "3");
        for (String s : strings1) {
            System.out.println(s);
        }

        Iterator<String> it = strings.iterator();
        while (it.hasNext()) {
            System.out.println("Current item: " + it.next());
        }

        strings.remove("two");
        System.out.println("Out in console after delete item...");
        for (String s : strings) {
            System.out.println("Current item: " + s);
        }

        strings.removeAll(List.of("two", "three"));
        System.out.println("Out in console after delete item...");
        for (String s : strings) {
            System.out.println("Current item: " + s);
        }

        strings.removeIf(s -> s.startsWith("f"));
        System.out.println("Out in console after delete item...");
        for (String s : strings) {
            System.out.println("Current item: " + s);
        }

        boolean b = strings.contains("two");
        System.out.println(b);

        strings.add("one");
        strings.add("two");
        strings.add("three");

        strings.stream()
                .filter(s -> s.length() < 4)
                .forEach(st -> System.out.println("Current element: " + st));
    }
}
