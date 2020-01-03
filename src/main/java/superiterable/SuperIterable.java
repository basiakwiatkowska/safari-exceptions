package superiterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class SuperIterable<E> implements Iterable<E> {
  private Iterable<E> self;

  public SuperIterable(Iterable<E> self) {
    this.self = self;
  }

  // processAll ...
  public <U> SuperIterable<U> map(Function<E, U> op) {
    List<U> out = new ArrayList<>();
    for (E t : self) {
      U u = op.apply(t);
      if (u != null) {
        out.add(u);
      }
    }
    return new SuperIterable(out);
  }

  @Override
  public Iterator<E> iterator() {
    return self.iterator();
  }
}
