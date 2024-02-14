import java.util.Random;

class CaptainsLog {

    private static final char[] PLANET_CLASSES = 
        new char[]{'D', 'H', 'J', 'K', 'L', 'M', 'N', 'R', 'T', 'Y'};

    private Random random;

    CaptainsLog(Random random) {
        this.random = random;
    }

    char randomPlanetClass() {
        var randomPlanet = this.random.nextInt(PLANET_CLASSES.length);
        return PLANET_CLASSES[randomPlanet];
    }

    String randomShipRegistryNumber() {
        return String.format("NCC-%d", 1000 + random.nextInt(9000));
    }

    double randomStardate() {
        return 41000D + 1000D * random.nextDouble();
    }
}
