package superiterable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

// Consumer is pretty much this:
//interface Processor<E> {
//  void accept(E e);
//}

// Function
//interface Fuction<T, U> {
//  U apply(T t);
//}
class Printer implements Consumer<String> {
  @Override
  public void accept(String s) {
    System.out.println("> " + s);
  }
}

public class UseSuperIterable {
  public static <T> void forEvery(List<T> l, Consumer<T> p) {
    for (T t : l) {
      p.accept(t);
    }
  }

  public static <T, U> List<U> processAll(List<T> l, Function<T, U> op) {
    List<U> out = new ArrayList<>();
    for (T t : l) {
      out.add(op.apply(t));
    }
    return out;
  }

  public static void main(String[] args) {
    List<String> names = Arrays.asList("Fred", "Jim", "Sheila");

    forEvery(names, new Printer());
    forEvery(names, (s) -> System.out.println(">>> " + s));
    forEvery(processAll(names, s -> s.toUpperCase()), (s) -> System.out.println("++ " + s));

    new SuperIterable<String>(names)
        .map(s -> s.toUpperCase())
        .forEach(s -> System.out.println("-+- " + s));
  }
}
