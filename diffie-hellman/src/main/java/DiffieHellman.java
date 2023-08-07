import java.math.BigInteger;
import java.security.SecureRandom;

public class DiffieHellman {

    private final SecureRandom random = new SecureRandom();

    public BigInteger privateKey(BigInteger p) {
        BigInteger key = BigInteger.ZERO;
        while (key.compareTo(p) == 1 || key.compareTo(BigInteger.TWO) == -1 ) { 
            key = BigInteger.valueOf(random.longs(1, 1, p.longValue())
                                           .findFirst().orElseThrow());
        };
        return key;
    }

    BigInteger publicKey(BigInteger p, BigInteger g, BigInteger privKey) {
        return g.modPow(privKey, p);
    }

    BigInteger secret(BigInteger p, BigInteger pubKey, BigInteger privKey) {
        return pubKey.modPow(privKey, p);
    }
}