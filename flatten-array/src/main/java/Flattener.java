import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Flattener {

    public List <?> flatten(List<?> listOfLists) {
        return listOfLists.stream()
                          .filter(o -> o != null)
                          .flatMap(this::flatten)
                          .collect(Collectors.toList());
    }

    private Stream<?> flatten(Object element) {
        return (element instanceof List) ?
               flatten((List<?>) element).stream() :
               Stream.of(element);
    }
}
