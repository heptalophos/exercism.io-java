import java.util.stream.Stream;

class Triangle {

    private final long uniqSides;
    private final long EQUILATERAL = 1;
    private final long ISOSCELES = 2;
    private final long SCALENE = 3;


    Triangle(double side1, double side2, double side3) throws TriangleException {
        boolean positiveSides = side1 > 0 && side2 > 0 && side3 > 0;
        boolean triangleInequality = side1 + side2 >= side3 
                                  && side2 + side3 >= side1 
                                  && side1 + side3 >= side2;  
        boolean degenerate = side1 + side2 == side3
                          || side2 + side3 == side1
                          || side1 + side3 == side2;

        if (!positiveSides) throw new TriangleException("All sides of a triangle should be positive.");
        if (!triangleInequality)  throw new TriangleException("Not valid triangle. Triangle Inequality doesn't hold.");
        if (degenerate)  throw new TriangleException("Degenerate triangle.");

        uniqSides = Stream.of(side1, side2, side3).distinct().count();
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
