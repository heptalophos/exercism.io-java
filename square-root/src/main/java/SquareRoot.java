public class SquareRoot {
    public int squareRoot(int radicand) {
        int min = 1;
        int max = radicand;
        int mid = min;
        while ( mid * mid != radicand ) {
            mid = (max + min) >> 1;
            if ( mid * mid > radicand ) max = mid;
            else min = mid;
        }            
        return mid;
    }
}
