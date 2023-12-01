public class PopCount {
    public int eggCount(int number) {
        if (number == 0) return 0;
        return number % 2 + eggCount(number / 2);
    }
}
