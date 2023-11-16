public class Darts {
    public int score(double x, double y) {
        double r = x*x + y*y;
        int points = 0;
        if (r <= 100) {points += 1;}
        if (r <= 25)  {points += 4;}
        if (r <= 1)   {points += 5;}
        return points;
    }
}
