import java.util.stream.Stream;

class Triangle {

    private final long uniqSides;

    Triangle(double side1, double side2, double side3) throws TriangleException {
        boolean positiveSides = side1 > 0 && side2 > 0 && side3 > 0;
        boolean triangleInequality = side1 + side2 >= side3 
                                  && side2 + side3 >= side1 
                                  && side1 + side3 >= side2;  
        boolean degenerate = side1 + side2 == side3
                          || side2 + side3 == side1
                          || side1 + side3 == side2;
        boolean isTriangle = positiveSides && triangleInequality && !degenerate;
        if ( !isTriangle ) {
            throw new TriangleException();
        }
        uniqSides = Stream.of(side1, side2, side3).distinct().count();
    }

    boolean isEquilateral() {
        return uniqSides == 1;
    }

    boolean isIsosceles() {
        return uniqSides <= 2;
    }

    boolean isScalene() {
        return uniqSides == 3;
    }
}
