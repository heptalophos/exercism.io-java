import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Flattener {

    public List <?> flatten(final List<?> elements) {
        return elements
               .stream()
               .filter(Objects::nonNull)
               .flatMap(this::flatten)
               .collect(Collectors.toList());
    }

    private Stream<?> flatten(final Object element) {
        return (element instanceof List) ?
               flatten((List<?>) element).stream() :
               Stream.of(element);
    }
}
