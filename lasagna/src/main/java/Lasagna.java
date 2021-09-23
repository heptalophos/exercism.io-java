public class Lasagna {

    private static final int COOKING_TIME = 40;
    private static final int LAYER_PREP = 2;
    
    public int expectedMinutesInOven() {
        return COOKING_TIME;
    }

    public int remainingMinutesInOven(int timeAlreadyInOven) {
        return expectedMinutesInOven() - timeAlreadyInOven;
    }

    public int preparationTimeInMinutes(int numberOfLayers) {
        return LAYER_PREP * numberOfLayers;
    }
    
    public int totalTimeInMinutes(int numberOfLayers, int timeAlreadyInOven) {
        int preBakingTime = LAYER_PREP * numberOfLayers;
        return preBakingTime + timeAlreadyInOven;
    }
}
