import java.util.stream.Stream;

class Triangle {

    private final long uniqSides;
    private final long EQUILATERAL = 1;
    private final long ISOSCELES = 2;
    private final long SCALENE = 3;

    private static final String[] Errors = {
        "All sides of a triangle should be positive.",
        "Triangle Inequality doesn't hold.",
        "Degenerate triangle."
    };


    Triangle(double s1, double s2, double s3) 
        throws TriangleException {
        
        boolean positiveSides = 
                s1 > 0 && s2 > 0 && s3 > 0;

        boolean triangleInequality = 
                s1 + s2 >= s3 && 
                s2 + s3 >= s1 && 
                s1 + s3 >= s2;  
        
        boolean degenerate = 
                s1 + s2 == s3 || 
                s2 + s3 == s1 || 
                s1 + s3 == s2;

        if (!positiveSides) 
            throw new TriangleException(Errors[0]);
        if (!triangleInequality)  
            throw new TriangleException(Errors[1]);
        if (degenerate)  
            throw new TriangleException(Errors[2]);

        uniqSides = 
            Stream.of(s1, s2, s3)
                  .distinct()
                  .count();
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
