public class EliudsEggs {
    public int eggCount(int number) {
        int eggs = 0;
        while (number > 0) {
            if (~(~number | ~1) != 0) eggs += 1;
            number >>= 1;
        }
        return eggs;
    }
}
