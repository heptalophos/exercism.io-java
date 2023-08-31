import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

import java.util.Collections;

public class TestTrack {
    public static void race(RemoteControlCar car) {
        car.drive();
        car.getDistanceTravelled();
    }
    public static List<ProductionRemoteControlCar> 
                  getRankedCars(List<ProductionRemoteControlCar> cars) 
    {
        return cars.stream().sorted()
                   .collect(toList());
    }
}