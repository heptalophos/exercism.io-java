import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;
import static java.util.Comparator.comparingInt;

public class TestTrack {
    public static void race(RemoteControlCar car) {
        car.drive();
        car.getDistanceTravelled();
    }
    public static List<ProductionRemoteControlCar> 
                  getRankedCars(ProductionRemoteControlCar prc1,
                                ProductionRemoteControlCar prc2) {
        return Stream.of(prc1, prc2)
                     .sorted(
                         comparingInt(
                            ProductionRemoteControlCar::getNumberOfVictories
                         )
                      )
                     .collect(toList());
    }
}
