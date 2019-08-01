public class PythagoreanTriplet {

    private final int alpha;
    private final int bravo;
    private final int charlie;


    PythagoreanTriplet(int a, int b, int c) {
        alpha = a;
        bravo = b;
        charlie = c;
    }

    int calculateSum() {
        return alpha + bravo + charlie;
    }

    int calculateProduct() {
        return alpha * bravo * charlie;
    }

    boolean isPythagorean() {
        if (alpha * alpha + bravo * bravo == charlie * charlie)
            return true;
        return false;
	}

}