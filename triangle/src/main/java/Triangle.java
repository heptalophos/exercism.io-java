import java.util.stream.Stream;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Triangle {

    private final List<Double> sides;
    private final long uniqSides;
    private final long EQUILATERAL = 1;
    private final long ISOSCELES = 2;
    private final long SCALENE = 3;

    private static final String[] Errors = {
        "All sides of a triangle should be positive.",
        "Triangle Inequality doesn't hold.",
        "Degenerate triangle."
    };


    Triangle(double s1, double s2, double s3) throws TriangleException {
        
        this.sides = Arrays.asList(s1, s2, s3);
        
        boolean anySideZero = sides.stream().anyMatch(x -> x <= 0);
        boolean triangleInequality = 2 * Collections.max(sides, null) < 
                                     sides.stream().reduce(0.0, Double::sum);   
        boolean degenerate = 2 * Collections.max(sides, null) == 
                             sides.stream().reduce(0.0, Double::sum);
                             
        if (anySideZero) 
            throw new TriangleException(Errors[0]);
        if (!triangleInequality)  
            throw new TriangleException(Errors[1]);
        if (degenerate)  
            throw new TriangleException(Errors[2]);

        uniqSides = Stream.of(s1, s2, s3) .distinct().count();
    }

    boolean isEquilateral() {
        return uniqSides == EQUILATERAL;
    }

    boolean isIsosceles() {
        return uniqSides <= ISOSCELES;
    }

    boolean isScalene() {
        return uniqSides == SCALENE;
    }
}
