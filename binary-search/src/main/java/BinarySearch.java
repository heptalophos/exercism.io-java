import java.util.List;

public class BinarySearch <T extends Comparable<T>> {

    private final List<T> list;

    public BinarySearch(List<T> list) {
        this.list = list;
    }

    public int indexOf(T value) throws ValueNotFoundException{
        int min = 0; 
        int max = list.size() - 1;
        while (min <= max) {
            int mid = (min + max) >> 1;
            int diff = value.compareTo(list.get(mid));
            if (diff < 0) max = mid - 1;
            if (diff > 0) min = mid + 1;
            if (diff == 0) return mid;
        }
        throw new ValueNotFoundException("Value not in array");
    }
}
