import java.util.stream.IntStream;

class AffineCipher {

    private static final int EM = 26;   //universe->size
    private static final char A = 'a';  //universe->head

    private static final String NOT_COPRIME =
        "Error: keyA and alphabet size must be coprime.";

    String encode(String plaintext, int k1, int k2) {
        mmi(k1, EM);
        return streamed(plaintext)
               .map(x -> Character.isDigit(x) 
                         ? x 
                         : (k1 * (x - A) + k2) % EM + A)
               .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
               .toString().replaceAll("\\G.{0,5}", " $0")
               .trim();
    }

    String decode(String ciphertext, int k1, int k2) {
        int mmi = mmi(k1, EM);
        return streamed(ciphertext)
               .map(x -> Character.isDigit(x) 
                         ? x 
                         : mmi * (x - A + (EM * k2) - k2) % EM + A)
               .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
               .toString();
    }

    private static int mmi(int x, int n) {
        int r0 = n; int r1 = x; 
        int t0 = 0; int t1 = 1;
        while (r1 != 0) {
            int r = r1; int t = t1;
            int q = r0 / r1; 
            r1 = r0 - r * q; 
            t1 = t0 - t * q; 
            r0 = r; t0 = t;
        }
        if (t0 < 0) t0 += n;
        if (r0 > 1) 
            throw new IllegalArgumentException(NOT_COPRIME);
        return t0;
    }

    private static IntStream streamed(String text) {
        return text.toLowerCase().codePoints()
               .filter(Character::isLetterOrDigit);
    }
}
