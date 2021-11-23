public class CarsAssemble {

    private final int CARS_PER_HOUR = 221;

    public double productionRatePerHour(int speed) {
        int production = speed * CARS_PER_HOUR;
        double successRate = 
                speed <= 0 ? 0d : 
                speed > 0 && speed <= 4 ? 1.0 : 
                speed > 4 && speed <= 8 ? 0.9 : 
                speed == 9 ? 0.8 : 
                speed == 10 ? 0.77 : 0d;
        return successRate * production;
    }

    public int workingItemsPerMinute(int speed) {
        return (int) (productionRatePerHour(speed) / 60d);
    }
}
