class Darts {

    Darts() {}

    int score(double x, double y) {
        int points = 0;
        double r = Math.sqrt(x*x + y*y);
        if (r <= 10) points += 1;
        if (r <= 5)  points += 4;
        if (r <= 1)  points += 5;
        return points;
    }

}
