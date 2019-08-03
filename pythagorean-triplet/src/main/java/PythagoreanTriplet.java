
public class PythagoreanTriplet {

    private final int sideA;
    private final int sideB;
    private final int sideC;


    PythagoreanTriplet(int a, int b, int c) {
        this.sideA = a;
        this.sideB = b;
        this.sideC = c;
    }
 
    public static PythagoreanTripletGen makeTripletsList() {
        return new PythagoreanTripletGen();
    }
    
    @Override
    public boolean equals(Object that) {
        if (that == null || !(that instanceof PythagoreanTriplet)) 
            return false;
        return sideA == ((PythagoreanTriplet) that).sideA &&
               sideB == ((PythagoreanTriplet) that).sideB &&
               sideC == ((PythagoreanTriplet) that).sideC;
    }
}