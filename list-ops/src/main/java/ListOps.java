import java.util.List;
import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import static java.util.Collections.list;
import static java.util.Collections.unmodifiableList;
import static java.util.Collections.emptyList;
import static java.util.Collections.enumeration;

class ListOps {

    static <T, U> U foldLeft(List<T> list, U initial, BiFunction<U, T, U> f) {
        if (list.isEmpty()) { return initial; }
        return foldLeft(tail(list), f.apply(initial, head(list)), f);
    }

    static <T, U> U foldRight(List<T> list, U initial, BiFunction<T, U, U> f) {
        if (list.isEmpty()) { return initial; }
        return f.apply(head(list), foldRight(tail(list), initial, f));
    }
    
    // ..and the rest in terms of the 2 folds

    static <T> List<T> append(List<T> list1, List<T> list2) {
        return foldLeft(list2, list(enumeration(list1)),
                        (acc, x) -> { acc.add(x); return acc; });
    }

    static <T> List<T> concat(List<List<T>> listOfLists) {
        return foldRight(listOfLists, emptyList(), ListOps::append);
    }

    static <T> List<T> reverse(List<T> list) {
        return foldRight(list, new ArrayList<T>(), 
                         (x, acc) -> {acc.add(x); return acc;});
    }

    static <T> int size(List<T> list) {
        return foldLeft(list, 0, (acc, _x) -> acc + 1);
    }

    static <T, U> List<U> map(List<T> list, Function<T, U> transform) {
        return foldLeft(list, new ArrayList<>(), 
                        (acc, x) -> { acc.add(transform.apply(x));
                                      return acc;
                                    });
    }
    
    static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        return foldLeft(list, new ArrayList<T>(), 
                        (acc, x) -> { if (predicate.test(x)) acc.add(x);
                                      return acc;
                                    });
    }

    // -- Auxiliary fcns
    private static <T> T head(final List<T> list) {
        return list.get(0);
    }

    private static <T> List<T> tail(final List<T> list) {
        List<T> xs = new ArrayList<T>();
        xs.addAll(0, list.subList(1, list.size()));
        return unmodifiableList(xs);
    }
    // Auxiliary fcns -- 

    private ListOps() {
        // No instances.
    }

}
