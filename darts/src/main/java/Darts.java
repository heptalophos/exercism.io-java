public class Darts {
    public int score(double x, double y) {
        double r = x*x + y*y;
        return r <= 1 
               ? 10 
               : r <= 25 
               ? 5 
               : r <= 100 
               ? 1 
               : 0;
    }
}
