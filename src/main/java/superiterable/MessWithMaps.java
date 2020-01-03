package superiterable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MessWithMaps {
  public static void main(String[] args) {
    Map<String, String> names = new HashMap<>();
    names.put("Fred", "Jones");

    String FIRST = "Fred";

    String last = names.get(FIRST);
    if (last != null) {
      String message = "Dear " + last.toUpperCase();
      System.out.println(message);
    }

    System.out.println("----------------------");
    SuperIterable<Map<String, String>> n2 =
        new SuperIterable<>(Arrays.asList(names));
    n2
        .map(m -> m.get(FIRST))
        .map(s -> s.toUpperCase())
        .map(s -> "Dear " + s)
        .forEach(s -> System.out.println(s));

    System.out.println("----------------------");
    Optional<Map<String, String>> omss = Optional.of(names);
    omss
        .map(m -> m.get(FIRST))
        .map(s -> s.toUpperCase())
        .map(s -> "Dear " + s)
        .ifPresent(s -> System.out.println(s));

  }
}
