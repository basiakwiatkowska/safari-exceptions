package usestream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

interface ExFunction<A, B> {
  B apply(A a) throws Throwable;
}

public class DoFiles {

  public static <A, B> Function<A, Optional<B>> wrap(ExFunction<A, B> op) {
    return a -> {
      try {
        return Optional.of(op.apply(a));
      } catch (Throwable throwable) {
        return Optional.empty();
      }
    };
  }

  public static Optional<Stream<String>> getLines(String filename) {
    try {
      return Optional.of(Files.lines(Paths.get(filename)));
    } catch (IOException e) {
      return Optional.empty();
    }
  }

  public static void main(String[] args) {
//    try {
    Stream.of("in.txt", "bad.txt", "out.txt")
//          .flatMap(s -> Files.lines(Paths.get(s)))
//        .map(f -> getLines(f))
        .map(wrap(f -> Files.lines(Paths.get(f))))
        .peek(opt -> {
          if (!opt.isPresent()) {
            System.out.println("That broke!");
          }
        })
        .filter(opt -> opt.isPresent())
        .flatMap(opt -> opt.get())
        .forEach(s -> System.out.println(s));
//    } catch (IOException ioe) {}
  }
}
