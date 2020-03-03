import java.util.stream.IntStream;

class NaturalNumber {

    private final int number;

    public NaturalNumber (int number) {
        if (number <= 0) 
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        this.number = number;
    }

    public Classification getClassification() {
        final int aliquot = aliquotSum();

        if (aliquot == number) return Classification.PERFECT;
        else if (aliquot > number) return Classification.ABUNDANT;
        else return Classification.DEFICIENT;  
    }

    private int aliquotSum () {
        return IntStream.range(1, number)
                        .filter (i -> number % i == 0)
                        .reduce(0, (a, b) -> a + b);
    }
}
