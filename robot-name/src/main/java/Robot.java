import java.util.Set;
import java.util.HashSet;
import java.util.Random;

import static java.lang.String.format;

class Robot {
    
    private String name;
    private static final Set<String> used = 
                                new HashSet<>();
    private static final Random random = 
                                new Random();

    String getName() {
        if (name == null) {
            name = generateName();
        }
        return name;
    }

    void reset() {
        name = null;
    }

    private static String generateName() {
        String newName = null;
        while (newName == null) {
            newName = 
                format("%s%3d", randomAlpha(2), 
                                random.nextInt(1000));
            if (used.contains(newName)) {
                newName = null;
            }
        }
        used.add(newName);
        return newName;
    }

    private static String randomAlpha(int length) {
        String randString = "";
        for (int i = 0; i < length; i++)
            randString += 
                Character.toString(
                    (char) random.nextInt(26) + ((int)'A')
                );
        return randString; 
    }
}
