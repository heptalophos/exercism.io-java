import java.util.LinkedList;
import java.util.List;

class VariableLengthQuantity {
    private static final int XTET_MSBIT  = 0x80;
    private static final int XTET_MASK   = 0x7F; 
    private static final int XTET_OFFSET = 7;

    List<String> encode(List<Long> numbers) {
        LinkedList<String> bytes = new LinkedList<>();
        numbers.iterator()
               .forEachRemaining(
                    b -> {
                        LinkedList<String> blist = new LinkedList<String>();
                        blist.addLast(String.format("0x%x", b & XTET_MASK));
                        b >>= XTET_OFFSET;
                        while (b > 0) {
                            long next = b & XTET_MASK; 
                            next |= XTET_MSBIT;
                            blist.addFirst(String.format("0x%x", next));
                            b >>= XTET_OFFSET;
                        }
                        bytes.addAll(blist);
                    }
                );
        return bytes;
    }

    List<String> decode(List<Long> bytes) throws IllegalArgumentException {
        if ((bytes.get(bytes.size() - 1) & XTET_MSBIT) != 0) {
            throw new IllegalArgumentException(
                "Invalid variable-length quantity encoding"
            );
        }
        LinkedList<String> number = new LinkedList<>();
        long n = 0x0L;
        for (long b : bytes) {
            n <<= XTET_OFFSET;
            n |= b & XTET_MASK;
            if ((b & XTET_MSBIT) == 0) {
                number.addLast(String.format("0x%x", n));
                n = 0x0L;
            }
        }
        return number;
    }
}
 