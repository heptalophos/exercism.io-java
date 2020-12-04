import java.util.Random;
import java.util.stream.IntStream;

class Cipher {

    private String key;

    Cipher() {
        this.key = generateKey();
    }

    Cipher(String key) {
        if (key.length() < 1)
            throw new IllegalArgumentException();
        
        if (!key.matches("^[a-z]+$"))
            throw new IllegalArgumentException();

        this.key = key;
    }

    String getKey() {
        return this.key;
    }

    String encode(final String plain) {
		return xcode(plain, 1);
	}

	String decode(final String cipher) {
		return xcode(cipher, -1);
	}

    private String xcode(final String txt, int dir) {
        return IntStream.range(0, txt.length())
                        .mapToObj(i -> 
                                  shift(txt.charAt(i), i, dir))
                        .collect(StringBuilder::new,
                                 StringBuilder::appendCodePoint,
                                 StringBuilder::append)
                        .toString();
    }

    private int shift(char c, int p, int d) {
        int rot = key.charAt(p % key.length()) - 'a';
        int shift = 
            Math.floorMod((int)c + d * rot - (int)'a', 26);
        return 'a' + shift;
    }

    private static String generateKey() {
        Random r = new Random();
        return r.ints('a', 'z')
                .limit(100)
                .collect(StringBuilder::new,
                         StringBuilder::appendCodePoint,
                         StringBuilder::append)
                .toString();
    }
}
