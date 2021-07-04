public class RailFenceCipher {
    
    private final int rails;

    RailFenceCipher(final int rails) {
        this.rails = rails;
    } 

    String getEncryptedData(String plain) {
        return transposition(plain, 1);
    }

    String getDecryptedData(String cipher) {
        return transposition(cipher, 0);
    }

    private String transposition(String text, int encrypt) {
        char[] transposed = new char[text.length()];
        char[] original = text.toCharArray();
        int p = 0;
        for (int r = 0; r < rails; r++) {
            int i = r; int direction = 0;
            while (i < original.length) {
                if (encrypt != 1)
                    transposed[i] = original[p];
                else 
                    transposed[p] = original[i];
                p += 1;
                if (r != 0 && r != rails - 1)
                    if (direction == 0) {
                        i += (rails - r - 1) * 2;
                        direction += 1;
                    } 
                    else {
                        i += r * 2;
                        direction -= 1;
                    }
                else 
                    i += (rails - 1) * 2;
            }
        }
        return new String(transposed);
    }
}
