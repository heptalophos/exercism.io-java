public class ElonsToyCar {
    private int distance = 0;
    private int battery = 100;

    public static ElonsToyCar buy() {
        return new ElonsToyCar();    
    }

    public String distanceDisplay() {
        String distanceDriven = String.format("Driven %d meters", distance);
        return distanceDriven;
    }

    public String batteryDisplay() {
        String batteryCharge = "Battery empty";
        if (battery > 0)
            batteryCharge = String.format("Battery at %d%%", battery);
        return batteryCharge;
    }

    public void drive() {
        if (battery > 0) {
            distance += 20;
            battery--;
        }
    }
}
