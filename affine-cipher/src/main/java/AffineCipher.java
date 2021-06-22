class AffineCipher {

    private static final int EM = 26;
    private static final char A = 'a';

    private static final String NOT_COPRIME =
        "Error: keyA and alphabet size must be coprime.";

    String encode(String plaintext, int a, int b) {
        mmi(a, EM);
        return plaintext
               .toLowerCase()
               .codePoints()
               .filter(Character::isLetterOrDigit)
               .map(c -> Character.isDigit(c) ? 
                         c                    :
                         (a * (c - A) + b) % EM + A)
                .collect(StringBuilder::new,
                         StringBuilder::appendCodePoint,
                         StringBuilder::append)
                .toString()
                .replaceAll("(?<=\\G.{5})", " $0")
                .trim();
    }

    String decode(String ciphertext, int a, int b) {
        int mmi = mmi(a, EM);
        return ciphertext
               .toLowerCase()
               .codePoints()
               .filter(Character::isLetterOrDigit)
               .map(c -> Character.isDigit(c) ? 
                         c                    :
                         mmi * (c - A + (EM * b) - b) % EM + A)
                .collect(StringBuilder::new,
                         StringBuilder::appendCodePoint,
                         StringBuilder::append)
                .toString();
    }

    private int mmi(int a, int n) {
        int r0 = n; 
        int r1 = a; 
        int t0 = 0; 
        int t1 = 1;
        while (r1 != 0) {
            int r = r1; 
            int t = t1;
            int q = r0 / r1; 
            r1 = r0 - r * q; 
            t1 = t0 - t * q; 
            r0 = r; t0 = t;
        }
        if (r0 > 1)
            throw new IllegalArgumentException(NOT_COPRIME);
        if (t0 < 0)
            t0 += n;
        return t0;
    }
}
